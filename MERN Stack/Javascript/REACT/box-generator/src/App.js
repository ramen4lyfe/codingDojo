import React from 'react';
import BoxForm from './components/BoxForm';
import {useState} from 'react';
import './App.css';
import List from './components/List';

function App() {
  const [boxArray, setBoxArray]=useState([]);
  return (
    <div className="App">
      <BoxForm boxArray = {boxArray} setBoxArray={setBoxArray}/>
      <List  boxArray={boxArray}/>  
    </div>
  );
}

export default App;
