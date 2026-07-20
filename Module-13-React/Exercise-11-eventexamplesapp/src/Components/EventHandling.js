import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

const EventHandling = () => {
    const [counter, setCounter] = useState(0);

    const increment = () => {
        setCounter(prev => prev + 1);
    }

    const sayHello = () => {
        alert("Hello! This is a static message.");
    }

    const handleIncrease = () => {
        increment();
        sayHello();
    }

    const decrement = () => {
        setCounter(prev => prev - 1);
    }

    const sayWelcome = (msg) => {
        alert(msg);
    }

    const handleSyntheticEvent = (e) => {
        alert("I was clicked! Event type: " + e.type);
    }

    return (
        <div style={{ padding: '20px' }}>
            <h2>React Event Examples</h2>
            
            <p>Counter: {counter}</p>
            <button onClick={handleIncrease}>Increment</button>
            <button onClick={decrement} style={{ marginLeft: '10px' }}>Decrement</button>
            
            <hr />
            
            <button onClick={() => sayWelcome('Welcome')}>Say Welcome</button>
            
            <hr />
            
            <button onClick={handleSyntheticEvent}>Synthetic Event Button</button>
            
            <hr />
            
            <CurrencyConvertor />
        </div>
    );
};

export default EventHandling;
