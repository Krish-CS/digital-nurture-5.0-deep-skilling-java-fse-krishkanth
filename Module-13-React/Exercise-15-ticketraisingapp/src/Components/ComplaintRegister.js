import React, { useState } from 'react';

const ComplaintRegister = () => {
    const [empName, setEmpName] = useState('');
    const [complaint, setComplaint] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const refNum = Math.floor(Math.random() * 100000);
        alert(`Thanks ${empName}! Your complaint is registered.\nReference Number: ${refNum}`);
    }

    return (
        <div style={{ padding: '20px', border: '1px solid black', width: '300px', margin: '20px auto' }}>
            <h3>Register Complaint</h3>
            <form onSubmit={handleSubmit}>
                <div style={{ marginBottom: '10px' }}>
                    <label>Employee Name: </label><br/>
                    <input 
                        type="text" 
                        value={empName} 
                        onChange={(e) => setEmpName(e.target.value)} 
                        required 
                    />
                </div>
                <div style={{ marginBottom: '10px' }}>
                    <label>Complaint Details: </label><br/>
                    <textarea 
                        value={complaint} 
                        onChange={(e) => setComplaint(e.target.value)} 
                        required 
                        rows="4"
                    />
                </div>
                <button type="submit">Submit Complaint</button>
            </form>
        </div>
    );
};

export default ComplaintRegister;
