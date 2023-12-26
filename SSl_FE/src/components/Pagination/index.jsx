/* eslint-disable react/prop-types */
import React, { useEffect, useState } from 'react'
import "./pagination.css"
import { useSelector } from "react-redux";

export default function Pagination ({totalPages, curPage, getCoursesOfPage }) {
  const [pageNumbers, setPageNumbers] = useState([])
 
  const handlePageChange = (page) => {
      getCoursesOfPage(page)
  }; 

  useEffect(() => {
    const items = []
    for (let i = 1; i <= totalPages; i++) {
      items.push(i)
    }

    setPageNumbers(items)
  }, [])
 

  return (
    <div className='custom-pagination'>
      <ul className="pagination">
        {/* <li className="page-item">
          <button className={`page-link ${currentPage === 1 ? 'd-none' : ''}`}>
            <i className="fa-solid fa-chevron-left"></i>
          </button>
        </li> */}
          {pageNumbers.map(item => (
              <li key={item} className="page-item">
                <button 
                  onClick={() => handlePageChange(item)}
                  className={`page-link ${item === curPage ? 'active' : ''}`}
                >
                  {item}
                </button>
              </li>
          ))}
        {/* <li className="page-item">
          <button className={`page-link ${currentPage === totalPages ? 'd-none' : ''}`}>
            <i className="fa-solid fa-chevron-right"></i>
          </button>
        </li> */}
      </ul>
    </div>
  )
}
