import React from 'react';

export function OddPlayers({ team }) {
  const [first, , third, , fifth] = team;

  return (
    <ul className="player-list">
      <li>First: {first}</li>
      <li>Third: {third}</li>
      <li>Fifth: {fifth}</li>
    </ul>
  );
}
