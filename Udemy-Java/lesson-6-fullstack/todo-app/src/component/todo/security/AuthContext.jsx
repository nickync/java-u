import { useContext } from "react";
import { useState } from "react";
import { createContext } from "react";

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

export default function AuthProvider({ children }){

    const [number, setNumber] = useState(0)

    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    function login(username, password) {
        if (username === 'udemy' && password === 'dummy'){
            setAuthenticated(true)
            setUsername(username)
            return true
        } else{
            setAuthenticated(false)
            setUsername(null)
            return false
        } 
    }
    
    function logout(){
        setAuthenticated(false)
    }

    return (
        <AuthContext.Provider value={ { number, isAuthenticated, login, logout, username } }>
            {children}
        </AuthContext.Provider>
    )
}