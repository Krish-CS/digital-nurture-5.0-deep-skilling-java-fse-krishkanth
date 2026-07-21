import React, { useState } from 'react';

const Register = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState({});

    const validate = () => {
        let tempErrors = {};
        if (name.length < 5) tempErrors.name = "Name should have at least 5 characters.";
        if (!email.includes('@') || !email.includes('.')) tempErrors.email = "Email must contain @ and .";
        if (password.length < 8) tempErrors.password = "Password must have at least 8 characters.";
        setErrors(tempErrors);
        return Object.keys(tempErrors).length === 0;
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validate()) {
            alert("Registration successful!");
        }
    }

    return (
        <div style={{ padding: '20px', border: '1px solid gray', width: '300px', margin: '20px auto' }}>
            <h3>Mail Register App</h3>
            <form onSubmit={handleSubmit}>
                <div style={{ marginBottom: '10px' }}>
                    <label>Name: </label><br/>
                    <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
                    {errors.name && <div style={{color: 'red', fontSize: '12px'}}>{errors.name}</div>}
                </div>
                <div style={{ marginBottom: '10px' }}>
                    <label>Email: </label><br/>
                    <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} />
                    {errors.email && <div style={{color: 'red', fontSize: '12px'}}>{errors.email}</div>}
                </div>
                <div style={{ marginBottom: '10px' }}>
                    <label>Password: </label><br/>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    {errors.password && <div style={{color: 'red', fontSize: '12px'}}>{errors.password}</div>}
                </div>
                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default Register;
