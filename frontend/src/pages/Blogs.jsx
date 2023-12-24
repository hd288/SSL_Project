import React, { createContext, useEffect, useState, useCallback } from 'react';
import Error from "../components/elements/Error";
export default function Blogs() {
  console.log(import.meta.env.VITE_API_URL)
  
  return (
    <div>
      Blogs
      <Error />
    </div>
  );
}