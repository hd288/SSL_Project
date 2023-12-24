import axios from 'axios';
import {
    encodeValue, 
    decodeValue, 
    getCookie, 
    setCookie,
    checkCookie,
} from "@js"

const instance = axios.create({
  baseURL: import.meta.env.VITE_API_URL
});

// Alter defaults after instance has been created
instance.defaults.headers.common['Authorization'] = `Bearer ${getCookie('ut') || ''}`;
// instance.defaults.headers.put['Content-Type'] = 'multipart/form-data';

export default instance