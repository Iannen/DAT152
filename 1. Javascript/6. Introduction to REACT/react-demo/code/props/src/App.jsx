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

function NumTasks(props) {
    if (props.count === 1) {
        return (<OneTask />);
    } else {
        return (<MultipleTasks count={props.count} />);
    }
}

function TaskList() {
    return (
        <div>
          <Header />

          <NumTasks count={1} />

          <NumTasks count={5} />
        </div>
    )
}

export default TaskList;
