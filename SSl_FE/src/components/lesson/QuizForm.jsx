import React, { useState } from "react";
import { Form, Col, Row, Button, Image } from "react-bootstrap";

export default function QuizForm({ questions }) {
  const [selectedAnswers, setSelectedAnswers] = useState({});

  const handleAnswerChange = (questionId, selectedOption) => {
    setSelectedAnswers((prevAnswers) => ({
      ...prevAnswers,
      [questionId]: selectedOption,
    }));
  };

  return (
    <Form className="px-5">
      {/* {questions.map((question) => (
        <Form.Group as={Row} key={question.id}>
          <Form.Label column sm={2}>
            {question.prompt}
          </Form.Label>
          <Col sm={10}>
            {question.choices.map((choice) => (
              <Form.Check
                key={choice.id}
                type="radio"
                id={`${question.id}-${choice.id}`}
                label={choice.text}
                checked={selectedAnswers[question.id] === choice.id}
                onChange={() => handleAnswerChange(question.id, choice.id)}
              />
            ))}
          </Col>
        </Form.Group>
      ))} */}

      <div className=" overflow-auto" style={{maxHeight:"650px"}}>
      <Form.Group as={Row} className="p-3 border-bottom">
        <Form.Label className="fw-bold fs-4">
          Lorem ipsum dolor sit amet?
        </Form.Label>
        <div className="d-flex justify-content-center">
        <Image src="https://tuyendung.kfcvietnam.com.vn/Data/Sites/1/media/blog/java-la-gi.jpg" className="w-50 object-fit-contain align-self-center"/>

        </div>
        <Form.Check type="radio" label=" 1. Lorem ipsum dolor sit amet" />
        <Form.Check type="radio" label=" 2. Lorem ipsum dolor sit amet" />
        <Form.Check type="radio" label=" 3. Lorem ipsum dolor sit amet" />
        <Form.Check type="radio" label=" 4. Lorem ipsum dolor sit amet" />
      </Form.Group>
      <Form.Group as={Row} className="py-2 border-bottom">
        <Form.Label className="fw-bold fs-4">
          Lorem ipsum dolor sit amet?
        </Form.Label>
        <div className="d-flex justify-content-center">
        <Image src="https://tuyendung.kfcvietnam.com.vn/Data/Sites/1/media/blog/java-la-gi.jpg" className="w-50 object-fit-contain align-self-center"/>

        </div>
        <Form.Check type="radio" label=" 1. Lorem ipsum dolor sit amet" />
        <Form.Check type="radio" label=" 2. Lorem ipsum dolor sit amet" />
        <Form.Check type="radio" label=" 3. Lorem ipsum dolor sit amet" />
        <Form.Check type="radio" label=" 4. Lorem ipsum dolor sit amet" />
      </Form.Group>
      </div>

      <div className=" d-flex justify-content-center gap-3 pt-3">
        <Button type="submit" variant="outline-primary">Submit</Button>
      </div>
    </Form>
  );
}
