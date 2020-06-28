import React, { useState } from 'react'
import * as yup from 'yup'
import { constants } from '../../../util/constants'
import PasswordHelper from '../../../util/PasswordHelper'
import { Formik, Field, Form, ErrorMessage } from 'formik'

const validationSchema = yup.object().shape({
    firstName       : yup.string().min(3, 'Must be 3 characters').required('Please input your first name'),
    lastName        : yup.string().min(3, 'Must be 3 characters').required('Please input your first name'),
    emailAddress    : yup.string().matches(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, "Not a valid format").min(5, 'Must be 5 characters or more').max(40, 'Must be 40 character or less').required('Invalid Email Address'),
    password        : yup.string().matches(
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/,
        "Please upgrade to strong password").required('Please enter your password'),
    confirmPassword : yup.string().required('Please confirm your password').test('passwords-match', 'Password must match', function(value) { return this.parent.password === value; }),
    agreeToTerms: yup.boolean().label('Terms').test('is-true','Must agree to terms to continue',value => value === true)
})

const Register = () => {
    const [count, setCount] = useState(0),
        countAndUpdatePopper = () => {
        setCount(count + 1);
    };
    return (
        <React.Fragment>
            <Formik
                initialValues = {{
                    firstName : '',
                    lastName : '',
                    emailAddress : '',
                    password : '',
                    confirmPassword : '',
                    agreeToTerms : ''
                }}
                validationSchema = {validationSchema}
                onSubmit = { fields => {
                    alert('Register Successful')
                }}
                render = { ({ errors, status, touched }) => (
                    <Form>
                        <div class="form-group">
                            <Field
                                name = "firstName"
                                autoComplete = "true"
                                type = "text"
                                placeholder = "Enter your first name"
                                className = {'form-field' + (errors.firstName && touched.firstName ? ' erorr' : '')}
                            />
                            <ErrorMessage
                                name = "firstName"
                                component = "div"
                                className = "error"
                            />
                        </div>
                        <div class="form-group">
                            <Field
                                name = "lastName"
                                autoComplete = "true"
                                type = "text"
                                placeholder = "Enter your last name"
                                className = {'form-field' + (errors.lastName && touched.lastName ? ' erorr' : '')}
                            />
                            <ErrorMessage
                                name = "lastName"
                                component = "div"
                                className = "error"
                            />
                        </div>
                        <div class="form-group">
                            <Field
                                name = "emailAddress"
                                autoComplete = "true"
                                type = "text"
                                placeholder = "Enter your email address"
                                className = {'form-field' + (errors.emailAddress && touched.emailAddress ? ' erorr' : '')}
                            />
                            <ErrorMessage
                                name = "emailAddress"
                                component = "div"
                                className = "error"
                            />
                        </div>
                        <div class="form-group">
                            <Field
                                name = "password"
                                autoComplete = "true"
                                type = "password"
                                onClick={countAndUpdatePopper}
                                placeholder = "Enter your password"
                                className = {'form-field' + (errors.password && touched.password ? ' erorr' : '')}
                            />
                            <ErrorMessage
                                name = "password"
                                component = "div"
                                className = "error"
                            />
                        </div>
                        <div class="form-group">
                            <Field
                                name = "confirmPassword"
                                autoComplete = "true"
                                type = "password"
                                placeholder = "Confirm your password"
                                className = {'form-field' + (errors.confirmPassword && touched.confirmPassword ? ' erorr' : '')}
                            />
                            <ErrorMessage
                                name = "confirmPassword"
                                component = "div"
                                className = "error"
                            />
                        </div>
                        {
                        (count >= 1) && <PasswordHelper count = {count}/>
                        }
                        <div className="form-group">
                                <button
                                    type="submit"
                                    className="btn btn-primary mr-2"
                                >{constants.registerHeading}</button>
                            </div>
                    </Form>
                )}

            >



            </Formik>

        </React.Fragment>
    )
}

export default Register