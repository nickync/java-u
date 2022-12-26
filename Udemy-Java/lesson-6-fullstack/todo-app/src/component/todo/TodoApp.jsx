import './TodoApp.css'
import React from 'react'
import { useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

export default function TodoApp() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<LoginComponent />}/>
            <Route path='/login' element={<LoginComponent />}/>
            <Route path='/welcome/:username' element={<WelcomeComponent />} />
            <Route path='*' element={<ErrorComponent />} />
        </Routes>
        {/* <TodoApp/> */}
  </BrowserRouter>
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