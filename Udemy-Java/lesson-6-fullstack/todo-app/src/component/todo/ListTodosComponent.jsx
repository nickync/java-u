import { useEffect } from "react";
import { useState } from "react";
import { useParams } from "react-router-dom";
import { deleteTodos, retrieveAllTodosForUsername } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";

export default function ListTodosComponent(){

    const today = new Date();

    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay());

    const [todos, setTodos] = useState([])

    const [message, setMessage] = useState(null)

    const authContext = useAuth()

    const username = authContext.username
    
    useEffect(
        () =>  getTodos(),[]
    )

    function getTodos(){
        retrieveAllTodosForUsername(username).then(res => setTodos(res.data))
    }

    const deleteTodo = (id) => {
        deleteTodos(username, id).then(
            () => {
                setMessage('deleted llll')
                getTodos()
            }
        )
    }

    return (
        <div className='container'>
            <h1>Things you want to do!</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is done</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(todo => (
                                <tr key={todo.id}>
                                    <td>{todo.description}</td>
                                    <td>{todo.done}</td>
                                    <td>{todo.targetDate}</td>
                                    <td><button className="btn btn-warning" onClick={() => deleteTodo(todo.id)}>Delete</button></td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}