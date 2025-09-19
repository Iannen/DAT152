const template = document.createElement("template");
template.innerHTML = `
 <link rel="stylesheet" type="text/css"
 href="${import.meta.url.match(/.*\//)[0]}/styles/taskbox.css"/>
 <dialog>
 <!-- Modal content -->
 <span>&times;</span>
 <div>
 <div>Title:</div>
 <div>
 <input type="text" size="25" maxlength="80"
 placeholder="Task title" autofocus/>
 </div>
 <div>Status:</div><div><select></select></div>
 </div>
 <p><button type="submit">Add task</button></p>
 </dialog>
`;

class TaskBox extends HTMLElement{
    #shadow;
    #statuseslist;
    #newtaskCallback;

    constructor(){
        super();
        this.#shadow = this.attachShadow({mode:"closed"});
        this.#shadow.appendChild(template.content.cloneNode(true));
    }
    show(){
        this.#shadow.querySelector("dialog").showModal();
    }
    setStatuseslist(list){
        this.#statuseslist=list;
        
        for (let i = 1; i<=this.#statuseslist.length;i++){
            const option = document.createElement("option");
            option.text = this.#statuseslist[i-1];
            option.value=i;
            this.#shadow.querySelector("select").appendChild(option);
        }
    }
    newtaskCallback(callback){
        this.#newtaskCallback = callback;
        this.#shadow.querySelector("button").addEventListener("click",e=>{
            const title=this.#shadow.querySelector("input").value;
            this.#shadow.querySelector("input").value="";
            const status= this.#shadow.querySelector("select").value;
            this.#shadow.querySelector("select").value="WAITING";
            callback({title, status});
        })
    }

    close(){
        this.#shadow.querySelector("dialog").close();
    }
}
customElements.define("task-box", TaskBox);