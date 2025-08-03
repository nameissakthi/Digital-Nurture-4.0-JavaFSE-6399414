import React from 'react';
import ListOfPlayers from './ListOfPlayers';
import ScoreBelow70 from './ScoreBelow70';
import { OddPlayers } from './OddPlayers';
import { EvenPlayers } from './EvenPlayers';
import ListOfIndianPlayers from './ListOfIndianPlayers';


const App = () => {
  const flag = false;

  const players = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Jadeja', score: 64 },
    { name: 'Raina', score: 75 },
    { name: 'Rohit', score: 80 },
  ];
  const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvaraj5', 'Raina6'];

  const T20Players = ['First Player', 'Second Player', 'Third Player'];
  const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
  const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div>
      {flag === true ? (
        <div>
          <h1>List of Players</h1>
          <ListOfPlayers players={players} />
          <hr />
          <h1>List of Players having Scores Less than 70</h1>
          <ScoreBelow70 players={players} />
        </div>
      ) : (
        <div>
          <h1>Odd Players</h1>
          <OddPlayers team={IndianTeam} />
          <hr />
          <h1>Even Players</h1>
          <EvenPlayers team={IndianTeam} />
          <hr />
          <h1>List of Indian Players Merged:</h1>
          <ListOfIndianPlayers IndianPlayers={IndianPlayers} />
        </div>
      )}
    </div>
  );
};

export default App;
