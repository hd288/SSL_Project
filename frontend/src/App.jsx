import "bootstrap/dist/css/bootstrap.min.css";
import Header from "@components/header";
import MainRoutes from "./routes";
import Footer from "./components/footer/Footer";
import MainNav from "./components/navbar";
import { Col, Container, Row } from "react-bootstrap";

// import './App.css'

function App() {
  return (
    <>
      <Header />

      <Container className="p-0 m-0">
        <Row>
          <Col lg={2} className="px-5 mt-5 ">
            <MainNav />
          </Col>
          <Col lg={10}>
            <MainRoutes />
          </Col>
        </Row>
      </Container>

      <Footer />
    </>
  );
}

export default App;
