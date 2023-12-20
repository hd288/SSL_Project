import { Route, Routes } from "react-router-dom";
import React from "react";
import Home from "../pages/Home";

export default function MainRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
    </Routes>
  );
}
