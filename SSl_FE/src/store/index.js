import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./slices/authSlice";
import studentSlice from "./slices/studentSlice";
import courseReducer from './slices/courseSlice';

const store =  configureStore({
    reducer: {
        auth: authReducer,
        students: studentSlice,
        course: courseReducer,
    },
});

export default store;