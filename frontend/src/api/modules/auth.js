import axios  from "axios";

export default {
    login: (loginInfo) => axios.post(import.meta.env.VITE_API_URL +"/api/v1/auth/sign-in", loginInfo),

    register: (signupInfo) => axios.post(import.meta.env.VITE_API_URL +"/sign-up", signupInfo),

    refreshToken: (refreshToken) => axios.post(import.meta.env.VITE_API_URL +"/refresh-token", refreshToken), 
}