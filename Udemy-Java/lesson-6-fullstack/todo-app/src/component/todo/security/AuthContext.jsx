import { useContext } from "react";
import { useState } from "react";
import { createContext } from "react";
import { executeBasicAuthenticationApi } from "../api/TodoApiService";

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

export default function AuthProvider({ children }){

    const [number, setNumber] = useState(0)

    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    const [token, setToken] = useState(null)

    async function login(username, password) {
        const basicToken = "Basic " + window.btoa(username + ":" + password)

        try {
            const response = await executeBasicAuthenticationApi(basicToken)

            if (response.status == 200) {
                setAuthenticated(true)
                setUsername(username)
                setToken(basicToken)
                console.log(token)
                return true
            } else {
                setAuthenticated(false)
                setUsername(null)
                setToken(null)
                return false
            }
        } catch (error) {
            setAuthenticated(false)
            setUsername(null)
            return false
        }


        // if (username === 'udemy' && password === 'dummy'){
        //     setAuthenticated(true)
        //     setUsername(username)
        //     return true
        // } else{
        //     setAuthenticated(false)
        //     setUsername(null)
        //     return false
        // } 
    }
    
    function logout(){
        setToken(null)
        setUsername(null)
        setAuthenticated(false)
    }

    return (
        <AuthContext.Provider value={ { number, isAuthenticated, login, logout, username, token } }>
            {children}
        </AuthContext.Provider>
    )
}