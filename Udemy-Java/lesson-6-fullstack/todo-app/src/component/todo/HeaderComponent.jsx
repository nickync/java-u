import { useContext } from "react"
import { Link } from "react-router-dom"
import { AuthContext, useAuth } from "./security/AuthContext"

export default function HeaderComponent(){

    // const authContext = useContext(AuthContext)
    const authContext = useAuth()
    
    // console.log(authContext.isAuthenticated)
    // console.log(authContext.number)

    const isAuthenticated = authContext.isAuthenticated

    // console.log(isAuthenticated)

    // function logout(){
    //     authContext.setAuthenticated(false)
    // }

    return (
        <header className='border-bottom border-light border-5 mb-5 p-2'>
            <div className='container'>
                <div className='row'>
                    <nav className='navbar navbar-expand-lg'>
                    <a className='navbar-brand ms-2 fs-2 fw-bold text-black' href='#'>Udemy</a>
                        <div className='collapse navbar-collapse'>
                            <ul className='navbar-nav'>
                                { isAuthenticated && <li className='nav-item'><Link className='nav-link' to='/'>Home</Link></li> }
                                { isAuthenticated && <li className='nav-item'><Link className='nav-link' to='/todos'>Todos</Link></li> }
                            </ul>
                        </div>
                        <div className='navbar-nav'>
                            { isAuthenticated && <li className='nav-item'><Link className='nav-link' to='/logout' onClick={authContext.logout}>Log out</Link></li> }
                            { !isAuthenticated && <li className='nav-item'><Link className='nav-link' to='/login'>Log in</Link></li> }    
                        </div>
                    </nav>
                </div>
            </div>
        </header>
    )
}