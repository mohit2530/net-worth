import React from 'react'
import LogInForm from './LoginForm'
import '../../../util/Landing.scss'
import { Link } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import {constants} from '../../../util/constants'
import Typography from '@material-ui/core/Typography'

const Login = (props) => {
    const handleClick = (location) => {
        console.log("Should render " + location  + " documents");
    };

    return (
        <React.Fragment>
            <Grid container className = "center-container">
                <Grid item>
                    <div className="center-div-login">
                        <Typography
                            variant="h4"
                            color = "primary"
                            className = "padding-top"
                            >
                            {constants.loginHeading}
                        </Typography>
                        <LogInForm/>
                        <div>
                            <Typography
                                variant = "body1"
                                color = "primary"
                                >
                                {constants.registerForLogin}
                                <Link href = "#" onClick = {(event) => {props.onClick() }} >
                                    {constants.registerHeading}
                                </Link>
                            </Typography>
                        </div>
                        <div className="bottom-login-container">
                            <Typography
                                variant = "body1"
                                color = "primary"
                                >
                                <Link href = "#" onClick = {handleClick("termsConditions")} >
                                    {constants.termsConditions}
                                </Link>
                            </Typography>

                            <Typography
                                variant = "body1"
                                color = "primary"
                                >
                                <Link href = "#" onClick = {handleClick("privacyPolicy")} >
                                    {constants.privacyPolicy}
                                </Link>
                            </Typography>
                        </div>
                    </div>
                </Grid>
            </Grid>
        </React.Fragment>
    );
}

export default Login;