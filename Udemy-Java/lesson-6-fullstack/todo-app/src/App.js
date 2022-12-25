import logo from './logo.svg';
import './App.css';
import Counter from './component/counter/Counter';
import { useState } from 'react';
import TodoApp, { LoginComponent, WelcomeComponent } from './component/todo/TodoApp';
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<LoginComponent />}/>
          <Route path='/login' element={<LoginComponent />}/>
          <Route path='/welcome' element={<WelcomeComponent />} />
        </Routes>
        {/* <TodoApp/> */}
      </BrowserRouter>
    </div>
  );
}

export default App;
