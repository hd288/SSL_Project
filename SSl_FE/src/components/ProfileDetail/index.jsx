import React from 'react'
import './profile-detail.css'
import { Field, Formik } from 'formik'
import { Form } from 'react-bootstrap'
import UserDetail from './UserDetail/UserDetail'
import PasswordForm from './PasswordForm/PasswordForm'
import { Outlet } from 'react-router-dom'

export default function ProfileDetail() {
  return (
    <div className='user-container'>
        <Outlet />
    </div>
  )
}
