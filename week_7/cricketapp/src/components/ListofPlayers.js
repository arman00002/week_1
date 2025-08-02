// src/components/ListofPlayers.js
import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Rohit Sharma", score: 80 },
    { name: "Virat Kohli", score: 95 },
    { name: "KL Rahul", score: 68 },
    { name: "Shubman Gill", score: 72 },
    { name: "Hardik Pandya", score: 60 },
    { name: "Ravindra Jadeja", score: 50 },
    { name: "R Ashwin", score: 85 },
    { name: "Mohammed Shami", score: 45 },
    { name: "Jasprit Bumrah", score: 78 },
    { name: "Kuldeep Yadav", score: 55 },
    { name: "Suryakumar Yadav", score: 92 },
  ];

  // Players with score < 70
  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h2>Players with score below 70</h2>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
