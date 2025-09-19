import './index.css'

function Welcome({courseName}) {
    return (
        /* Below is an example of JSX */
        <h1 className="courseintro">Welcome to {courseName}</h1>
    );
}

function WelcomeDAT152() {
    return (
	/* Below is an example of JSX */
        <Welcome courseName='DAT152' />
    );
}

export default WelcomeDAT152;
