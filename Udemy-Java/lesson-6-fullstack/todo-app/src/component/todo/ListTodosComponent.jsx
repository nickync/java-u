import { useEffect } from "react";
import { useState } from "react";
import { useParams } from "react-router-dom";
import { retrieveAllTodosForUsername } from "./api/TodoApiService";

export default function ListTodosComponent(){

    const today = new Date();

    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay());

    const {username} = useParams()

    const [todos, setTodos] = useState([])
    
    useEffect(
        () =>  getTodos(),[]
    )

    function getTodos(username){
        retrieveAllTodosForUsername(username).then(res => setTodos(res.data))
    }
    console.log(username)
    return (
        <div className='container'>
            <h1>Things you want to do!</h1>
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>description</td>
                            <td>Is done</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(todo => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.done}</td>
                                    <td>{todo.targetDate.toDateString()}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}