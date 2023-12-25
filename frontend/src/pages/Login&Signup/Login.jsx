import React, { useState } from "react";
import { Col, Image, Row, Form, Button, Container } from "react-bootstrap";
import loginCover from "@assets/login-signup2.gif";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faFacebookF,
  faTwitter,
  faGoogle,
} from "@fortawesome/free-brands-svg-icons";

import { useDispatch, useSelector } from "react-redux";
import { Formik, Field, ErrorMessage } from "formik";
import { authActions } from "@store/authSlice";


import * as formik from "formik";
// import * as yup from "yup";

export default function Login() {
  const dispatch = useDispatch();

   const signUpFormValid = async (values) => {
    const errors = {};

    if (!values.email) {
      errors.email = "Please enter email !";
    } else if (
      !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)
    ) {
      errors.email = "Invalid email address";
    } 

    if (!values.password) {
      errors.password = "Please enter password !";
    }

    return errors;
  };

  const handleLogin = (loginRequest) => {
    dispatch(authActions.signIn(loginRequest))
  }

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
        <Formik
            initialValues={{
              email: "",
              password: "",
              // checkRemember: true,
            }}
            validate={signUpFormValid}
            onSubmit={(values, { resetForm }) => {
              handleLogin(values);
              resetForm();
            }}
          >
              {({ handleSubmit, handleChange, values }) => (       
                <Form
                    noValidate
                    onSubmit={handleSubmit}
                    className="d-flex flex-column justify-content-center">
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
                        type="email"
                        name="email"
                        value={values.email}
                        onChange={handleChange}
                        className="border-secondary w-100"
                        placeholder="email@example.com"
                       />
                     </Col>
                      <ErrorMessage name="email">
                        {(message) => (<div className="text-danger ">{message}</div>)}
                      </ErrorMessage>
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
                        name="password"
                        type="password"
                        className="border-secondary w-100"
                        placeholder="Password"
                        value={values.password}
                        onChange={handleChange}
                       />
                     </Col>
                     <ErrorMessage name="password">
                          {(message) => (
                            <div className="text-danger">{message}</div>
                          )}
                     </ErrorMessage>
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
                     className="w-75 align-self-center"
                     type="submit"
                   >
                     Login
                   </Button>
                </Form>
              )}
          </Formik>
       

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
