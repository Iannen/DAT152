const template = document.createElement("template");
template.innerHTML = `
 <link rel="stylesheet" type="text/css"
 href="${import.meta.url.match(/.*\//)[0]}/styles/taskview.css"/>
 <h1>Tasks</h1>
 <div id="message"><p>Waiting for server data.</p></div>
 <div id="newtask">
 <button type="button" disabled>New task</button>
 </div>
 <!-- The task list -->
 <task-list></task-list>

 <!-- The Modal -->
 <task-box></task-box>
`;
class TaskView extends HTMLElement {
    #shadow;
    #taskList;
    #taskBox;

    constructor(){
        super();
        this.#shadow = this.attachShadow({mode:"closed"});
        this.#shadow.appendChild(template.content.cloneNode(true));

        this.#configureTaskList();
        this.#taskBox = this.#shadow.querySelector("task-box");

        this.#getTasks();
    }

    async #configureTaskList(){
        this.#taskList = this.#shadow.querySelector("task-list");

        try {
            const response = await fetch(`${this.dataset.serviceurl}/allstatuses`);
            if (!response.ok)
                throw new Error(`HTTP error, status ${response.status} `)
            const data = await response.json();
            if (data.responseStatus!==true)
                throw new Error("Error: responseStatus not 'true'");
            this.#taskList.setStatuseslist(data.allstatuses);
        }
        catch (error){
            console.log("Couldn't get statuseslist: ",error);
        }

        this.#taskList.changestatusCallback(async (id, newStatus)=>{
            const url = `${this.dataset.serviceurl}/task/${id}`;
            const reqOptions ={
                method: "PUT",
                headers: {"Content-Type": "application/json; charset=utf-8"},
                body: JSON.stringify({"status":newStatus})
            };
            try {    
                const response = await fetch(url, reqOptions);
                if (!response.ok)
                    throw new Error(`HTTP error, status ${response.status} `)

                const data = await response.json();
                if (data.responseStatus!==true)
                    throw new Error("Error: responseStatus not 'true'");

                this.#taskList.updateTask({id, newStatus})
            }
            catch (error){
                console.log("Couldn't update task: ",error)
            }
        })

        this.#taskList.deletetaskCallback(async id =>{
            const url = `${this.dataset.serviceurl}/task/${id}`;
            try {
                const response = await fetch(url,{method: "DELETE"});
                if (!response.ok)
                    throw new Error(`HTTP error, status ${response.status}`)
                const data = await response.json();
                if (data.responseStatus!==true)
                    throw new Error("Error: responseStatus not 'true'");
                this.#taskList.removeTask(id);
                this.updateHeaderMsg(this.#taskList.getNumtasks());
            }
            catch (error){
                console.log("Error deleting task: ",error);
            }
        })
    }
    #configureTaskBox(){
        
    }

    updateHeaderMsg(numTasks){
        const messageEle = this.#shadow.getElementById("message");
        if (numTasks<1)
            messageEle.textContent= `No tasks were found.`
        else
            messageEle.textContent= `Found ${numTasks} tasks.` 
    }

    async #getTasks(){
        const url = `${this.dataset.serviceurl}/tasklist`;
        const response = await fetch(url);
        const data = await response.json();
        this.updateHeaderMsg(data.tasks.length);
        data.tasks.forEach(task => {
            this.#taskList.showTask(task);
        });
    }
}
customElements.define("task-view", TaskView);