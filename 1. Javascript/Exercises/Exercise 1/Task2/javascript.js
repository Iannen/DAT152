const inps = document.getElementsByTagName("input");
const fra = inps[0];
const til = inps[1];
const out = document.getElementsByTagName("p")[0];
displayDays();
fra.addEventListener("change", ()=>{
   displayDays(); 
});
til.addEventListener("change", ()=>{
   displayDays(); 
});

function displayDays(){
    const fraDate = new Date(fra.value);
    const tilDate = new Date(til.value);
    const millis = tilDate - fraDate;
    const days = millis / (1000*60*60*24);
    out.textContent = days;
}