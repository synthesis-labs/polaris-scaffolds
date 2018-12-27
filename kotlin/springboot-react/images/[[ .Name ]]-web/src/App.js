import React, { Component } from 'react';
import './App.css';
import axios from 'axios';

class App extends Component {
  state = {
    message: ""
  }

  componentDidMount() {
    axios.get(`/[[ .Name ]]/greeting`)
      .then(res => {
        const message = res.data;
        this.setState({ message });
      });
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1>[[ .Name ]] Hello world! ({ this.state.message })</h1>
        </header>
        <div className="App-body">

        </div>
      </div>
    );
  }
}

export default App;
