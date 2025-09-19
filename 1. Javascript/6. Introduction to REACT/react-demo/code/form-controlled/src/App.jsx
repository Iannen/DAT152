import React from 'react';

import './index.css';

function TaskView() {
    const [title, setTitle] = React.useState('');
    const [status, setStatus] = React.useState('WAITING');

    const titleChange = (event) => {
        setTitle(event.target.value);
    }

    const statusChange = (event) => {
        setStatus(event.target.value);
    }

    return (
        <>
            <h1>Tasks</h1>

            <h2>New task</h2>
            <form>
            <fieldset>
                <legend>Add task</legend>
                    <label htmlFor="tasktitle">Task title:</label>
                    <input id="tasktitle" type="text" value={title} onChange={titleChange}/>

                    <label htmlFor="taskstatus">Task status:</label>
                    <select id="taskstatus" value={status} onChange={statusChange}>
                        <option value="WAITING">WAITING</option>
                        <option value="ACTIVE">ACTIVE</option>
                        <option value="DONE">DONE</option>
                    </select>
                </fieldset>
            </form>

            <h2>Current task</h2>
            <div data-tasks>
                <span>Title:</span><span>{title}</span>
                <span>Status:</span><span>{status}</span>
            </div>
        </>
    )
}

export default TaskView;
