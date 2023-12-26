import React, { useState } from 'react'
import ProfileDetail from '../components/ProfileDetail'
import Home from './Home'
import { Navigate } from 'react-router-dom'
import Page401 from '../components/401';
import { useSelector } from 'react-redux';

export default function UserPage() {
  const { user, isLogin, isRegister, tokenRefreshRequest, errorMessage} = useSelector(store => store.auth)

    // const [isLogin, setIsLogin] = useState(false);
    // const[user, setUser] = useState({
    //     'role' : ['ROLE_USER']
    // })


  return (
    <>
        {  
            isLogin && (user.roles.indexOf('ROLE_STUDENT') !== -1) ? 
            <ProfileDetail/> : 
            <Page401 />
        }
    </>
  )
}
