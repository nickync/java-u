import axios from "axios"

const apiClient = axios.create({
    baseURL: 'http://localhost:8080'
})

export const retrieveAllTodosForUsername = (username) => apiClient.get(`/users/${username}/todos`)

export const deleteTodos = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`)