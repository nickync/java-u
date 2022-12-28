import { Link } from "react-router-dom"

export default function HeaderComponent(){
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