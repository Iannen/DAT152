import './index.css';

function handleEvent(event) {
    window.alert(`Event ${event.type} on ${event.currentTarget.tagName}`);
}

function EventIntro() {
    return (
        <>
            <h1>Event demo</h1>
            <p><button onClick={handleEvent}>Click me</button></p>
        </>
    );
}

export default EventIntro;
