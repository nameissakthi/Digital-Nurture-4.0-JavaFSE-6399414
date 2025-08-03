import React from 'react';

const ListOfIndianPlayers = ({ IndianPlayers }) => {
  return (
    <div>
      <ul className="player-list">
        {IndianPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListOfIndianPlayers;
