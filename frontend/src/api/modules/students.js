import axios from "axios";
import instance from "./axiosConfig";

import {
  encodeValue,
  decodeValue,
  getCookie,
  setCookie,
  checkCookie,
} from "@js";

// const putStudentRequest = async (studentRequest) => {
//     console.log(studentRequest);
//     await axios({
//         method: 'put',
//         url: import.meta.env.VITE_API_URL + '/api/v1/users/profile',
//         data: studentRequest,
//         headers : {
//             'Authorization': `Bearer ${getCookie('ut') || ''}`,
//             'Accept': 'multipart/form-data'
//         }
//     })
// }

export default {
  getStudentProfile: () => instance.get("/api/v1/users/profile"),
  editStudentProfile: (studentRequest) =>
    instance.puy("/api/v1/users/profile", studentRequest, {
      headers: {
        "Content-Type": "multipart/form-data",
        "Accept": "*/*",
      },
    }),
};
