import React from 'react'
import '../../../util/Landing.scss'
import Grid from '@material-ui/core/Grid'
import RegisterForm from './RegisterForm'
import {constants} from '../../../util/constants'
import { Typography, Link } from '@material-ui/core'

const Register = (props) => {
    const preventDefaultAction = () => {
        console.log("Empty for now. ");
    }
    return (
        <React.Fragment>
            <Grid container className = "center-container-lg">
                <Grid item>
                    <div className = "center-div-login">
                        <Typography
                            variant="h4"
                            color ="primary"
                            className = "padding-top"
                            >
                            {constants.registerHeading}
                        </Typography>
                        <RegisterForm/>
                            <Typography
                                variant = "body1"
                                color = "primary"
                                >
                                {constants.LoginForRegister}
                                <Link href = "#" onClick = {(event) => {props.onClick() }} >
                                    {constants.login}
                                </Link>
                            </Typography>
                            <div className="bottom-login-container">
                            <Typography
                                variant = "body1"
                                color = "primary"
                                >
                                <Link href = "#" onClick = {preventDefaultAction} >
                                    {constants.termsConditions}
                                </Link>
                            </Typography>
                            <Typography
                                variant = "body1"
                                color = "primary"
                                >
                                <Link href = "#" onClick = {preventDefaultAction} >
                                    {constants.privacyPolicy}
                                </Link>
                            </Typography>
                        </div>
                    </div>
                </Grid>
            </Grid>
        </React.Fragment>
    )
}

export default Register;