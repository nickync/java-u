import { ErrorMessage, Field, Form, Formik } from "formik"
import moment from "moment"
import { useState } from "react"
import { useEffect } from "react"
import { useNavigate, useParams } from "react-router-dom"
import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoApiService"
import { useAuth } from "./security/AuthContext"

export default function TodoComponent() {
    
    const {id} = useParams()

    const authContext = useAuth()

    const username = authContext.username

    const [description, setDescription] = useState('')
    
    const [targetDate, setTargetDate] = useState('')

    const navigate = useNavigate()

    useEffect(
        () => {
            retrieveTodos()
        }, [id]
    )

    function retrieveTodos(){
        if(id != -1){
            retrieveTodoApi(username, id).then(
                res => {
                    setDescription(res.data.description)
                    setTargetDate(res.data.targetDate)
                }
            )
        }
    }

    const onSubmit = (values) => {
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }

        if (id == -1){
            createTodoApi(username, todo).then(res => {
                navigate('/todos')
            })
        } else {
            updateTodoApi(username, id, todo).then(res => {
                navigate('/todos')
            })
        }
    }

    const validate = (values) => {
        let errors = {
            // description: 'Enter a valid description.',
            // targetDate: 'Enter a valid date'
        }

        if (values.description.length < 5 ){
            errors.description = 'Length must be longer than 5'
        }
        
        if (!moment(values.targetDate).isValid()){
            errors.targetDate = 'Invalid date.'
        }

        return errors
    }

    return (
        <div className="container">
            <h1>Enter todo details</h1>
            <div>
                <Formik initialValues={{description, targetDate}} enableReinitialize={true} onSubmit={onSubmit} validate = {validate}
                    validateOnChange={false} validateOnBlur={false}>
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name="description" component="div" className="alert alert-warning"/>
                                <ErrorMessage name="targetDate" component="div" className="alert alert-warning"/>
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field className="form-control" name="description" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target date</label>
                                    <Field type="date" className="form-control" name="targetDate" />
                                </fieldset>
                                <div>
                                    <button type="submit" className="btn btn-success">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}