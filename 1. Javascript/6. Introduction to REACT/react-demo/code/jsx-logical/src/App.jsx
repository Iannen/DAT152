import './index.css';

function Header() {
    return(<h1>Status of tasks</h1>);
}

function Demo1({count}) {
    let taskCount;
    if (count === 1) {
        taskCount = <p>Demo1: Found one task.</p>;
    } else {
        taskCount = <p>Demo1: Found {count} tasks.</p>;
    }

    return taskCount;
}

function Demo2({count}) {
    return <p>Demo2: Found {count} task{count!==1 && 's'}.</p>
}

function Demo3({count}) {
    return <p>Demo3: Found {count===1  ?'one task' : `${count} tasks`}.</p>
}

function Demo4({count}) {
    return <p>Demo4: Found {count===1  ?'one task' : <>{count} tasks</>}.</p>
}

function ReactLogical() {
    return (
        <div>
            <Header />

            <Demo1 count={1} />
            <Demo1 count={2} />
            <Demo2 count={1} />
            <Demo2 count={3} />
            <Demo3 count={1} />
            <Demo3 count={4} />
            <Demo4 count={1} />
            <Demo4 count={4} />
        </div>
    );
}

export default ReactLogical;
