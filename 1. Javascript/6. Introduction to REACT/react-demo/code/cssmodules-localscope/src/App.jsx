import studentStyle from './student.module.css';
import teacherStyle from './teacher.module.css';

function People() {
    return (
        <div>
            <h1>List of people</h1>

            <ul>
                <li className={studentStyle.person}>Ole Olsen</li>
                <li className={teacherStyle.person}>Anne Annesen</li>
            </ul>
        </div>
    );
}

export default People;
