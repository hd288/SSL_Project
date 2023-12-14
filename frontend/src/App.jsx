import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/header";
import { Col, Container, Row } from "react-bootstrap";
import MainNav from "./components/navbar";
import TestHeader from "./components/header/test";

// import './App.css'

function App() {
  return (
    <>
      {/* <Header /> */}
      <TestHeader />
      {/* <Container className="p-0 m-0">
        <Row>
          <Col sm={2}>
            <MainNav />
          </Col>
          <Col sm={10}>sm=8</Col>
        </Row>
      </Container> */}
    </>
  );
}

export default App;
