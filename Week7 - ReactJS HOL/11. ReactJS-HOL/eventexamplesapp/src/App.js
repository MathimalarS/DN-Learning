import React, { useState } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(1);
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('Euro');

  const incrementAndGreet = () => {
    increment();
    sayHello();
  };

  const increment = () => {
    setCount(prev => prev + 1);
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  const sayHello = () => {
    alert('Hello! This is the increment button.');
  };

  const sayWelcome = (msg) => {
    alert(msg);
  };

  const handleClick = () => {
    alert('I was clicked');
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const conversionRate = 80; // 1 Euro = 80 INR
    const result = amount * conversionRate;
    alert(`Converting to ${currency} Amount is ${result}`);
  };

  return (
    <div style={{ padding: '20px' }}>
      <p>{count}</p>

      <button onClick={incrementAndGreet}>Increment</button>&nbsp;
      <button onClick={decrement}>Decrement</button>&nbsp;
      <button onClick={() => sayWelcome('Welcome!')}>Say welcome</button>&nbsp;
      <button onClick={handleClick}>Click on me</button>

      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>

      <form onSubmit={handleSubmit}>
        <div>
          <label>Amount: </label>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Currency: </label>
          <select
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          >
            <option value="Euro">Euro</option>
          </select>
        </div>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
