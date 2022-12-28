import { useState} from "react"
import { useAuth } from "./security/AuthContext"
import { useNavigate } from "react-router-dom"

export default function LoginComponent(){
    const [username, setUsername] = useState('udemy')
    const [password, setPassword] = useState('')
    const [showSuccess, setShowSuccess] = useState(false)
    const [showError, setShowError] = useState(false)
    const navigate = useNavigate()
    const authContext = useAuth()

    const handleUsernameChange = (event) => {
        setUsername(event.target.value)
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value)
    }

    const handleSubmit = () => {
        if (authContext.login(username, password)){
            navigate(`/welcome/${username}`)
        } else{
            setShowError(true)
        } 
    }

    return(
        <div className='Login'>
            {/* {showSuccess? <div className='success'>Authenticated successfully</div> : ''}
            {showError ? <div className='error'>Authentication failed</div> : ''} */}
            {/* {showSuccess && <div className='success'>Authenticated successfully</div>} */}
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