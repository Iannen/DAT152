const inps = document.getElementsByTagName("input");
const datoInput = inps[0];
const localeInput = inps[1];
const output = document.getElementsByTagName("p")[0];
DisplayDay();
datoInput.addEventListener("change", ()=>{
   DisplayDay();
});
localeInput.addEventListener("change", ()=>{
   const localeString = localeInput.value;
   try {
      new Intl.DateTimeFormat(localeString);
      DisplayDay(localeString);
   }
   catch (e) {
   }
});

function DisplayDay(localeString){
   const dato = new Date(datoInput.value);
   output.textContent = dato.toLocaleDateString(localeString,{weekday:"long"});
}