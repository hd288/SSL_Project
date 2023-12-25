import React, { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import { useSelector } from "react-redux";


export default function MyModal({
  buttonText,
  modalTitle,
  modalBodyComponent,
  buttonVariant,
}) {
  
  const { isLogin, isRegister } = useSelector(store => store.auth)
  const [show, setShow] = useState(false);

  console.log(isRegister);

  const handleShow = () => setShow(true);
  const handleClose = () => setShow(false);
  
  useEffect(() => {
    if(isLogin || isRegister ) {
      setShow(false)
    }

  }, [isLogin, isRegister])

  return (
    <>
      <Button onClick={handleShow} variant={buttonVariant}>
        {buttonText}
      </Button>

      <Modal show={show} onHide={handleClose} size="xl">
        <Modal.Header closeButton>
          <Modal.Title >{modalTitle}</Modal.Title>
        </Modal.Header>
        <Modal.Body>{modalBodyComponent}</Modal.Body>
      </Modal>
    </>
  );
}
