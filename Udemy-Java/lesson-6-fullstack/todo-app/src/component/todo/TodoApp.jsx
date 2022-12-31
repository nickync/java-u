import './TodoApp.css'
import React from 'react'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import LogoutComponent from './LogoutComponent'
import FooterComponent from './FooterComponent'
import HeaderComponent from './HeaderComponent'
import ListTodosComponent from './ListTodosComponent'
import LoginComponent from './LoginComponent'
import ErrorComponent from './ErrorComponent'
import WelcomeComponent from './WelcomeComponent'
import AuthProvider, { useAuth } from './security/AuthContext'
import TodoComponent from './TodoComponent'

function AuthenticatedRoute({ children }){
    const authContext = useAuth()
    
    if (authContext.isAuthenticated){
        return children
    }
    return <Navigate to='/' />
}

export default function TodoApp() {
  return (
    <AuthProvider>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                <Route path='/' element={<LoginComponent />}/>
                <Route path='/login' element={<LoginComponent />}/>
                <Route path='/welcome/:username' element={ 
                    <AuthenticatedRoute>
                        <WelcomeComponent />
                    </AuthenticatedRoute>} />

                <Route path='/todos' element={
                    <AuthenticatedRoute>
                        <ListTodosComponent />
                    </AuthenticatedRoute>} />

                <Route path='/todo/:id' element={
                    <AuthenticatedRoute>
                        <TodoComponent />
                    </AuthenticatedRoute>} />
                    
                <Route path='logout' element={
                    <AuthenticatedRoute>
                        <LogoutComponent />
                    </AuthenticatedRoute>} />
                <Route path='*' element={<ErrorComponent />} />
            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </AuthProvider>
  )
}