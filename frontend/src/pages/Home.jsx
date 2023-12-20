import React, { useState } from "react";
import SingleCarousel from "../components/carousels/SingleCarousel";
import { ToastContainer } from "react-toastify";
import ToastComponent from "../components/elements/Toast";
import { Container, Image } from "react-bootstrap";
import CustomPagination from "../components/elements/CustomPagination";
import Card from "../components/card/Card";

export default function Home() {
  const yourArrayOfObjects = [
    {
      id: 1,
      title: "Lorem ipsum dolor sit 1",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      id: 2,
      title: "Lorem ipsum dolor sit 2",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      id: 3,
      title: "Lorem ipsum dolor sit 3",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      id: 4,
      title: "Lorem ipsum dolor sit 4",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      id: 5,
      title: "Lorem ipsum dolor sit 5",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      id: 6,
      title: "Lorem ipsum dolor sit 6",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      id: 7,
      title: "Lorem ipsum dolor sit 7",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
    {
      id: 8,
      title: "Lorem ipsum dolor sit 8",
      picture:
        "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
      link: "https://mindqsystems.com/wp-content/uploads/2019/08/Core-Java-Training.jpg",
    },
  ];

  const [currentPageIT, setCurrentPageIT] = useState(1);
  const [currentPageEng, setCurrentPageEng] = useState(1);
  const [currentPageJp, setCurrentPageJp] = useState(1);
  const [currentPagePosts, setCurrentPagePosts] = useState(1);

  const handlePageChangeIT = (pageNumber, itemsPP) => {
    setCurrentPageIT(pageNumber);
  };

  const handlePageChangeEng = (pageNumber, itemsPP) => {
    setCurrentPageEng(pageNumber);
  };

  const handlePageChangeJp = (pageNumber, itemsPP) => {
    setCurrentPageJp(pageNumber);
  };

  const handlePageChangePosts = (pageNumber, itemsPP) => {
    setCurrentPagePosts(pageNumber);
  };

  const renderItemsForPage = (objectArray, currentPage, itemsPerPage) => {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const itemsToRender = objectArray.slice(startIndex, endIndex);

    return itemsToRender.map((item) => <Card key={item.id} {...item} />);
  };

  return (
    <>
      <div>
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
          message="Good day! Ready to dive into knowledges?"
        />
      </div>
      {/* Toast above */}

      <div
        className="d-flex justify-content-center flex-column"
        style={{ minWidth: "1550px" }}
      >
        {/* carousel */}
        <SingleCarousel />
        {/* carousel */}

        <h3 className="px-5 mx-5">IT Courses</h3>
        <div className="py-3 m-0 w-100">
          <div className="d-flex flex-wrap gap-5 w-100 justify-content-center">
            {renderItemsForPage(yourArrayOfObjects, currentPageIT, 8)}
          </div>
          <CustomPagination
            totalItems={yourArrayOfObjects.length}
            itemsPerPage={8}
            onPageChange={handlePageChangeIT}
          />
        </div>

        <hr />
        {/* divider */}

        <h3 className=" px-5 mx-5">English Courses</h3>
        <div className="py-3 m-0 w-100">
          <div className="d-flex flex-wrap gap-5 w-100 justify-content-center">
            {renderItemsForPage(yourArrayOfObjects, currentPageEng, 4)}
          </div>
          <CustomPagination
            totalItems={yourArrayOfObjects.length}
            itemsPerPage={4}
            onPageChange={handlePageChangeEng}
          />
        </div>

        <hr />
        {/* divider */}

        <h3 className=" px-5 mx-5">Japanese Courses</h3>
        <div className="py-3 m-0 w-100">
          <div className="d-flex flex-wrap gap-5 w-100 justify-content-center">
            {renderItemsForPage(yourArrayOfObjects, currentPageJp, 4)}
          </div>
          <CustomPagination
            totalItems={yourArrayOfObjects.length}
            itemsPerPage={4}
            onPageChange={handlePageChangeJp}
          />
        </div>

        <hr />
        {/* divider */}

        

        <h3 className=" px-5 mx-5">Popular Posts</h3>
        <div className="py-3 m-0 w-100">
          <div className="d-flex flex-wrap gap-5 w-100 justify-content-center">
            {renderItemsForPage(yourArrayOfObjects, currentPagePosts, 4)}
          </div>
          <CustomPagination
            totalItems={yourArrayOfObjects.length}
            itemsPerPage={4}
            onPageChange={handlePageChangePosts}
          />
        </div>
        
      </div>

      
    </>
  );
}
