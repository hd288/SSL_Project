import React from 'react'
import './profile-detail.css'
import { Field, Formik } from 'formik'
import { Form } from 'react-bootstrap'
import UserDetail from './UserDetail/UserDetail'
import PasswordForm from './PasswordForm/PasswordForm'

export default function ProfileDetail() {
  return (
    <div className='user-container'>
        <UserDetail/>
        {/* <PasswordForm/> */}
    </div>
  )
}
