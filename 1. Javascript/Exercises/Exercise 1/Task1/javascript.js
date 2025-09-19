const input = document.getElementsByTagName("input")[0];
const buttons = document.getElementsByTagName("button");
const pushbutton = buttons[0];
const popbutton = buttons[1];
const output = document.getElementsByTagName("p")[0];

const array = [];

pushbutton.addEventListener("click", ()=>{
    PushToArray();
});
input.addEventListener("keydown", (Event)=>{
    if (Event.key === "Enter") PushToArray();
});
popbutton.addEventListener("click", ()=>{
    console.log(array);
    const value = array.pop();
    if (value === undefined)
        output.textContent = "<No value to pop>";
    else
        output.textContent = value;
});

function PushToArray(){
    if (input.value === "")
        return;
    else {
        array.push(input.value);
        input.value = "";
    }
    console.log(array);
}