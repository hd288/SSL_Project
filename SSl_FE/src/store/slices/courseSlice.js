import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import api from "@api";


const getCourses = createAsyncThunk(
    "courses/getCourses", async () => {
  try {
    const response = await api.courses.getCourses();
    return await response.data;
  } catch (err) {
    console.log(err);
  }
});

const getCoursesByPage = createAsyncThunk(
  "courses/getCoursesByPage",
  async (page) => {
    try {
      const response = await api.courses.getCoursesByPage(page);
      return await response.data;
    } catch (err) {
      console.log(err);
    }
  }
);

const getCourseById = createAsyncThunk(
  "courses/getCoursesByName",
  async (courseId) => {
    try {
      const response = await api.courses.getCourseById(courseId);
      return await response.data;
    } catch (err) {
      console.log(err);
    }
  }
);

const initialState = {
  courses: [],
  course: {},
  totalPage: 1,
  pageNumber: 0,
  pageSize: 8,
//   isLoading: false,
};

const courseSlice = createSlice({
  name: "course",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(getCourses.fulfilled, (state, action) => {
      state.courses = action.payload.data;
      state.totalPage = action.payload.totalPage;
      state.pageNumber = action.payload.pageNumber;
    });

    builder.addCase(getCoursesByPage.fulfilled, (state, action) => {
      state.courses = action.payload.data;
      state.totalPage = action.payload.totalPage;
      state.pageNumber = action.payload.pageNumber;

    });
    
    builder.addCase(getCourseById.fulfilled, (state, action) => {
      state.course = action.payload
      console.log(state.course);
    });
  },
});

export const courseActions = { ...courseSlice.actions, getCourses, getCoursesByPage, getCourseById };
export default courseSlice.reducer;
