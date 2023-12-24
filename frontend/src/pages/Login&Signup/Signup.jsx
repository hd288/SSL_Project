import loginCover from "@assets/login-signup1.gif";
import React from "react";
import { Col, Image, Row, Form, Button, InputGroup } from "react-bootstrap";
import * as formik from "formik";
import * as yup from "yup";

export default function Signup() {
  const { Formik } = formik;

  const schema = yup.object().shape({
    firstName: yup.string().required(),
    lastName: yup.string().required(),
    email: yup.string().email().required(),
    password: yup
      .string()
      .matches(
        /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$/,
        "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one digit, and one special character"
      )
      .required(),
    confirmPassword: yup
      .string()
      .oneOf([yup.ref("password"), null], "Passwords must match")
      .required(),
    terms: yup.bool().required().oneOf([true], "Terms must be accepted"),
  });

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
            validationSchema={schema}
            onSubmit={console.log}
            initialValues={{
              firstName: "",
              lastName: "",
              email: "",
              password: "",
              confirmPassword: "",
              terms: false,
            }}
          >
            {({ handleSubmit, handleChange, values, touched, errors }) => (
              <Form
                noValidate
                onSubmit={handleSubmit}
                className="d-flex flex-column justify-content-center"
              >
                <Row className="mb-3">
                  <Form.Group as={Col} controlId="validationFormik01">
                    <Form.Label>First name</Form.Label>
                    <Form.Control
                      type="text"
                      placeholder="First Name"
                      name="firstName"
                      value={values.firstName}
                      onChange={handleChange}
                      isValid={touched.firstName && !errors.firstName}
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                  </Form.Group>
                  <Form.Group as={Col} controlId="validationFormik02">
                    <Form.Label>Last name</Form.Label>
                    <Form.Control
                      type="text"
                      placeholder="Last Name"
                      name="lastName"
                      value={values.lastName}
                      onChange={handleChange}
                      isValid={touched.lastName && !errors.lastName}
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                  </Form.Group>
                </Row>
                <Row className="mb-3">
                  <Form.Group as={Col} controlId="validationFormik03">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                      type="email"
                      placeholder="Email"
                      name="email"
                      value={values.email}
                      onChange={handleChange}
                      isInvalid={!!errors.email}
                    />
                    <Form.Control.Feedback type="invalid">
                      {"Please enter your email!"}
                    </Form.Control.Feedback>
                  </Form.Group>
                </Row>
                <Row>
                  <Form.Group as={Col} controlId="validationFormik04">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                      type="password"
                      placeholder="Password"
                      name="password"
                      value={values.password}
                      onChange={handleChange}
                      isInvalid={!!errors.password}
                    />
                    <Form.Control.Feedback type="invalid">
                      {"Please enter your password!"}
                    </Form.Control.Feedback>
                  </Form.Group>
                  <Form.Group as={Col} controlId="validationFormik05">
                    <Form.Label>Confirm Password</Form.Label>
                    <Form.Control
                      type="password"
                      placeholder="Confirm Password"
                      name="confirmPassword"
                      value={values.confirmPassword}
                      onChange={handleChange}
                      isInvalid={!!errors.confirmPassword}
                    />
                    <Form.Control.Feedback type="invalid">
                      {"This is a required field!"}
                    </Form.Control.Feedback>
                  </Form.Group>
                </Row>
                <Row className="mb-3"></Row>
                <Form.Group className="mb-3">
                  <Form.Check
                    required
                    name="terms"
                    label="Agree to terms and conditions"
                    onChange={handleChange}
                    isInvalid={!!errors.terms}
                    feedback={errors.terms}
                    feedbackType="invalid"
                    id="validationFormik0"
                  />
                </Form.Group>
                <Button
                  variant="primary"
                  className="my-3 w-75 align-self-center"
                  type="submit"
                >
                  Sign Up
                </Button>
              </Form>
            )}
          </Formik>

          <div className="text-center m-2">
            <p>
              Already have an account?
              <a> Login</a>
            </p>
          </div>
        </Col>
      </Row>
    </div>
  );
}
