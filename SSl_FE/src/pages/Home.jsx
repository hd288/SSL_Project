import React, { useEffect, useState } from "react";
import { ToastContainer } from "react-toastify";
import ToastComponent from "../components/elements/Toast";
// import { Container, Image } from "react-bootstrap";
import SingleCarousel from "../components/carousels/SingleCarousel";
import Card from "../components/card/Card";
import CustomPagination from "../components/elements/CustomPagination";
import { useDispatch, useSelector } from "react-redux";
import { courseActions } from "@store/courseSlice";
import Pagination from "../components/Pagination";

export default function Home() {
  const isRegister = useSelector((store) => store.auth.isRegister);
  const {courses, totalPage, pageNumber}  =  useSelector((store) => store.course)
  const dispatch =  useDispatch();


  useEffect(() => {
    dispatch(courseActions.getCourses())
  }, [pageNumber]);

  const yourArrayOfObjects = [
    {
      courseId: 1,
      courseTitle: "Lorem ipsum dolor sit 1",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      imageCourseUrl:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      courseId: 2,
      courseTitle: "Lorem ipsum dolor sit 2",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      courseId: 3,
      courseTitle: "Lorem ipsum dolor sit 3",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      courseId: 4,
      courseTitle: "Lorem ipsum dolor sit 4",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      courseId: 5,
      courseTitle: "Lorem ipsum dolor sit 5",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      courseId: 6,
      courseTitle: "Lorem ipsum dolor sit 6",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      courseId: 7,
      courseTitle: "Lorem ipsum dolor sit 7",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      courseId: 8,
      courseTitle: "Lorem ipsum dolor sit 8",
      imageCourseUrl:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
  ];

  // const [currentPage, setCurrentPage] = useState({
  //   IT: 1,
  //   Eng: 1,
  //   Jp: 1,
  //   Posts: 1,
  // });
  
  const handleCourseIt = (page) => {
    dispatch(courseActions.getCoursesByPage(page))
  }


  const renderItemsForPage = (courses) => {
    return courses.map((item) => <Card key={item.id} {...item} />);
  };

  return (
    <div className="px-5">
      <div>
        {/* Toast */}
        <ToastContainer
          position="top-right"
          autoClose={4000}
          hideProgressBar={false}
          newestOnTop={true}
          closeOnClick
          rtl={false}
          pauseOnFocusLoss
          draggable
          pauseOnHover
          theme="colored"
        />
        <ToastComponent
          type="info"
          message="Good day! Ready to dive into knowledge?"
        />
        {isRegister ? (
          <ToastComponent type="info" message="Register successfully !" />
        ) : (
          ""
        )}
      </div>

      <div className="d-flex flex-column w-100">
        {/* Carousel */}
        <SingleCarousel />

        {/* Section rendering */}
        <div className="py-3 m-0 w-100">
          <h3 className="mx-4">{`IT Courses`}</h3>
          <div className="d-flex flex-wrap gap-5 w-100 justify-content-center">
            {courses.map((item) => <Card key={item.id} {...item} />)}
          </div>
          {/* <Pagination totalPages={totalPage} curPage={pageNumber} getCoursesOfPage={handleCourseIt}/> */}
          {/* <CustomPagination
            // totalItems={totalPage}
            // itemsPerPage={courses.length}
            // onPageChange={(pageNumber) => handlePageChange(pageNumber)}
          /> */}
        </div>

        {["Eng", "Jp", "Posts"].map((section, index) => (
          <div key={index} className="py-3 m-0 w-100">
            <h3 className="mx-4">{`${section} Courses`}</h3>
            <div className="d-flex flex-wrap gap-5 w-100 justify-content-center">
              {renderItemsForPage(
                yourArrayOfObjects,
                1,
                section === "Posts" ? 4 : 8
              )}
            </div>
            {/* <CustomPagination
              totalItems={yourArrayOfObjects.length}
              itemsPerPage={section === "Posts" ? 4 : 8}
              // onPageChange={(pageNumber) =>
              //   handlePageChange(pageNumber, section)
              // }
            /> */}
          </div>
        ))}
      </div>
    </div>
  );
}

