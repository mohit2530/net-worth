import React from 'react'
import './App.css'
import 'fontsource-roboto'
import Home from './components/Home/Home'
import {constants} from './util/constants'
import Landing from './components/Landing/Landing'
import ProtectedRoute from './auth/ProtectedRoute'
import {BrowserRouter as Router, Switch, Route } from 'react-router-dom'

function App() {
  return (
    <div className="App">
      <Switch>
        <Router>
          <Route exact path = {constants.baseUrl} component = {Landing}/>
          <ProtectedRoute exact path = {constants.homeUrl} component = {Home}/>
        </Router>
      </Switch>
    </div>
  );
}

export default App;
