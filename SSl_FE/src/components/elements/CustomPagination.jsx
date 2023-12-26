// CustomPagination.jsx
import React, { useState } from 'react';
import Pagination from 'react-bootstrap/Pagination';
import { useDispatch, useSelector } from "react-redux";
import { courseActions } from "@store/courseSlice";

const CustomPagination = ({ totalItems, itemsPerPage, onPageChange }) => {
  const [currentPage, setCurrentPage] = useState(1);
  const totalPages = Math.ceil(totalItems / itemsPerPage);
  const dispatch =  useDispatch();
  

  const handlePageChange = (pageNumber) => {
    dispatch(courseActions.getCoursesByPage(pageNumber))
    setCurrentPage(pageNumber);
    onPageChange(pageNumber, itemsPerPage);
  };

  const renderPaginationItems = () => {
    const items = [];
    for (let i = 1; i <= totalPages; i++) {
      items.push(
        <Pagination.Item
          key={i}
          active={i === currentPage}
          onClick={() => handlePageChange(i)}
        >
          {i}
        </Pagination.Item>
      );
    }
    return items;
  };

  return (
    <Pagination className='d-flex flex-row justify-content-start  pt-4'>
      <Pagination.Prev
        onClick={() => handlePageChange(currentPage - 1)}
        disabled={currentPage === 1}
      />
      {renderPaginationItems()}
      <Pagination.Next
        onClick={() => handlePageChange(currentPage + 1)}
        disabled={currentPage === totalPages}
      />
    </Pagination>
  );
};

export default CustomPagination;
