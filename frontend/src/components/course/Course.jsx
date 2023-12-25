import React, { useState } from "react";
import {
  Button,
  Col,
  Image,
  Row,
  Accordion,
  ListGroup,
  ListGroupItem,
} from "react-bootstrap";
import {
  BsCheck2Circle,
  BsRocketTakeoff,
  BsListTask,
  BsClockHistory,
} from "react-icons/bs";
import MyModal from "../elements/MyModal";
import Lesson from "../lesson/Lesson";
import MyOffCanvas from "../elements/MyOffCanvas";
import { useSelector } from "react-redux";

export default function Course() {
  // const [course, setCourse] = useState({})
  const {course}  = useSelector((store) => store.course)

  return (
    <div className="pt-5">
      <Row className="px-5 mx-5">
        <Col lg={9} className="d-flex justify-content-center">
          <div>
            <div>
              <h4 className="text-center">{course.courseTitle}</h4>
              <p>
                {course.courseDesc}
                {/* Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Praesentium id debitis iste perspiciatis obcaecati quo ducimus
                voluptas corporis assumenda dolores vero aliquid ad dolor,
                doloremque voluptate quia dolore est ab. Lorem ipsum dolor sit
                amet consectetur adipisicing elit. Praesentium id debitis iste
                perspiciatis obcaecati quo ducimus voluptas corporis assumenda
                dolores vero aliquid ad dolor, doloremque voluptate quia dolore
                est ab. Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Praesentium id debitis iste perspiciatis obcaecati quo ducimus
                voluptas corporis assumenda dolores vero aliquid ad dolor,
                doloremque voluptate quia dolore est ab. Lorem ipsum dolor sit
                amet consectetur adipisicing elit. Praesentium id debitis iste
                perspiciatis obcaecati quo ducimus voluptas corporis assumenda
                dolores vero aliquid ad dolor, doloremque voluptate quia dolore
                est ab. Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Praesentium id debitis iste perspiciatis obcaecati quo ducimus
                voluptas corporis assumenda dolores vero aliquid ad dolor,
                doloremque voluptate quia dolore est ab. */}
              </p>
            </div>

            <div>
              <h5 className="m-2">This Course's Details</h5>
              <p>
                20 {/* thay đổi số ở đây thôi  */}
                <span className="fw-lighter">
                  Lessons - Approximately
                </span> {course.duration}
                <span className="fw-lighter">hours</span>
              </p>
              <Accordion defaultActiveKey="1" alwaysOpen flush className="w-75">
                {/* item 1 */}
                <Accordion.Item eventKey="1">
                  <Accordion.Header>
                    1. Lorem ipsum dolor sit amet.
                  </Accordion.Header>
                  <Accordion.Body>
                    <ListGroup variant="flush">
                      <ListGroupItem>Cras justo odio</ListGroupItem>
                      <ListGroupItem>Dapibus ac facilisis in</ListGroupItem>
                      <ListGroupItem>Morbi leo risus</ListGroupItem>
                      <ListGroupItem>Porta ac consectetur ac</ListGroupItem>
                    </ListGroup>
                  </Accordion.Body>
                </Accordion.Item>
                {/* item 1 end */}
                {/* dùng map để render tất cả cái item thì chỉ cần nhớ add eventKey là được (eventKey = `${index}` là oke) */}

                <Accordion.Item eventKey="2">
                  <Accordion.Header>
                    2. Lorem ipsum dolor sit amet.
                  </Accordion.Header>
                  <Accordion.Body>
                    <ListGroup variant="flush">
                      <ListGroupItem>Cras justo odio</ListGroupItem>
                      <ListGroupItem>Dapibus ac facilisis in</ListGroupItem>
                      <ListGroupItem>Morbi leo risus</ListGroupItem>
                      <ListGroupItem>Porta ac consectetur ac</ListGroupItem>
                    </ListGroup>
                  </Accordion.Body>
                </Accordion.Item>
              </Accordion>
            </div>

            <div className="mt-5">
              <h5 className="m-2">
                <span className="bg-light text-secondary p-2">
                  What you need to prepare for this course
                </span>
              </h5>
              <ListGroup variant="flush" className="fw-lighter">
                <ListGroupItem className="d-flex align-items-center gap-2">
                  <BsCheck2Circle
                    className="text-danger"
                    style={{ minWidth: "15px" }}
                  />
                  Computer with internet connection (Windows, Ubuntu, or MacOS)
                </ListGroupItem>
                <ListGroupItem className="d-flex align-items-center gap-2">
                  <BsCheck2Circle
                    className="text-danger"
                    style={{ minWidth: "15px" }}
                  />
                  High self-learning awareness, strong sense of responsibility,
                  persistent and resilient in facing challenges
                </ListGroupItem>
                <ListGroupItem className="d-flex align-items-center gap-2">
                  <BsCheck2Circle
                    className="text-danger"
                    style={{ minWidth: "15px" }}
                  />
                  Avoid rushing, stay calm while studying, and practice
                  exercises after each lesson
                </ListGroupItem>
                <ListGroupItem className="d-flex align-items-center gap-2">
                  <BsCheck2Circle
                    className="text-danger"
                    style={{ minWidth: "15px" }}
                  />
                  If you have questions while studying, join the Q&A sessions on
                  the Facebook group: Web Development Learning
                </ListGroupItem>
                <ListGroupItem className="d-flex align-items-center gap-2">
                  <BsCheck2Circle
                    className="text-danger"
                    style={{ minWidth: "15px" }}
                  />
                  You don't need to know anything else; in the course, We will
                  guide you through what you need to know
                </ListGroupItem>
              </ListGroup>
            </div>
          </div>
        </Col>
        <Col
          lg={3}
          className="d-flex flex-column justify-content-start p-0 fw-light"
        >
          <Image
            className="w-100 rounded border"
            src={course.imageCourseUrl}
          />
          <h4 className="text-center text-warning  my-3">Price: 500$</h4>

          <ListGroup variant="flush" className="align-self-center w-75 ">
            <ListGroupItem className="d-flex align-items-center gap-2">
              <BsRocketTakeoff /> Level: Intermediate
            </ListGroupItem>
            <ListGroupItem className="d-flex align-items-center gap-2">
              <BsListTask /> Total Lessons: 10
            </ListGroupItem>
            <ListGroupItem className="d-flex align-items-center gap-2">
              <BsClockHistory />
              Duration: {course.duration} hours
            </ListGroupItem>
          </ListGroup>

          <MyModal
            buttonText="Start Learning"
            modalTitle={course.courseTitle}
            modalBodyComponent={<Lesson />}
            buttonVariant="warning  my-2 w-75 align-self-center"
            fullscreen={true}
          />

        </Col>
      </Row>
    </div>
  );
}
