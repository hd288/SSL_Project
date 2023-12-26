import React from "react";

import Home from "../pages/Home";
import ProfileDetail from "../components/ProfileDetail";

import { Route, Routes } from "react-router-dom";
import PasswordForm from "../components/ProfileDetail/PasswordForm/PasswordForm";
import UserPage from "../pages/UserPage";
import Careers from "../pages/Careers";
import CoursePage from "../pages/CoursePage";
import Blogs from "../pages/Blogs";
import Lesson from "../components/lesson/Lesson";

export default function MainRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/careers" element={<Careers />}/>
      <Route path="/blogs" element={<Blogs />}/>
      <Route path="/user" element={<UserPage />}/>
      <Route path="/careers" element={<Careers />}/>
      <Route path="/course" element={<CoursePage />}/>
      <Route path="/lesson" element={<Lesson />}/>
    </Routes>
  );
}