import React, { useState } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";


export default function MyModal({
  buttonIcon,
  buttonText,
  modalTitle,
  modalBodyComponent,
  buttonVariant,
  fullscreen,
}) {
  const [show, setShow] = useState(false);

  const handleShow = () => setShow(true);
  const handleClose = () => setShow(false);

  return (
    <>
      <Button onClick={handleShow} variant={buttonVariant}>
      {buttonIcon} {buttonText}
      </Button>

      <Modal show={show} fullscreen={fullscreen} onHide={handleClose} size="xl">
        <Modal.Header closeButton>
          <Modal.Title >{modalTitle}</Modal.Title>
        </Modal.Header>
        <Modal.Body>{modalBodyComponent}</Modal.Body>
      </Modal>
    </>
  );
}
