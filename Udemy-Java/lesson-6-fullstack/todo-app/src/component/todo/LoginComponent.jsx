import { useState, useNavigate } from "react"

export default function LoginComponent(){
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