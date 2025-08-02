// src/components/CurrencyConvertor.js
import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Example conversion rate
    const rate = 0.011;
    const converted = (parseFloat(rupees) * rate).toFixed(2);
    setEuros(converted);
  };

  return (
    <div style={{ marginTop: '30px' }}>
      <h2>Currency Converter</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Enter amount in INR"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
        />
        <button type="submit">Convert</button>
      </form>
      {euros !== null && (
        <p>Converted Amount: €{euros}</p>
      )}
    </div>
  );
};

export default CurrencyConvertor;
