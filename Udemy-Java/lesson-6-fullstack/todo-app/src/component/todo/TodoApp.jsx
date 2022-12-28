import './TodoApp.css'
import React from 'react'
import { useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

export default function TodoApp() {
  return (
    <>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                <Route path='/' element={<LoginComponent />}/>
                <Route path='/login' element={<LoginComponent />}/>
                <Route path='/welcome/:username' element={<WelcomeComponent />} />
                <Route path='*' element={<ErrorComponent />} />
                <Route path='/todos' element={<ListTodosComponent />} />
                <Route path='logout' element={<LogoutComponent />} />
            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export function LoginComponent(){
    const [username, setUsername] = useState('udemy')
    const [password, setPassword] = useState('')
    const [showSuccess, setShowSuccess] = useState(false)
    const [showError, setShowError] = useState(false)
    const navigate = useNavigate()

    const handleUsernameChange = (event) => {
        setUsername(event.target.value)
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value)
    }

    const handleSubmit = () => {
        if (username === 'udemy' && password === 'dummy'){
            setShowSuccess(true)
            setShowError(false)
            navigate(`/welcome/${username}`)
        } else{
            setShowSuccess(false)
            setShowError(true)
        } 
    }

    return(
        <div className='Login'>
            {/* {showSuccess? <div className='success'>Authenticated successfully</div> : ''}
            {showError ? <div className='error'>Authentication failed</div> : ''} */}
            {showSuccess && <div className='success'>Authenticated successfully</div>}
            {showError &&  <div className='error'>Authentication failed</div>}
            <div className='LoginForm'>
                <div>
                    <label>Username</label>
                    <input type="text" name='username' value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type='button' name='login' onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}

export function WelcomeComponent(){
    
    // const params = useParams()
    const { username } = useParams()
    return(
        <div className='Welcome'>
            {/* <h1>Welcome {params.username}</h1> */}
            <h1>Welcome {username}</h1>
            <h4>Hello, Welcome to To Do Management</h4>
            <div>Manage your todos <Link to='/todos'>here!</Link></div>

        </div>
    )
}

export function ErrorComponent(){
    return (
        <div>
            <h1>We're working hard on this</h1>
            <h3>404 error.</h3>
        </div>
    )
}

export function ListTodosComponent(){

    const today = new Date();

    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay());

    const todos = [{
        id:1,
        description:'Learn AWS',
        done: false,
        targetDate: targetDate
    },
    {
        id:2,
        description:'Learn Full Stack',
        done:false,
        targetDate: targetDate
    }]

    return (
        <div className='container'>
            <h1>Things you want to do!</h1>
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>description</td>
                            <td>Is done</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(todo => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.done}</td>
                                    <td>{todo.targetDate.toDateString()}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export function HeaderComponent(){
    return (
        <header className='border-bottom border-light border-5 mb-5 p-2'>
            <div className='container'>
                <div className='row'>
                    <nav className='navbar navbar-expand-lg'>
                    <a className='navbar-brand ms-2 fs-2 fw-bold text-black' href='#'>Udemy</a>
                        <div className='collapse navbar-collapse'>
                            <ul className='navbar-nav'>
                                <li className='nav-item'><Link className='nav-link' to='/'>Home</Link></li>
                                <li className='nav-item'><Link className='nav-link' to='/todos'>Todos</Link></li>
                            </ul>
                        </div>
                        <div className='navbar-nav'>
                            <li className='nav-item'><Link className='nav-link' to='/logout'>Log out</Link></li>
                            <li className='nav-item'><Link className='nav-link' to='/login'>Log in</Link></li>    
                        </div>
                    </nav>
                </div>
            </div>
        </header>
    )
}

export function FooterComponent(){
    return (
        <footer className='header'>
            <div className='container'>
                Your footer
            </div>
        </footer>
    )
}

export function LogoutComponent(){
    return (
        <div className='LogoutComponent'>
            <div>Thank you for using the app...</div>
        </div>
    )
}