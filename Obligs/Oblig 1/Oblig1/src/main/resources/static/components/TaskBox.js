console.log("Hello from Taskbox");
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