import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import api from "@api";
import { useNavigate } from "react-router-dom";

import {
  encodeValue,
  decodeValue,
  getCookie,
  setCookie,
  checkCookie,
} from "@js";

const initialState = {
  users: [],
  userInfo: {},
  isUpdate: false
};

// Get Student Profile
const getStudentProfile = createAsyncThunk("student/profile", async () => {
  try {
    const response = await api.students.getStudentProfile();
    return response.data;
  } catch (err) {
    return err.response.data;
  }
});

// Get Student Profile
const editStudentProfile = createAsyncThunk(
  "student/profile/edit",
  async (studentRequest) => {

    try {
      const response = await api.students.editStudentProfile(studentRequest);

      return response.data;
    } catch (err) {

      return err.response.data;
    }
  }
);

const studentSlice = createSlice({
  name: "student",
  initialState: initialState,
  extraReducers: (builder) => {
    builder.addCase(getStudentProfile.fulfilled, (state, action) => {
      state.userInfo = action.payload;
    });

    // Edit profile
    builder.addCase(editStudentProfile.fulfilled, (state, action) => {
        state.userInfo = action.payload;
        state.isUpdate = true;
    });
  },
});

export const studentActions = { ...studentSlice.actions, getStudentProfile, editStudentProfile };
export default studentSlice.reducer;
