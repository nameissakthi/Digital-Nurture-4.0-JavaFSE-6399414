import React from 'react';
import Greeting from './Greeting'; 
import LoginButton from './LoginButton';
import LogoutButton from './LogoutButton'; 
import "./App.css"

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
  }

  handleLoginClick() {
    this.setState({ isLoggedIn: true });
  }

  handleLogoutClick() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    let button;

    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogoutClick} />;
    } else {
      button = <LoginButton onClick={this.handleLoginClick} />;
    }

    return (
      <div className="App">
        <h1>Flight Ticket Booking</h1>
        <Greeting isLoggedIn={isLoggedIn} />
        <div className="button-container">
          {button}
        </div>
      </div>
    );
  }
}

export default App;