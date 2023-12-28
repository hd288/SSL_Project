import React, { useState, useEffect } from "react";
import { Accordion, Button, Col, Container, Row } from "react-bootstrap";
import LessonDetails from './LessonDetails'
import { useSelector } from "react-redux";

export default function Lesson() {
  const [playTime, setPlayTime] = useState(0);
  const [isPlaying, setIsPlaying] = useState(false);
  const {course}  = useSelector((store) => store.course)

  const [lessonList, setLessonList] = useState([])
  const [lesson, setLesson] = useState({})
  const [selectedLesson, setSelectedLesson] = useState(1);  

  useEffect(() => {
    setLessonList(course.lessons),
    setLesson(course.lessons[0])
    setSelectedLesson(course.lessons[0].lessonId)
  }, [])

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

  
  const handleLessonClick = (lessonId) => {
    setLesson(lessonList.find(lesson => lesson.lessonId == lessonId));
  };
  
  return (
    <div>
      <Row>
        <Col lg={9}>
          {selectedLesson && (
            <LessonDetails lesson={lesson}/>
          )}
        </Col>
        <Col lg={3}>
          <Accordion flush>
            {lessonList.map((lesson, index) => (
              <Accordion.Item
                key={lesson.lessonId}
                eventKey={lesson.lessonId}
                className={selectedLesson == lesson.lessonId ? 'selected' : ''}
              >
                <Accordion.Header>{lesson.lessonTitle}</Accordion.Header>
                <Accordion.Body>
                  <Button variant="link" onClick={() => handleLessonClick(lesson.lessonId)}>
                    Part {index + 1}
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
