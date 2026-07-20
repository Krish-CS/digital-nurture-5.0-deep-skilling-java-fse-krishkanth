import React, { useState } from 'react';

const CurrencyConvertor = () => {
    const [rupees, setRupees] = useState(0);
    const [euro, setEuro] = useState(0);

    const handleSubmit = (e) => {
        e.preventDefault();
        setEuro(rupees / 90); // approximate conversion
    }

    return (
        <div style={{ marginTop: '20px', border: '1px solid black', padding: '10px' }}>
            <h3>Currency Convertor (INR to Euro)</h3>
            <form onSubmit={handleSubmit}>
                <label>Amount in Rupees: </label>
                <input type="number" value={rupees} onChange={(e) => setRupees(e.target.value)} />
                <button type="submit" style={{ marginLeft: '10px' }}>Convert</button>
            </form>
            <p>Equivalent Euro: {euro.toFixed(2)}</p>
        </div>
    );
};

export default CurrencyConvertor;
