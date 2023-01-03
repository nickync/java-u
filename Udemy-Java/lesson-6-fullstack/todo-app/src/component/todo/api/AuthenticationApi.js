import { apiClient } from "./ApiClient";

export const executeJwtAuthenticationService = (username, password) => apiClient.post(`/authenticate`, {username, password})