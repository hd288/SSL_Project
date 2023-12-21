import "bootstrap/dist/css/bootstrap.min.css";
import Header from "@components/header";
import MainRoutes from "./routes";
import Footer from "./components/footer/Footer";
import MainNav from "./components/navbar";
import { Col, Container, Row } from "react-bootstrap";

// import './App.css'

function App() {
  return (
    <div className="w-100">
      <Header />

      <div className="d-flex flex-row w-100 px-5">
        <div className="d-flex flex-column mt-5" style={{width:"10%"}}>
          <MainNav />
        </div>
        <div className="d-flex flex-column "  style={{width:"90%"}}>
          <MainRoutes />
        </div>
      </div>

      <Footer />
    </div>
  );
}

export default App;
