import logo from './logo.svg';
import './App.css';
import Counter from './component/counter/Counter';
import { useState } from 'react';
import TodoApp, { LoginComponent, WelcomeComponent } from './component/todo/TodoApp';

function App() {

  return (
    <div className="App">
      <TodoApp/>
      <LoginComponent />
      {/* <WelcomeComponent /> */}
    </div>
  );
}

export default App;
