import "../profile-detail.css";
import { Field, Formik, ErrorMessage } from "formik";
import { Form } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { authActions } from "../../../store/slices/authSlice";
import { useEffect, useState } from "react";


export default function PasswordForm() {
  const dispatch = useDispatch();
  const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$/
  const { errorMessage, message } = useSelector((store) => store.auth)
  const [isShow, setIsShow] =  useState(false)

  useEffect(() => {
    if(message.length > 0) {
      setIsShow(true)
    }   
  }, [message])

  setTimeout(() => {
    setTimeout(false)
  } , 2000)

  const changePasswordFormValid = async (values) => {
    const errors = {};

    if (!values.oldPassword) {
      errors.oldPassword = "Please enter current password !";
    } 

    if (!values.newPassword) {
      errors.newPassword = "Please enter new password !";
    }else if(!passwordRegex.test(values.newPassword)){
      errors.newPassword =  "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one digit, and one special character";
    }

    if (!values.confirmNewPassword) {
      errors.confirmNewPassword = "Please enter new password !";
    }else if(values.confirmNewPassword != values.confirmNewPassword) {
      errors.confirmNewPassword = "Confirm password do not match!";
    }

    return errors;
  };

  const handelSubmit = (values) => {
    dispatch(authActions.changePassword(values))
  }

  return (
    <div className="user-container">
       {
        isShow ? <div id="snackbar">{message}</div> : '' 
      }
      <div className="user-detail">
        <Formik
          initialValues={{
            oldPassword: "",
            newPassword: "",
            confirmNewPassword: ""
          }}
          validate={changePasswordFormValid}
          onSubmit={(values, actions) => {
            handelSubmit(values);

            actions.resetForm({
              values: {
                oldPassword: "",
                newPassword: "",
                confirmNewPassword: ""
              }
            });
          }}
        >
          {({handleSubmit, handleChange }) => (
            <Form
            onSubmit={handleSubmit}
            >
              <div className="profile-form">
                {/* right-pane */}
                <div className="form--input-wrapper">
                  <h2 className="mb-4">Change Password</h2>
                  {/* block - 1 */}
                  <div className="input-block">
                    <div className="input-block--element">
                      <label htmlFor="">Current Password</label>
                      <div>
                        <Form.Control
                          form-control
                          type="password"
                          name="oldPassword"
                          onChange={handleChange}
                          placeholder="Enter your current password"
                        />
                      </div>
                      {<div className="text-danger ">{errorMessage}</div>}
                      <ErrorMessage name="oldPassword">
                        {(message) => (<div className="text-danger ">{message}</div>)}
                      </ErrorMessage>
                    </div>
                  </div>
                  {/* block - 1 */}
                  <div className="input-block">
                    <div className="input-block--element">
                      <label htmlFor="">New Password</label>
                      <div>
                        <Form.Control
                          form-control
                          type="password"
                          name="newPassword"
                          onChange={handleChange}
                          placeholder="Enter your new password"
                        />
                      </div>
                      <ErrorMessage name="newPassword">
                        {(message) => (<div className="text-danger ">{message}</div>)}
                      </ErrorMessage>
                    </div>
                  </div>
                  {/* block - 3 */}
                  <div className="input-block">
                    <div className="input-block--element">
                      <label htmlFor="">Confirm Password</label>
                      <div>
                        <Form.Control
                          form-control
                          type="password"
                          name="confirmNewPassword"
                          onChange={handleChange}
                          placeholder="Enter your confirm password"
                        />
                      </div>
                      <ErrorMessage name="confirmNewPassword">
                        {(message) => (<div className="text-danger ">{message}</div>)}
                      </ErrorMessage>
                    </div>
                  </div>
                  <div className="btn-wrapper">
                    <button type="submit" className="save-btn">Save</button>
                  </div>
                </div>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
