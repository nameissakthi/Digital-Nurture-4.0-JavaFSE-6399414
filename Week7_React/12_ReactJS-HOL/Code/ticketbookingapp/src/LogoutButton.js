import React from 'react';

function LogoutButton(props) {
  return (
    <button onClick={props.onClick} className="app-button logout">
      Logout
    </button>
  );
}

export default LogoutButton;