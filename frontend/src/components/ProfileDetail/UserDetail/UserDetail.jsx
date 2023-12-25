import React, { ChangeEvent, useEffect, useRef, useState } from "react";
import "../profile-detail.css";
import { Field, useFormik } from "formik";
import { Form } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { studentActions } from "@store/studentSlice";
import axios from "axios";

// https://blog.logrocket.com/using-filereader-api-preview-images-react/
// https://jasonwatmore.com/post/2021/08/24/axios-http-put-request-examples
export default function UserDetail() {
  const [avatar, setAvatar] = useState(
    "https://th.bing.com/th/id/R.d44ee515740c6442102f8f06ff4049b9?rik=LHx11kIUGZMrFQ&pid=ImgRaw&r=0"
  );

 


  // Store
  const dispatch = useDispatch();
  const { userInfo } = useSelector((store) => store.students);

  const [user, setUser] = useState(userInfo)


  const formik = useFormik({
    initialValues: {
      firstName: user.firstName,
      lastName: user.lastName,  
      address: user.address,
      phoneNumber: user.phoneNumber,
      birthDay: user.birthDay,
      gender: user.gender ? 'men' : 'women',
      fileAvatar: null,
    },
    onSubmit: async (values) => {
      let formData = new FormData();
      formData.append("firstName", values.firstName);
      formData.append("lastName", values.lastName);
      formData.append("address", values.address);
      formData.append("phoneNumber", values.phoneNumber);
      formData.append("birthDay", values.birthDay);
      formData.append("gender", values.gender);
      formData.append("fileAvatar", values.fileAvatar);

      dispatch(studentActions.editStudentProfile(formData))
    },
  });

  console.log("formik",formik.values);

  // Handle File
  const handleAvatar = (e) => {
    const { files } = e.target;
    changeAvatar(files[0]);
  };

  const changeAvatar = (file) => {
    const fileReader = new FileReader();

    fileReader.onloadend = (e) => {
      const { result } = e.target;
      setAvatar(result);
    };

    fileReader.readAsDataURL(file);
  };

  useEffect(() => {
    if (userInfo.image != null) {
      setAvatar(userInfo.image);
    }
  }, [userInfo.image]);

  return (
    <div className="user-detail">
      <h1>Profile</h1>
      <form onSubmit={formik.handleSubmit} encType="multipart/form-data">
        <div className="profile-form">
          {/* Left-pane */}
          <div className="avatar">
            <h4>Avatar</h4>
            <img className="avatar-img" src={avatar} alt="avatar" />

            <label className="file-btn" htmlFor="file">
              Choose File
              <input 
                name="fileAvatar"
                onChange={(e) => {
                  formik.setFieldValue("fileAvatar", e.target.files[0]),
                  handleAvatar(e)
                }}
                type="file"
                id="file"
                accept="image/*"
                hidden
              />
            </label>
          </div>
          {/* right-pane */}
          <div className="form--input-wrapper">
            {/* block - 1 */}
            <div className="input-block">
              <div className="input-block--element">
                <label htmlFor="">
                  <span className="text-danger">*</span> First name
                </label>
                <div>
                  <Form.Control
                    value={formik.values.firstName}
                    onChange={formik.handleChange}
                    form-control
                    type="text"
                    name="firstName"
                    placeholder="Enter your full name"
                  />
                </div>
              </div>
              <div className="input-block--element">
                <label htmlFor="">
                  <span className="text-danger">*</span> Last name
                </label>
                <div>
                  <Form.Control
                    value={formik.values.lastName}
                    onChange={formik.handleChange}
                    type="text"
                    name="lastName"
                    placeholder="Enter your last name"
                  />
                </div>
                {/* <ErrorMessage name="lastName">
                        {(message) => (<div className="text-danger ">{message}</div>)}
                      </ErrorMessage> */}
              </div>
            </div>
            {/* block - 1 */}
            <div className="input-block">
              <div className="input-block--element">
                <label htmlFor="">Address</label>
                <div>
                  <Form.Control
                    value={formik.values.address}
                    onChange={formik.handleChange}
                    form-control
                    type="text"
                    name="address"
                    placeholder="Enter your address"
                  />
                </div>
              </div>
              <div className="input-block--element">
                <label htmlFor="">Phone number</label>
                <div>
                  <Form.Control
                    value={formik.values.phoneNumber}
                    onChange={formik.handleChange}
                    type="text"
                    name="phoneNumber"
                    placeholder="Enter your phone number"
                  />
                </div>
              </div>
            </div>
            {/* block - 3 */}
            <div className="input-block">
              <div className="input-block--element">
                <label htmlFor="">Birth day</label>
                <div>
                  <Form.Control
                    value={formik.values.birthDay}
                    onChange={formik.handleChange}
                    form-control
                    type="date"
                    name="birthDay"
                    placeholder="Enter your birth day"
                  />
                </div>
              </div>
              <div className="input-block--element">
                <label htmlFor="">Giới tính</label>
                <div className="gender-inpt" role="gender">
                  <div className="gender">
                    <input
                      id="men"
                      className="radio-input"
                      type="radio"
                      name="gender"
                      value="men"
                      onChange={formik.handleChange}
                      checked={formik.values.gender === "men" ? true : false}
                    />
                    <label htmlFor="" className="d-flex align-item-center">
                      {" "}
                      Men
                    </label>
                  </div>
                  <div className="gender">
                    <input
                      id="women"
                      className="radio-input"
                      type="radio"
                      name="gender"
                      value="women"
                      onChange={formik.handleChange}
                      checked={formik.values.gender === "women" ? true : false}
                    />
                    <label htmlFor="women" className="d-flex align-item-center">
                      {" "}
                      Women
                    </label>
                  </div>
                </div>
              </div>
            </div>
            <div className="btn-wrapper">
              <button type="submit" className="save-btn">
                Save
              </button>
            </div>
          </div>
        </div>
      </form>
    </div>
  );
}
