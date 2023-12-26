import React, { useEffect, useState } from "react";
import { Button, Container } from "react-bootstrap";
import ReactPlayer from "react-player";
import MyModal from "../elements/MyModal";
import { BsChatTextFill } from "react-icons/bs";
import Error from "../elements/Error";
import MyOffCanvas from "../elements/MyOffCanvas";
import QuizForm from "./QuizForm";

export default function LessonDetails({ lesson }) {
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

  useEffect(() => {
    const interval = setInterval(() => {
      if (isPlaying) {
        setPlayTime((prevPlayTime) => prevPlayTime + 1);
      }
    }, 1000);

    return () => clearInterval(interval);
  }, [isPlaying]);

  return (
    <>
      <ReactPlayer
        url={lesson.link}
        width="100%"
        height="670px"
        playing={isPlaying}
        controls={true}
        onProgress={handleProgress}
        onPlay={handlePlay}
        onPause={handlePause}
      />

      <Container className="d-flex justify-content-between p-3 gap-3">
        <MyModal
          buttonText={`Part ${lesson.id} Quiz`}
          modalTitle={`Part ${lesson.id} Quiz`}
          modalBodyComponent={<QuizForm />}
          buttonVariant="warning"
        />
        <div className="d-flex gap-3">
          <MyModal
            buttonText={`Take note at ${formatTime(playTime)}`}
            modalTitle="Your Notes"
            modalBodyComponent={<Error />}
            buttonVariant="outline-dark"
          />

          <MyOffCanvas
            buttonIcon={<BsChatTextFill />}
            buttonText="Mentor Support"
            offCanvasTitle="Mentor Support"
            offCanvasBodyComponent={<p>OffCanvas Content Goes Here</p>}
            buttonVariant="info text-light d-flex align-items-center gap-2"
            placement="end"
          />
        </div>
      </Container>
    </>
  );
}
