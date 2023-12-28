import axios from "axios";
import instance from "./axiosConfig";

import {
  encodeValue,
  decodeValue,
  getCookie,
  setCookie,
  checkCookie,
} from "@js";


export default {
  getStudentProfile: () => instance.get("/api/v1/users/profile"),
  editStudentProfile: (studentRequest) =>
    instance.put("/api/v1/users/profile", studentRequest, {
      headers: {
        "Content-Type": "multipart/form-data",
        "Accept": "*/*",
      },
    }),
};
