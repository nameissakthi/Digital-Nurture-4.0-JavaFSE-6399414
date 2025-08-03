import React, { useState } from 'react';

const Events = () => {
  const [count, setCount] = useState(0);
  const [amount, setAmount] = useState('');
  const [currencyType, setCurrencyType] = useState('');

  const IncreaseValue = () => {
    const newCount = count + 1;
    setCount(newCount);
    alert('Hello Members');
  };

  const DecreaseValue = () => {
    const newCount = count - 1;
    setCount(newCount);
    alert('Hello Members');
  };

  const Display = () => {
    alert('Welcome');
  };

  const Click = () => {
    alert('I was clicked');
  };

  const CurrencyConvertor = () => {
    let rate = 0;

    switch (currencyType.toLowerCase()) {
      case 'euro':
      case 'eur':
        rate = 80;
        break;
      case 'usd':
      case 'dollar':
        rate = 75;
        break;
      case 'yen':
        rate = 0.55;
        break;
      case 'pound':
      case 'gbp':
        rate = 90;
        break;
      default:
        alert('Unsupported currency type!');
        return;
    }
    const result = (amount * rate);
    alert(`Converting to ${currencyType.toLowerCase()} Amount is ${result}`);

  };

  return (
    <div>
      <div>
        <h2>{count}</h2>
        <div><button onClick={IncreaseValue}>Increment</button></div>
        <div><button onClick={DecreaseValue}>Decrement</button></div>
        <div><button onClick={Display}>Say welcome</button></div>
        <div><button onClick={Click}>Click on me</button></div>
      </div>

      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
      <div >
      <table>
        <tbody>
          <tr>
            <td>Amount:</td>
            <td style={{paddingLeft:30}}>
              <input
                type="number"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td>Currency:</td>
            <td style={{paddingLeft:30}}>
              <textarea
                value={currencyType}
                onChange={(e) => setCurrencyType(e.target.value)}
                rows={2}
                cols={20}
              />
            </td>
          </tr>
        </tbody>
      </table>
      
      <div style={{marginLeft: '10%'}}>
        <button onClick={CurrencyConvertor}>Submit</button>
      </div>
      </div>
    </div>
  );
};

export default Events;
