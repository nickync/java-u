import './TodoApp.css'
import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import LogoutComponent from './LogoutComponent'
import FooterComponent from './FooterComponent'
import HeaderComponent from './HeaderComponent'
import ListTodosComponent from './ListTodosComponent'
import LoginComponent from './LoginComponent'
import ErrorComponent from './ErrorComponent'
import WelcomeComponent from './WelcomeComponent'
import AuthProvider from './security/AuthContext'

export default function TodoApp() {
  return (
    <AuthProvider>
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
    </AuthProvider>
  )
}