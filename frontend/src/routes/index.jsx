import { Route, Routes } from "react-router-dom";
import React from "react";
import Home from "../pages/Home";
import Blogs from "../pages/Blogs";
import Careers from "../pages/Careers";

export default function MainRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/blogs" element={<Blogs />} />
      <Route path="/careers" element={<Careers />} />
    </Routes>
  );
}
