import logo from './logo.svg';
import './App.css';
import Counter from './component/counter/Counter';
import { useState } from 'react';

function App() {
  const [count, setCount]=useState(0);

  const total = (num) => {
    setCount(count+num)
  }

  return (
    <div className="App">
      <h1 onChange={total}>{count}</h1>
      <Counter num={1}/>
      <Counter num={2}/>
      <Counter num={3}/>
      <Counter num={4}/>
      <Counter num={5}/>
      <Counter num={6}/>
    </div>
  );
}

function Properties(){
  console.log()
}

export default App;
