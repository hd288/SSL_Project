import { Route, Routes } from "react-router-dom";
import React from "react";
import Home from "../pages/Home";
import Blogs from "../pages/Blogs";

export default function MainRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/blogs" element={<Blogs />} />
    </Routes>
  );
}
