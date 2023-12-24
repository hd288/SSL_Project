import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import api from "@api";

// const fetchCourses = async () => {
//     try {
//         const response = await api.courses.getCourses();
//         return await response.data
//     }catch(err) {
//         return await err.response.data
//     }
// }

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

const initialState = {
  courses: [],
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

    builder.addCase(getCoursesByPage.fulfilled, (state, action) => {;
      state.courses = action.payload.data;
      console.log(state.courses);
      state.totalPage = action.payload.totalPage;
      state.pageNumber = action.payload.pageNumber;

    });
  },
});

export const courseActions = { ...courseSlice.actions, getCourses, getCoursesByPage };
export default courseSlice.reducer;
