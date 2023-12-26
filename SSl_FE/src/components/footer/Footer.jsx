import React from "react";
import "./footer.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Container, Row, Col } from "react-bootstrap";
import {
  faFacebookF,
  faGithub,
  faTwitter,
  faInstagram,
  faYoutube,
} from "@fortawesome/free-brands-svg-icons";
import { BsGem } from "react-icons/bs";

export default function Footer() {
  return (
    <>
      <Container className="d-flex justify-content-center flex-column p-4 border-bottom text-center">
        <div className="py-2 mb-5 d-none d-lg-block">
          <h5>Get connected with us on social networks:</h5>
        </div>

        <Container>
          <Row className="wrapper">
            <Col className="icon facebook">
              <a href="https://www.facebook.com/not.hiepdinh/" target="_blank">
                <FontAwesomeIcon
                  style={{ color: "#3b5999 !important" }}
                  icon={faFacebookF}
                />
                <span className="tooltip">Facebook</span>
              </a>
            </Col>

            <Col className="icon twitter">
              <a href="https://twitter.com/hiepdinhh" target="_blank">
                <FontAwesomeIcon
                  style={{ color: "#46c1f6" }}
                  icon={faTwitter}
                />
                <span className="tooltip">Twitter</span>
              </a>
            </Col>
            <Col className="icon instagram">
              <a href="https://www.instagram.com/hiep.dx_" target="_blank">
                <FontAwesomeIcon
                  style={{ color: "#e1306c" }}
                  icon={faInstagram}
                />
                <span className="tooltip">Instagram</span>
              </a>
            </Col>
            <Col className="icon youtube">
              <a href="https://www.youtube.com/" target="_blank">
                <FontAwesomeIcon
                  style={{ color: "#de463b" }}
                  icon={faYoutube}
                />
                <span className="tooltip">Youtube</span>
              </a>
            </Col>
            <Col className="icon github">
              <a href="https://github.com/hd288" target="_blank">
                <FontAwesomeIcon style={{ color: "#333" }} icon={faGithub} />
                <span className="tooltip">Github</span>
              </a>
            </Col>
          </Row>
        </Container>

        <Container className="p-0 pt-5">
          <Row>
            <Col>
              <h6 className="text-uppercase fw-bold mb-4">
                <BsGem /> &nbsp; SwiftSkills LAB
              </h6>
              <p>
                Discover the Joy of Learning with Us. We Craft Unforgettable
                Educational Journeys, Opening Doors to the World's Most
                Inspiring Knowledge Destinations.
              </p>
            </Col>
            <Col>
              <h6 className="text-uppercase fw-bold mb-4">
                {" "}
                <BsGem /> &nbsp; About us
              </h6>
              <p>
                <a href="#!" className="text-reset">
                  Company profile
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Certificates
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Privacy policies
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  FAQs
                </a>
              </p>
            </Col>

            <Col>
              <h6 className="text-uppercase fw-bold mb-4">
                {" "}
                <BsGem /> &nbsp; Contact
              </h6>
              <p>
                <p color="secondary" icon="home" className="me-2" />
                Ha Long, Quang Ninh, Viet Nam
              </p>
              <p>
                <p color="secondary" icon="envelope" className="me-2" />
                dxhiep288@gmail.com
              </p>
              <p>
                <p color="secondary" icon="phone" className="me-2" />+ 84 355
                963 288
              </p>
              <p>
                <p color="secondary" icon="print" className="me-2" /> + 84 355
                963 288
              </p>
            </Col>
          </Row>
        </Container>
      </Container>
    </>
  );
}
