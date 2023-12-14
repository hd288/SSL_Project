import React from "react";
import { Button, Container, Form, Image, Navbar } from "react-bootstrap";
import { BsSearch } from "react-icons/bs";
import logo from "@assets/svg.png";

export default function Header() {
  return (
    <Navbar
      expand="lg"
      className="bg-body-tertiary px-3 d-flex justify-content-between align-items-center"
    >
      <Container>
        <Navbar.Brand className="w-50 d-flex justify-content-start align-items-center gap-3">
          <Image href="#" src={logo} className="w-25 rounded" />
          <h5 className="text-secondary fw-lighter">
            Inspire. Learn. Achieve.
          </h5>
        </Navbar.Brand>
      </Container>

      <Form className="d-flex flex-row w-75 h-75">
        <Form.Control
          type="search"
          placeholder="Search for courses ..."
          className="me-2 text-center"
          aria-label="Search"
        />
        <Button variant="outline-primary" className="d-flex align-items-center">
          <BsSearch />
        </Button>
      </Form>

      <Container className="d-flex flex-row justify-content-end gap-2">
        <Button variant="outline-danger">Login</Button>
        <Button variant="danger">Signup</Button>
      </Container>
    </Navbar>
  );
}
