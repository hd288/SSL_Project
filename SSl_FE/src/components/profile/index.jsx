import React, { useEffect, useState } from "react";
import "./profile.css";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { studentActions } from "../../store/slices/studentSlice";
import { authActions } from "@store/authSlice";
import api from '@api';
import { ListGroup } from "react-bootstrap";


export default function Profile({tokenRq}) {
  const [isShow, setIsShow] = useState(false);
  const dispatch = useDispatch();

  const { user, tokenRefreshRequest } = useSelector((store) => store.auth)
  const { userInfo, isUpdate } = useSelector((store) => store.students)

  const [tokenObj, setTokenObj] = useState()
  const [avatar, setAvatar] =  useState()
  const [fullName, setFullName] =  useState()


  const handleLogout = () => {
    dispatch(authActions.logout(tokenObj));
  };


  useEffect(() => {
    setTokenObj(tokenRefreshRequest)
    setAvatar(user.image)
    setFullName(user.fullName)

    if(isUpdate) {
      setAvatar(userInfo.image)
      setFullName(userInfo.firstName + ' ' +userInfo.lastName)
    }
  }, [isUpdate, userInfo]);


  const handleGetProfile = () => {
    dispatch(studentActions.getStudentProfile());
  };

  return (
    <div className="profile-container">
      <div className="profile-info">
        <img
          src={ 
              avatar !== null 
              ? avatar
              : "https://th.bing.com/th/id/R.3abb4bc7c23af5666c75aeb4552afc8b?rik=qkoqoTbRhOmbvQ&pid=ImgRaw&r=0"
          }
          alt="avatar"
        />
        <p href="" className="full-name me-2 ">
          {fullName}
        </p>
        <i
          id="profile-menu"
          className="fa-solid fa-caret-down profile-menu"
          onClick={() => setIsShow(!isShow)}
        ></i>
      </div>
      {isShow ? (
        <ul className="profile-menu-list">
          <li>
            {/* <a href="">Profile</a> */}
            <Link to="/user/profile" onClick={() => handleGetProfile()}>
              Profile
            </Link>
          </li>
          <li>
            <Link to="/user/password">Change password</Link>
          </li>
          <li >
            <button className="btn-logout" onClick={() => handleLogout()}>Logout</button>
          </li>
        </ul>
      ) : (
        ""
      )}
    </div>
  );
}
