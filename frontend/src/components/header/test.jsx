import logo from "@assets/svg.png";
import {
  Image,
  Button,
  Container,
  Form,
  Nav,
  Navbar,
  NavDropdown,
  Offcanvas,
} from "react-bootstrap";

import {
  BsFillHouseFill,
  BsSearch,
  BsMapFill,
  BsFillPostcardFill,
} from "react-icons/bs";

export default function TestHeader() {
  return (
    <Navbar expand="sm" className="border-bottom bg-body-tertiary mx-3">
      <Container fluid className="d-flex justify-content-between ">
        <Navbar.Brand className="col-sm-3 d-flex flex-column justify-content-start align-items-center">
          <Container className=" d-flex justify-content-between align-items-center">
            <Image href="#" src={logo} className="w-25 rounded" />
            <h5 className="text-secondary fw-lighter">
              Inspire. Learn. Achieve.
            </h5>
          </Container>
          <Navbar.Toggle aria-controls="headerScroll" />
        </Navbar.Brand>
        {/*  */}
        {/*  */}
        <Navbar.Collapse id="headerScroll">
          <Container className="w-100 d-flex justify-content-end">
            <Container className="w-100 p-0 d-flex flex-column justify-content-center align-items-center">
              <Nav headerScroll className="d-flex gap-3">
                <Nav.Link
                  className="fs-5 fw-lighter px-3 btn btn-light d-flex align-items-center gap-2"
                  href="#home"
                >
                  <BsFillHouseFill />
                  Home
                </Nav.Link>
                <Nav.Link
                  className="fs-5 fw-lighter px-3 btn btn-light d-flex align-items-center gap-2"
                  href="#careers"
                >
                  <BsMapFill />
                  Careers
                </Nav.Link>
                <Nav.Link
                  className="fs-5 fw-lighter px-3 btn btn-light d-flex align-items-center gap-2"
                  href="#blogs"
                >
                  <BsFillPostcardFill />
                  Blogs
                </Nav.Link>
              </Nav>
              <Form className="d-flex w-75 my-4">
                <Form.Control
                  type="search"
                  placeholder="Search for courses ..."
                  className="me-2 fw-lighter text-center"
                  aria-label="Search"
                />
                <Button
                  variant="outline-primary"
                  className="d-flex align-items-center"
                >
                  <BsSearch />
                </Button>
              </Form>
            </Container>
            <Container className="w-50 p-0 m-0 d-flex flex-column justify-content-center align-items-end">
              <Button className="my-1 fw-light" variant="outline-danger">Login &nbsp;</Button>
              <Button className="my-1 fw-light" variant="danger">Signup</Button>
            </Container>
          </Container>
        </Navbar.Collapse>
      </Container>

    </Navbar>
  );
}
