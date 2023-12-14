import React from "react";
import { Button, Container, Nav, Navbar, Row } from "react-bootstrap";
import { BsFillHouseFill,BsMapFill,BsFillPostcardFill   } from "react-icons/bs";

export default function MainNav() {
  return (
    <Navbar bg="light" data-bs-theme="light">
      <Container>
        <Nav className="me-auto d-flex flex-column mx-2 gap-3">
          <Nav.Link
            className="btn btn-light d-flex align-items-center justify-content-start gap-2"
            href="#home"
          >
            <BsFillHouseFill />
            Home
          </Nav.Link>
          <Nav.Link
            className="btn btn-light d-flex align-items-center justify-content-start gap-2"
            href="#features"
          >
            <BsMapFill  />
            Careers
          </Nav.Link>
          <Nav.Link
            className="btn btn-light d-flex align-items-center justify-content-start gap-2"
            href="#pricing"
          >
            <BsFillPostcardFill  />
            Blogs
          </Nav.Link>
        </Nav>
      </Container>
    </Navbar>
  );
}
