import React from "react";

import Home from "../pages/Home";
import ProfileDetail from "../components/ProfileDetail";

import { Route, Routes } from "react-router-dom";
import PasswordForm from "../components/ProfileDetail/PasswordForm/PasswordForm";
import UserPage from "../pages/UserPage";
import Careers from "../pages/Careers";

export default function MainRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/user" element={<UserPage />}/>
      <Route path="/careers" element={<Careers />}/>
      {/* <Route path="/user/profile" element={<ProfileDetail/>} />
      <Route path="/user/password" element={<PasswordForm/>} /> */}
    </Routes>
  );
}