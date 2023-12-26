import axios from "axios";

export default {
    getCourses: () => axios.get(import.meta.env.VITE_API_URL + '/api/v1/users/home-courses'),
    getCoursesByPage: (page) => axios.get(import.meta.env.VITE_API_URL + `/api/v1/users/home-courses?page=${page}`),
    getCourseById: (courseId) => axios.get(import.meta.env.VITE_API_URL + `/api/v1/users/courses/${courseId}`),
    getCoursesByNameOrDesc: (courseName) => axios.get(import.meta.env.VITE_API_URL + `/api/v1/admin/courses/search/keyword=${courseName}`)
}