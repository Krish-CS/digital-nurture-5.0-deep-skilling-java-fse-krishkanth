import React from 'react';
import '../Stylesheets/mystyle.css';

const percentToDecimal = (decimal) => {
    return (decimal.toFixed(2) + '%');
}

const calcScore = (total, goal) => {
    return percentToDecimal(total / goal);
}

const CalculateScore = ({ Name, School, Total, goal }) => {
  return (
    <div className="student-details">
      <h2>Student Details:</h2>
      <div className="Name"><b>Name:</b> {Name}</div>
      <div className="School"><b>School:</b> {School}</div>
      <div className="Total"><b>Total:</b> {Total}</div>
      <div className="goal"><b>Goal:</b> {goal}</div>
      <div className="score"><b>Score:</b> {calcScore(Total, goal)}</div>
    </div>
  );
}

export default CalculateScore;
