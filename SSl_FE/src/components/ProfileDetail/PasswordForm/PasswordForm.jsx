import "../profile-detail.css";
import { Field, Formik } from "formik";
import { Form } from "react-bootstrap";

export default function PasswordForm() {
  return (
    <div className="user-container">
      <div className="user-detail">
        <Formik
          initialValues={{
            email: "",
            password: "",
            // checkRemember: true,
          }}
          onSubmit={(values, { resetForm }) => {
            resetForm();
          }}
        >
          {({ handleChange }) => (
            <Form>
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
                          name="curPassword"
                          placeholder="Enter your current password"
                        />
                      </div>
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
                          placeholder="Enter your new password"
                        />
                      </div>
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
                          name="confPassword"
                          placeholder="Enter your confirm password"
                        />
                      </div>
                    </div>
                  </div>
                  <div className="btn-wrapper">
                    <button className="save-btn">Save</button>
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
