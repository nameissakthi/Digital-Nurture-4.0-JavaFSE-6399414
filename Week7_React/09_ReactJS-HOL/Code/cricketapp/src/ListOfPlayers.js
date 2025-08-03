import React from 'react';

const ListOfPlayers = ({ players }) => {
  return (
    <ul className="player-list">
      {players.map((player, index) => (
        <li key={index}>
          Mr. {player.name}<span> {player.score}</span>
        </li>
      ))}
    </ul>
  );
};

export default ListOfPlayers;
