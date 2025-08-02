// src/App.js
import React, { useState } from 'react';
import CurrencyConvertor from './components/CurrencyConvertor';
import './App.css';

function App() {
  const [counter, setCounter] = useState(0);

  // Function to increment
  const increment = () => {
    setCounter(prev => prev + 1);
    sayHello();
  };

  // Function to say hello
  const sayHello = () => {
    console.log("Hello! This is a static message.");
  };

  // Function with argument
  const sayWelcome = (msg) => {
    alert(msg);
  };

  // Synthetic event handler
  const onPressHandler = () => {
    alert("I was clicked");
  };

  return (
    <div className="App">
      <h1>Event Handling in React</h1>

      <h2>Counter: {counter}</h2>
      <button onClick={increment}>Increment</button>
      <button onClick={() => setCounter(prev => prev - 1)}>Decrement</button>

      <div style={{ marginTop: '20px' }}>
        <button onClick={() => sayWelcome("Welcome to React Event Handling!")}>
          Say Welcome
        </button>
      </div>

      <div style={{ marginTop: '20px' }}>
        <button onClick={onPressHandler}>
          OnPress (Synthetic Event)
        </button>
      </div>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
