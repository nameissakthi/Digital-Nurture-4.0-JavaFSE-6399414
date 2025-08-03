import React from 'react';

function LoginButton(props) {
  return (
    <button onClick={props.onClick} className="app-button login">
      Login
    </button>
  );
}

export default LoginButton;