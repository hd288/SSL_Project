import React from "react";
import { Button, Container, Nav, Navbar, Row } from "react-bootstrap";
import {
  BsFillHouseFill,
  BsMapFill,
  BsSearch,
  BsFillPostcardFill,
} from "react-icons/bs";
import { Link } from "react-router-dom";

export default function MainNav() {
  return (
    <Navbar className="p-0 m-0 " sticky="top" bg="light" data-bs-theme="light">
      <div className="d-flex flex-row justify-content-center align-items-center">
        <Nav className="me-auto d-flex flex-column justify-content-center mx-2 gap-3">
          <Link to="/" className="text-decoration-none">
            <Nav.Link
              className="btn btn-light text-danger d-flex align-items-center justify-content-start gap-2"
              href="#home"
            >
              <BsFillHouseFill />
              Home
            </Nav.Link>
          </Link>
          <Link to="/careers" className="text-decoration-none">
            <Nav.Link
              className="btn btn-light text-danger d-flex align-items-center justify-content-start gap-2"
              href="#careers"
            >
              <BsMapFill />
              Careers
            </Nav.Link>
          </Link>
          <Link to="/blogs" className="text-decoration-none">
            <Nav.Link
              className="btn btn-light text-danger d-flex align-items-center justify-content-start gap-2"
              href="#blogs"
            >
              <BsFillPostcardFill />
              Blogs
            </Nav.Link>
          </Link>
        </Nav>
      </div>
    </Navbar>
  );
}
