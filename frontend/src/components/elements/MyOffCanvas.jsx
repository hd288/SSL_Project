import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';

export default function MyOffCanvas({
  buttonText,
  buttonIcon,
  offCanvasTitle,
  offCanvasBodyComponent,
  buttonVariant,
  placement,
}) {
  const [show, setShow] = useState(false);

  const handleShow = () => setShow(true);
  const handleClose = () => setShow(false);

  return (
    <>
      <Button onClick={handleShow} variant={buttonVariant}>
       {buttonIcon} {buttonText}
      </Button>

      <Offcanvas show={show} onHide={handleClose} placement={placement}>
        <Offcanvas.Header closeButton>
          <Offcanvas.Title>{offCanvasTitle}</Offcanvas.Title>
        </Offcanvas.Header>
        <Offcanvas.Body>{offCanvasBodyComponent}</Offcanvas.Body>
      </Offcanvas>
    </>
  );
}
