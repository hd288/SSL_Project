import React, { useState } from "react";
import { Image } from "react-bootstrap";
import "./card.css";
import { Link } from "react-router-dom";
import courses from "../../api/modules/courses.";
import { useDispatch } from "react-redux";
import { courseActions } from "@store/courseSlice.js"

export default function Card(props) {
  const dispatch = useDispatch();

  const [bgImg] = useState([
    "linear-gradient(to right, #FF512F 0%, #F09819  51%, #FF512F  100%)",
    "linear-gradient(to right, #DD5E89 0%, #F7BB97  51%, #DD5E89  100%)",
    "linear-gradient(to right, #1CD8D2 0%, #93EDC7  51%, #1CD8D2  100%)",
    "linear-gradient(to right, #1e3c72 0%, #2a5298  51%, #1e3c72  100%)",
    "linear-gradient(to right, #834d9b 0%, #d04ed6  51%, #834d9b  100%)",
    "linear-gradient(to right, #43C6AC 0%, #191654  51%, #43C6AC  100%)",
    "linear-gradient(to right, #ED4264 0%, #FFEDBC  51%, #ED4264  100%)",
    "linear-gradient(to right, #a73737 0%, #7a2828  51%, #a73737  100%)",
    "linear-gradient(to right, #9D50BB 0%, #6E48AA  51%, #9D50BB  100%)",
    "linear-gradient(to right, #B24592 0%, #F15F79  51%, #B24592  100%)",
    "linear-gradient(to right, #3a7bd5 0%, #3a6073  51%, #3a7bd5  100%)",
    "linear-gradient(to right, #de6161 0%, #2657eb  51%, #de6161  100%)",
    "linear-gradient(to right, #6190E8 0%, #A7BFE8  51%, #6190E8  100%)",
    "linear-gradient(to right, #c0392b 0%, #8e44ad  51%, #c0392b  100%)",
    "linear-gradient(to right, #06beb6 0%, #48b1bf  51%, #06beb6  100%)",
    "linear-gradient(to right, #36D1DC 0%, #5B86E5  51%, #36D1DC  100%)",
    "linear-gradient(to right, #007991 0%, #78ffd6  51%, #007991  100%)",
  ]);
  const getRandomBgImg = () => {
    const randomIndex = Math.floor(Math.random() * bgImg.length);
    return bgImg[randomIndex];
  };

  const handleGetCourse = (courseId) => {
    dispatch(courseActions.getCourseById(courseId))
  }

  return (
    <div>
      <div
        key={props.courseName}
        className="text-center anchor-overlay d-flex flex-column justify-content-center align-items-start position-relative"
      >
        <div
          className="h-100 rounded d-flex justify-content-center align-items-center text-light px-2"
          style={{
            width: "270px",
            minHeight: "165px",
            background: getRandomBgImg(),
          }}
        >
          {props.courseTitle} 
        </div>
        <div className=" position-absolute w-100 h-100  align-items-center justify-content-center">
          <Link
            to="/course"
             className="btn btn-light w-50 "
             rel="noopener noreferrer"
             onClick={() => handleGetCourse(props.courseId)}
          >  
            See more 
          </Link>
        </div>
      </div>
    </div>
  );
}
