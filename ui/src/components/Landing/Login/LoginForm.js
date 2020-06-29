import React from 'react'
import * as yup from 'yup'
import '../../../util/Landing.scss'
import auth from '../../../auth/auth'
import {useHistory} from 'react-router-dom'
import { constants } from '../../../util/constants'
import { Formik, Field, Form, ErrorMessage } from 'formik'

const validationSchema = yup.object().shape({
    emailAddress: yup.string().matches(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, "Not a valid format").min(5, 'Must be 5 characters or more').max(40, 'Must be 40 character or less').required('Please input your valid email address'),
    password: yup.string().matches(
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/,
        "Please upgrade to strong password"
    ).required('Please enter your password')
});

const LogInForm = (props) => {
    const routePath = constants.homeUrl,
        history = useHistory(),
        handleAuth = () => {
            auth.login( () => {history.push(routePath)})
        };

    return (
        <Formik
            initialValues={{
                emailAddress: '',
                password: ''
            }}
            validationSchema={validationSchema}
            onSubmit={fields => {
                handleAuth();
            }}
            render={({ errors, touched }) => (
                <Form>
                    <div className="form-group">
                        <Field
                            name="emailAddress"
                            autoComplete="true"
                            type="text"
                            placeholder="Enter your Email Address"
                            className={'form-field' + (errors.emailAddress && touched.emailAddress ? ' erorr' : '')}
                        />
                        <ErrorMessage
                            name="emailAddress"
                            component="div"
                            className="error"
                        />
                    </div>
                    <div className="form-group">
                        <Field
                            name="password"
                            autoComplete="true"
                            type="password"
                            placeholder="Enter your Password"
                            className={'form-field' + (errors.password && touched.password ? ' error' : '')} />
                        <ErrorMessage name="password" component="div" className="error" />
                    </div>
                    <div className="form-group">
                        <button
                            type="submit"
                        >
                            {constants.login}
                        </button>
                    </div>
                </Form>
            )}
        />
    )
}

export default LogInForm