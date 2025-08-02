// src/components/IndianPlayers.js
import React from 'react';

const IndianPlayers = () => {
  const oddTeam = ["Rohit", "Kohli", "Jadeja", "Shami", "Bumrah"];
  const evenTeam = ["Gill", "Rahul", "Surya", "Ashwin", "Hardik"];

  // Destructuring
  const [odd1, odd2, ...restOdd] = oddTeam;
  const [even1, even2, ...restEven] = evenTeam;

  const T20players = ["Rohit", "Surya", "Pandya"];
  const RanjiTrophy = ["Jadeja", "Ashwin", "Gill"];

  // Merging arrays
  const allPlayers = [...T20players, ...RanjiTrophy];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        {restOdd.map((p, idx) => <li key={idx}>{p}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        {restEven.map((p, idx) => <li key={idx}>{p}</li>)}
      </ul>

      <h2>Merged Players (T20 + Ranji)</h2>
      <ul>
        {allPlayers.map((p, idx) => (
          <li key={idx}>{p}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;

