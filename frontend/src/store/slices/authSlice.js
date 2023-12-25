import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import api from "@api";
import {
    encodeValue, 
    decodeValue, 
    getCookie, 
    setCookie,
    deleteCookie
} from "@js"

let userInfo = getCookie('u') || ''

const signIn =  createAsyncThunk( 
    "auth/sign-in",
    async (loginRequest) => {
        try {
            const  response = await api.auth.login(loginRequest);
            return await response.data;
        }catch (error) {
 
            return error.response.data;
        }
       
    }
)

const signUp =  createAsyncThunk( 
    "auth/sign-up",
    async (signupInfo, {rejectWithValue}) => {
        try {
            const  response = await api.auth.register(signupInfo);
            return await response.data;
        }catch (error) {
            return rejectWithValue(error.response.data);
        }
       
    }
)


const logout =  createAsyncThunk( 
    "auth/logout",
    async (logoutRequest, {rejectWithValue}) => {
        try {
            const  response = await api.auth.logout(logoutRequest);
            return await response.data;
        }catch (error) {
            return rejectWithValue(error.response.data);
        }
       
    }
)

//InitialState
const initialState ={
    user: userInfo.length > 0 ? decodeValue(userInfo) : {} ,
    isLogin: userInfo.length > 0 ? true : false,
    isRegister: false,
    isLogout: false,
    tokenRefreshRequest: {
        refreshToken: userInfo.length > 0 ? decodeValue(userInfo).refreshToken : {} 
    },
    errorMessage: ''
        
}

const authSlice =  createSlice({
    name: "auth",
    initialState,
    reducers: {

    },
    extraReducers: (builder) => {
        // Login
        builder
            .addCase(signIn.fulfilled, (state, action) => {

                if (action.payload.httpStatus !== 'UNAUTHORIZED') {
                    state.userInfo = action.payload
                    setCookie('ut', action.payload.accessToken, (new Date()).getTime() + 24*60*60*1000)

                    let cookieValue = encodeValue(state.userInfo)
                    setCookie('u', cookieValue, action.payload.expiryDate)
                   
                    state.isLogin = true
                }else {
                    state.errorMessage = action.payload.message
                }
            })
           // register
           builder
           .addCase(signUp.fulfilled, (state, action) => {
                if(action.httpStatus === 'CREATED') {
                    state.isRegister = true,

                    setTimeout(() => {
                        state.isRegister = false
                    }, 2000)
                }
           })
           .addCase(signUp.rejected, (state, action) => {
            console.log(action.payload.validateMessage.email);
                state.errorMessage = action.payload.validateMessage.email
            
           })

             // register
             builder
             .addCase(logout.fulfilled, (state, action) => {
                console.log(action.payload);
                deleteCookie('u'),
                deleteCookie('ut'),
                state.isLogin = false
            
             })
             .addCase(logout.rejected, (state, action) => {
                console.log(action.payload);
             })
    }
})


// // authSlice
export const authActions = { ...authSlice.actions, signIn, signUp, logout }r
export default authSlice.reducer;

