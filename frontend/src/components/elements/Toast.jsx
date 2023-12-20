import React, { useEffect, useRef } from 'react';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const ToastComponent = ({ type, message }) => {
  const prevTypeRef = useRef();
  const prevMessageRef = useRef();

  useEffect(() => {
    // Check if type or message has changed
    if (type !== prevTypeRef.current || message !== prevMessageRef.current) {
      const showToast = () => {
        switch (type) {
          case 'success':
            toast.success(message || 'Success Message');
            break;
          case 'error':
            toast.error(message || 'Error Message');
            break;
          case 'warn':
            toast.warn(message || 'Warning Message');
            break;
          case 'info':
            toast.info(message || 'Information Message');
            break;
          case 'dark':
            toast.dark(message || 'Dark-themed Message');
            break;
          default:
            break;
        }
      };

      // Show the toast when type or message changes
      showToast();

      // Update the refs with the current values
      prevTypeRef.current = type;
      prevMessageRef.current = message;
    }
  }, [type, message]);

  return null;
};

export default ToastComponent;
