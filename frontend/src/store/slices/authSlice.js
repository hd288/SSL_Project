import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import api from "@api";


const login =  createAsyncThunk( 
    "auth/sign-in",
    async (loginRequest) => {
        const  response = await api.auth.login(loginRequest);
        return await response.data;
    }

)

//InitialState
const initialState ={
    userInfo: {},
    // loading: 'idle' | 'pending' | 'succeeded' | 'failed'
}

const authSlice =  createSlice({
    name: "auth",
    initialState,
    reducers: {
        // standard reducer logic, with auto-generated action types per reducer
    },
    extraReducers: (builder) => {
         // Login
        builder.addCase(login.fulfilled, (state, {payload}) => {
            state.userInfo = payload;
            console.log(payload)
        })
         
              
        // Register
        // builder
        //     .addCase(register.fulfilled, (state, action) => {
        //     // state.isCreated = true;
        //     // state.isLoggedIn = true;
        //     // localStorage.setItem("token", encodeValue(action.payload));
        //     });
            
    }
})


// authSlice
export const authActions = {...authSlice.actions, login};

export default authSlice.reducer;
