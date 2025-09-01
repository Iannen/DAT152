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

        this.#taskList = this.#shadow.querySelector("task-list");
        this.#taskBox = this.#shadow.querySelector("task-box");

        this.#getTasks();
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