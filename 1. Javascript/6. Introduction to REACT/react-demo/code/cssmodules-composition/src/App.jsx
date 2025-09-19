import personModule from './person.module.css';

function People() {
    return (
        <div>
            <h1>List of people</h1>

            <ul>
               <li className={personModule.maleStudent}>Ole Olsen</li>
               <li className={personModule.femaleStudent}>Anne Annesen</li>
            </ul>
        </div>
    );
}

export default People;
