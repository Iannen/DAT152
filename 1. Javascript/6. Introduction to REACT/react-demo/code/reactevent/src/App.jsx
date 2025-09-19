import './index.css';

const phases = {};
phases[Event.CAPTURING_PHASE] = "CAPTURING_PHASE";
phases[Event.AT_TARGET] = "AT_TARGET";
phases[Event.BUBBLING_PHASE] = "BUBBLING_PHASE";

function handleEvent(event) {
    window.alert(`handleEvent - Event ${event.type} on ${event.currentTarget.tagName} in phase ${phases[event.eventPhase]}`);
}

function handleOtherEvent(event) {
    window.alert(`handleOtherEvent - Event ${event.type} on ${event.currentTarget.tagName} in phase ${phases[event.eventPhase]}`);
}

function EventDemo() {
    return (
        <>
            <h1>Event phases</h1>

            <div onClick={handleEvent}>
                <button onClick={handleEvent}>Click me - Bubbling phase</button>
            </div>

            <div onClickCapture={handleEvent}>
                <button onClickCapture={handleEvent}>Click me - Capturing phase</button>
            </div>

            <div onClick={handleEvent} onClickCapture={handleOtherEvent} >
                <button onClick={handleEvent} onClickCapture={handleOtherEvent}>Click me, capturing and bubbling</button>
            </div>
        </>
    );
}

export default EventDemo;
