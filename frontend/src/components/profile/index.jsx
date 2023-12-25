import React, { useEffect, useState } from "react";
import "./profile.css";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { studentActions } from "../../store/slices/studentSlice";
import { authActions } from "@store/authSlice";
import api from '@api';


export default function Profile({tokenRq}) {
 
  const [tokenObj, setTokenObj] = useState({})
  const [isShow, setIsShow] = useState(false);
  const dispatch = useDispatch();
  const { user, isLogin, tokenRefreshRequest } = useSelector((store) => store.auth);
  const { userInfo } = useSelector((store) => store.students);

   const [avatar, setAvatar] = useState(user.image);

  const handleLogout = () => {
    dispatch(authActions.logout(tokenObj));
  };

  useEffect(() => {
      setTokenObj(tokenRefreshRequest)
  }, [isLogin]);

    useEffect(() => {
      setAvatar(userInfo.image)
  }, [userInfo]);

  const handleGetProfile = () => {
    dispatch(studentActions.getStudentProfile());
  };

  return (
    <div className="profile-container">
      <div className="profile-info">
        <img
          src={
            user.image !== null
              ? avatar
              : "https://th.bing.com/th/id/R.3abb4bc7c23af5666c75aeb4552afc8b?rik=qkoqoTbRhOmbvQ&pid=ImgRaw&r=0"
          }
          alt="avatar"
        />
        <p href="" className="full-name me-2 ">
          {user.fullName}
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
            <Link to="/user" onClick={() => handleGetProfile()}>
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
