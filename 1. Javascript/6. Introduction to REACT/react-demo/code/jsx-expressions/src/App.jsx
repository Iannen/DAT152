import './index.css';

function Demo1() {
    const number = 3.14;
    const element = <p>Demo1: Pi is approximately {number}.</p>;

    return (element);
}

function Demo2() {
    const number = Math.PI;
    const element = <p>Demo2: Double Pi is approximately {2*number}.</p>;

    return (element);
}

function Demo3() {
    const noFmt = new Intl.NumberFormat("nb-NO");
    const element = <p>Demo3: Pi is approx {noFmt.format(Math.PI)}.</p>;

    return (element);
}

function Demo4() {
    const taskRows = [
            <tr key={1}><td>Wash windows</td><td>ACTIVE</td></tr>,
            <tr key={2}><td>Clean floor</td><td>DONE</td></tr>,
            <tr key={3}><td>Paint roof</td><td>WAITING</td></tr>
        ]

    return (
        <table>
          <caption>Demo4</caption>
          <thead>
            <tr><th>Task</th><th>Status</th></tr>
          </thead>
          <tbody>
            {taskRows}
          </tbody>
        </table>
    )
}

function JSXExpressions() {
    return (
        <div>
            <h1>Examples with JSX and embedded expressions</h1>

            <Demo1 />
            <Demo2 />
            <Demo3 />
            <Demo4 />
        </div>
    );
}

export default JSXExpressions;
