import React from 'react';

import './index.css';

function Demo1() {
    return <a href="https://eple.hvl.no">eple</a>;
}

function Demo2() {
    return  React.createElement(
        'a',
        {href: 'https://eple.hvl.no'},
        'eple'
    );
}

function Demo3() {
    const person = <span>Ole Olsen</span>;
    return <p>Demo3: Welcome {person} to DAT152</p>;
}

function Demo4() {
    const person = '<span>Ole Olsen</span>';
    return <p>Demo4: Welcome {person} to DAT152</p>;
}


function JSXMore() {
    return (
        <div>
            <h1>Examples with JSX in JavaScript</h1>

            <p>Visit <Demo1/></p>

            <p>Visit <Demo2/></p>

            <Demo3/>

            <Demo4/>
        </div>
    );
}

export default JSXMore;
