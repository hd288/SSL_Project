import React, { useState, useEffect } from "react";
import { Accordion, Button, Col, Container, Row } from "react-bootstrap";
import ReactPlayer from "react-player";
import MyModal from "../elements/MyModal";
import Error from "../elements/Error";
import { BsPenFill, BsChatTextFill } from "react-icons/bs";
import MyOffCanvas from "../elements/MyOffCanvas";
import LessonDetails from "./LessonDetails";

export default function Lesson() {
  const [playTime, setPlayTime] = useState(0);
  const [isPlaying, setIsPlaying] = useState(false);

  const handleProgress = (state) => {
    if (isPlaying) {
      setPlayTime(state.playedSeconds);
    }
  };

  const handlePlay = () => {
    setIsPlaying(true);
  };

  const handlePause = () => {
    setIsPlaying(false);
  };

  const formatTime = (time) => {
    const date = new Date(time * 1000);
    const hour = date.getUTCHours();
    const minute = date.getUTCMinutes();
    const second = ("0" + date.getUTCSeconds()).slice(-2);
    if (hour) {
      return `${hour}:${("0" + minute).slice(-2)}:${second}`;
    }
    return `${minute}:${second}`;
  };

  // Use useEffect to start the interval when the component mounts
  useEffect(() => {
    const interval = setInterval(() => {
      // Update the displayed time only when the video is playing
      if (isPlaying) {
        setPlayTime((prevPlayTime) => prevPlayTime + 1);
      }
    }, 1000);

    // Clean up the interval when the component unmounts
    return () => clearInterval(interval);
  }, [isPlaying]);

  
  const lessonArray = [
    { id: 1, title: "How to HTML CSS", link: "https://www.youtube.com/watch?v=a55EVkWhWTc" },
    { id: 2, title: "Javascript in a nutshell", link: "https://www.youtube.com/watch?v=LkY75DvJnlk" },
  ];
  const [selectedLesson, setSelectedLesson] = useState(lessonArray[0].id);

  const handleLessonClick = (lesson) => {
    setSelectedLesson(selectedLesson === lesson.id ? null : lesson.id);
  };
  
  return (
    <div>
      <Row>
        <Col lg={9}>
          {selectedLesson && (
            <LessonDetails lesson={lessonArray.find((lesson) => lesson.id === selectedLesson)} />
          )}
        </Col>
        <Col lg={3}>
          <Accordion flush>
            {lessonArray.map((lesson) => (
              <Accordion.Item
                key={lesson.id}
                eventKey={lesson.id}
                className={selectedLesson === lesson.id ? 'selected' : ''}
              >
                <Accordion.Header>{lesson.title}</Accordion.Header>
                <Accordion.Body>
                  <Button variant="link" onClick={() => handleLessonClick(lesson)}>
                    Part {lesson.id}
                  </Button>
                  {/* {selectedLesson === lesson.id && <LessonDetails lesson={lesson} />} */}
                </Accordion.Body>
              </Accordion.Item>
            ))}
          </Accordion>
        </Col>
      </Row>
    </div>
  )}