import logo from "@assets/svg.png";
import { Image, Button, Container, FormControl } from "react-bootstrap";
import MyModal from "../elements/MyModal";
import Login from "../../pages/Login&Signup/Login";
import Signup from "../../pages/Login&Signup/Signup";

export default function Header() {
  return (
    <div className="py-3 mx-5 d-flex justify-content-between align-items-center border-bottom py-2">
      <Container className="p-0 m-0 d-flex flex-row justify-content-start align-items-center gap-3">
        <Image
          href="#"
          src={logo}
          className="rounded"
          style={{ maxWidth: "70px" }}
        />
        <h4 className="text-danger fw-lighter m-0">SwiftSkills Lab</h4>
      </Container>
      <Container className="p-0 m-0 d-flex flex-row justify-content-center align-items-center">
        <FormControl
          className="mx-2 w-75 border-danger"
          placeholder="Search for courses, posts, videos..."
        />
      </Container>
      <Container className="p-0 m-0 d-flex flex-row justify-content-end align-items-center gap-3">
        <MyModal
          buttonText="Login"
          modalTitle="Login Form"
          modalBodyComponent={<Login />}
          buttonVariant="outline-danger"
        />
        <MyModal
          buttonText="Sign up"
          modalTitle="Sign up Form"
          modalBodyComponent={<Signup />}
          buttonVariant="danger"
        />
      </Container>
    </div>
  );
}
