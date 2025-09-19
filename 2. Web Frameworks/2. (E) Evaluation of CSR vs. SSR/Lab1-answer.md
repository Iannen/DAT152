# Task 1: Run the web applications

Ok!

# Task 2: Browse through the Source code

## CSR versjonen
### Backend

Dette er en Express server som holder data i minne. Bilder skrives til disk, men blir decoupled når server restarter.
Lite kode, all kildekode er i en fil. Vrien syntax.

### Frontend
Frontend er en React app

Ryddig nok den, men syntax og funksjonell stil er litt alien.

## SSR versjonen

Er en spring boot MVC app:
    -Model er transient, 'databasen' wipes hver gang server restartes.
    -Thymeleaf er view teknologien
    -Spring har controllerne, selvfølgelig.

Alt i alt så har vel CSR mindre kodelinjer og færre filer, mens spring boot prosjektet har en ryddigere organisering. 

# Task3: Run the Google Developer Tools to measure performance metrics

Fant ikke helt ut av dette, men poenget er vel at SSR er raskest første gang, men så tar CSR over siden kommunikasjon bare er json objekter derfra og ut.