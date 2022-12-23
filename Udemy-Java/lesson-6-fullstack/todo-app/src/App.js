import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <FirstComponent/>
      <SecondComponent/>
    </div>
  );
}

function FirstComponent(){
  return (
    <div className='FirstComponent'>First Component</div>
  )
}

function SecondComponent(){
  return (
    <div className='Second'> Second </div>
  )
}

export default App;
