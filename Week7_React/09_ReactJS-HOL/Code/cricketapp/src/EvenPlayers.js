import React from 'react';

export function EvenPlayers({ team }) {
  const [, second, , fourth, , sixth] = team;

  return (
    <ul className="player-list">
      <li>Second: {second}</li>
      <li>Fourth: {fourth}</li>
      <li>Sixth: {sixth}</li>
    </ul>
  );
}
