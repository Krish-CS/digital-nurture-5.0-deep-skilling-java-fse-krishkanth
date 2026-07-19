import React from 'react';

const IndianPlayers = () => {
    const indianTeam = ['Virat', 'Rohit', 'Rahul', 'Surya', 'Hardik', 'Pant'];
    const [odd1, even1, odd2, even2, odd3, even3] = indianTeam;

    const t20Players = ['PlayerA', 'PlayerB'];
    const ranjiPlayers = ['PlayerC', 'PlayerD'];
    const mergedPlayers = [...t20Players, ...ranjiPlayers];

    return (
        <div>
            <h2>Indian Players</h2>
            <h3>Odd Team Players:</h3>
            <p>{odd1}, {odd2}, {odd3}</p>
            <h3>Even Team Players:</h3>
            <p>{even1}, {even2}, {even3}</p>

            <h3>Merged T20 and Ranji Trophy Players:</h3>
            <ul>
                {mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}
            </ul>
        </div>
    );
};
export default IndianPlayers;
