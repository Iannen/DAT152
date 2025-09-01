URL to application:
http://127.0.0.1:8080/TaskList/

URL to demo:
http://127.0.0.1:8080/TaskList/demo/index.html

URL to the in-memory database of the application:
http://localhost:8080/TaskList/h2-console
 

Spm: 
    1. Fungerer siden min sånn som den skal? 
        -Bare mulig å forandre status og slette items?
        -Ingen bruk av backend - bare console statements fra controllerklassen?
            --Grei på funksjonalitet. Måtte forandre litt på routing som nevnt i spm3.

    2. Showtask() ble ganske omfattende - er det sånn det skal være?
        -Skubbe inn verdier i radens kolonner
        -Registrere callbacks for select og button elementer
            --Ja den ble litt omfattende, det skulle vist være sånn.

    3. Burde ikke komponentet vente på 'ok' fra backend før UI oppdateres?
            --Her måtte jeg forandre slik at child bare kalte på controller callback,
            fikk ansvar for å bruke child sin API til å utføre handlingen.
    
    3. Jeg skjønner ikke hvordan dette h2 databasegreiene fungerer.
        -Det virker uansett ikke som at controlleren -tasklistdemo.js-, bruker databasen. 
            --Det var ikke noe å tenke på mente Bjarte.