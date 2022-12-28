import { Link, useParams } from "react-router-dom"

export default function WelcomeComponent(){
    
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