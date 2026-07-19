import React from 'react';

const ListofPlayers = () => {
    const players = [
        { name: 'Virat Kohli', score: 120 },
        { name: 'Rohit Sharma', score: 45 },
        { name: 'KL Rahul', score: 85 },
        { name: 'Suryakumar Yadav', score: 95 },
        { name: 'Hardik Pandya', score: 30 },
        { name: 'Rishabh Pant', score: 65 },
        { name: 'Ravindra Jadeja', score: 75 },
        { name: 'R Ashwin', score: 20 },
        { name: 'Bhuvneshwar Kumar', score: 10 },
        { name: 'Jasprit Bumrah', score: 5 },
        { name: 'Yuzvendra Chahal', score: 15 }
    ];

    const below70 = players.filter(p => p.score < 70);

    return (
        <div>
            <h2>List of Players</h2>
            <h3>All Players</h3>
            <ul>
                {players.map((p, i) => <li key={i}>{p.name} - {p.score}</li>)}
            </ul>
            <h3>Players with scores below 70</h3>
            <ul>
                {below70.map((p, i) => <li key={i}>{p.name} - {p.score}</li>)}
            </ul>
        </div>
    );
};
export default ListofPlayers;
