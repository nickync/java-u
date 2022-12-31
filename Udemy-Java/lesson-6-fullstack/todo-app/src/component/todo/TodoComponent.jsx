import { useState } from "react"
import { useEffect } from "react"
import { useParams } from "react-router-dom"
import { retrieveTodoApi } from "./api/TodoApiService"
import { useAuth } from "./security/AuthContext"

export default function TodoComponent() {
    
    const {id} = useParams()

    const authContext = useAuth()

    const username = authContext.username

    const [description, setDescription] = useState()

    useEffect(
        () => {
            retrieveTodos()
        }, [id]
    )

    function retrieveTodos(){
        retrieveTodoApi(username, id).then(
            res => {
                setDescription(res.data.description)
            }
        )
    }

    return (
        <div className="container">
            <h1>Enter todo details</h1>
            <h4>{description}</h4>
        </div>
    )
}