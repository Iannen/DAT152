const template = document.createElement("template");
template.innerHTML = `
    <link rel="stylesheet" type="text/css" href="${import.meta.url.match(/.*\//)[0]}/tasklist.css"/>

    <div id="tasklist"></div>`;

const tasktable = document.createElement("template");
tasktable.innerHTML = `
    <table>
        <thead><tr><th>Task</th><th>Status</th></tr></thead>
        <tbody></tbody>
    </table>`;

const taskrow = document.createElement("template");
taskrow.innerHTML = `
    <tr>
        <td></td>
        <td></td>
        <td>
            <select>
                <option value="0" selected>&lt;Modify&gt;</option>
            </select>
        </td>
        <td><button type="button">Remove</button></td>
    </tr>`;

/**
  * TaskList
  * Manage view with list of tasks
  */
class TaskList extends HTMLElement {

    #shadow;
    #deleteCallback; 
    constructor() {
        super();
        
        this.#shadow=this.attachShadow({mode:"closed"});
        const content = template.content.cloneNode(true);
        this.#shadow.appendChild(content);

        // fetch("/TaskList/api/tasklist")
        //     .then(response =>{
        //         if (!response.ok){
        //             throw new Error("Failed to fetch tasklist")
        //         }                 
        //         return response.json();
        //     })
        //     .then(responseObject => {
        //         const tasks = responseObject.tasks;
        //         tasks.forEach(task => {
        //             this.showTask(task)
        //         });
        //     })
        /**
         * Fill inn rest of the code
         */
    }

    /**
     * @public
     * @param {Array} list with all possible task statuses
     */
    setStatuseslist(allstatuses) {
        /**
         * Fill inn the code
         */
    }

    /**
     * Add callback to run on change on change of status of a task, i.e. on change in the SELECT element
     * @public
     * @param {function} callback
     */
    changestatusCallback(callback) {
        /**
         * Fill inn the code
         */
    }

    /**
     * Add callback to run on click on delete button of a task
     * @public
     * @param {function} callback
     */
    deletetaskCallback(callback) {
        /**
         * Fill inn the code
         */
    }

    /**
     * Add task at top in list of tasks in the view
     * @public
     * @param {Object} task - Object representing a task
     */
    showTask(task) {
        /**
         * Fill inn the code
         */
        const root = this.#shadow.getElementById("tasklist");
        let table = root.querySelector("table");
        if (!table){    
            table = tasktable.content.cloneNode(true);
            root.appendChild(table); 
        }
        const tablerow = taskrow.content.cloneNode(true);
        const rowcolumns = tablerow.querySelectorAll("td");
        rowcolumns[0].textContent = task.title;
        rowcolumns[1].textContent = task.status;
        rowcolumns[3].querySelector("button").addEventListener("click", ()=>{
            #deleteCallback();
            this.removeTask(task.id);
        });
        table.prepend(tablerow);
    }

    /**
     * Update the status of a task in the view
     * @param {Object} task - Object with attributes {'id':taskId,'status':newStatus}
     */
    updateTask(task) {
        /**
         * Fill inn the code
         */
    }

    /**
     * Remove a task from the view
     * @param {Integer} task - ID of task to remove
     */
    removeTask(id) {
        /**
         * Fill inn the code
         */
    }

    /**
     * @public
     * @return {Number} - Number of tasks on display in view
     */
    getNumtasks() {
        /**
         * Fill inn the code
         */
    }
}
customElements.define('task-list', TaskList);
