import React, { useState } from "react";
import { ToastContainer } from "react-toastify";
import ToastComponent from "../components/elements/Toast";
import { Container, Image } from "react-bootstrap";
import SingleCarousel from "../components/carousels/SingleCarousel";
import Card from "../components/card/Card";
import CustomPagination from "../components/elements/CustomPagination";

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

  const [currentPage, setCurrentPage] = useState({
    IT: 1,
    Eng: 1,
    Jp: 1,
    Posts: 1,
  });

  const handlePageChange = (pageNumber, section) => {
    setCurrentPage((prev) => ({ ...prev, [section]: pageNumber }));
  };

  const renderItemsForPage = (objectArray, currentPage, itemsPerPage) => {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const itemsToRender = objectArray.slice(startIndex, endIndex);

    return itemsToRender.map((item) => <Card key={item.id} {...item} />);
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
      </div>

      <div className="d-flex flex-column w-100">
        {/* Carousel */}
        <SingleCarousel />

        {/* Section rendering */}
        {["IT", "Eng", "Jp", "Posts"].map((section, index) => (
          <div key={index} className="py-3 m-0 w-100">
            <h3 className="mx-4">{`${section} Courses`}</h3>
            <div className="d-flex flex-wrap gap-5 w-100 justify-content-center">
              {renderItemsForPage(
                yourArrayOfObjects,
                currentPage[section],
                section === "Posts" ? 4 : 8
              )}
            </div>
            <CustomPagination
              totalItems={yourArrayOfObjects.length}
              itemsPerPage={section === "Posts" ? 4 : 8}
              onPageChange={(pageNumber) =>
                handlePageChange(pageNumber, section)
              }
            />
          </div>
        ))}
      </div>
    </div>
  );
}
