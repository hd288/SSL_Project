import axios  from "axios";
import instance from "./axiosConfig";

export default {
    login: (loginInfo) => axios.post(import.meta.env.VITE_API_URL +"/api/v1/auth/sign-in", loginInfo),
    register: (signupInfo) => axios.post(import.meta.env.VITE_API_URL +"/api/v1/auth/sign-up", signupInfo),
    logout: (logoutRequest) => axios.post(import.meta.env.VITE_API_URL +"/api/v1/auth/logout", logoutRequest),
    changePassword: (changePasswordRequest) => instance.put("/api/v1/users/password", {changePasswordRequest}),
    refreshToken: (refreshToken) => axios.post(import.meta.env.VITE_API_URL +"/api/v1/auth/refresh-token", refreshToken),
}