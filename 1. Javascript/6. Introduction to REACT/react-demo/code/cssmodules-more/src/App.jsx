import personStyle from './person.module.css';

function People() {
    return (
        <div>
            <h1>List of people</h1>

            <ul>
                {/* Using multiple class names */}
                <li className={`${personStyle.male} ${personStyle.student}`}>Ole Olsen</li>

                {/* Using a global style */}
                <li className="adult">Hans Hansen</li>

               {/* Global style combined with local class names */}
                <li className={`adult ${personStyle.female} ${personStyle.teacher}`}>Anne Annesen</li>
            </ul>
        </div>
    );
}

export default People;
