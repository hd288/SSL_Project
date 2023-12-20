import React from "react";
import { Col, Image, Row, Form, Button, Container } from "react-bootstrap";
import loginCover from "@assets/login-signup2.gif";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faFacebookF,
  faTwitter,
  faGoogle,
} from "@fortawesome/free-brands-svg-icons";

export default function Login() {
  return (
    <div>
      <Row>
        <Col lg={6}>
          <Image
            src={loginCover}
            className="object-fit-contain w-100 h-100"
            style={{ minHeight: "32rem" }}
          />
        </Col>
        <Col lg={6} className="d-flex flex-column justify-content-center p-5">
          <Form>
            <Form.Group
              as={Row}
              className="mb-3"
              // controlId="formPlaintextPassword"
            >
              <Form.Label column sm="2">
                Email
              </Form.Label>
              <Col sm="10">
                <Form.Control
                  type="text"
                  className="border-secondary w-100"
                  placeholder="email@example.com"
                />
              </Col>
            </Form.Group>

            <Form.Group
              as={Row}
              className="mb-3"
              // controlId="formPlaintextPassword"
            >
              <Form.Label column sm="2">
                Password
              </Form.Label>
              <Col sm="10">
                <Form.Control
                  type="password"
                  className="border-secondary w-100"
                  placeholder="Password"
                />
              </Col>
            </Form.Group>

            <Form.Group className="mb-3  d-flex justify-content-center">
              <Form.Check
                className="border-danger"
                label="Remember me"
                // required
                // name="terms"
                // onChange={handleChange}
                // isInvalid={!!errors.terms}
                // feedback={errors.terms}
                // feedbackType="invalid"
                // id="validationFormik0"
              />
            </Form.Group>

            <Button
              variant="outline-primary"
              className="w-100 align-self-center"
              type="submit"
            >
              Login
            </Button>
          </Form>

          <div className="text-center m-2">
            <p>
              Don't have an account?
              <a> Register</a>
            </p>
          </div>

          <div className="text-center">
            <p>or join us with:</p>
            <Container className="d-flex justify-content-center gap-2">
              <Button variant="outline-danger">
                <FontAwesomeIcon icon={faGoogle} />
              </Button>
              <Button variant="outline-danger">
                <FontAwesomeIcon icon={faFacebookF} />
              </Button>
              <Button variant="outline-danger">
                <FontAwesomeIcon icon={faTwitter} />
              </Button>
            </Container>
          </div>
        </Col>
      </Row>
    </div>
  );
}
