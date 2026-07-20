import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';
import './theme.css';

const EmployeeCard = ({ employee }) => {
    const theme = useContext(ThemeContext);
    const btnClass = theme === 'light' ? 'btn-light' : 'btn-dark';

    return (
        <div style={{ border: '1px solid gray', padding: '10px', margin: '10px' }}>
            <h4>{employee.name}</h4>
            <p>Role: {employee.role}</p>
            <button className={btnClass}>View Details</button>
        </div>
    );
};
export default EmployeeCard;
