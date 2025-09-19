import React from 'react';

import './index.css';

function Header() {
    return(<h1>Status of tasks</h1>);
}

function OneTask() {
    return(<p>Found one task.</p>);
}

function MultipleTasks(props) {
    return(<p>Found {props.count} tasks.</p>);
}

function Tasks() {
    const [count,setCount] = React.useState(0);

    // See https://react.dev/reference/react/useEffect
    React.useEffect(() => {
        setTimeout(() => {setCount(count + 1)},1000);
    });

    if (count === 1) {
        return (<OneTask />);
    } else {
        return (<MultipleTasks count={count}  />);
    }
}

function TaskList() {
    return (
        <div>
            <Header />

            <Tasks />
        </div>
    );
}

export default TaskList;
