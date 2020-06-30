import React from 'react'
import '../../util/home.scss'
import Sidebar from './Sidebar'
import auth from '../../auth/auth'
import { useHistory } from 'react-router-dom'
import Avatar from '@material-ui/core/Avatar'
import { constants } from '../../util/constants'
import Typography from '@material-ui/core/Typography'
import { green, pink } from '@material-ui/core/colors'
import { Grid, Paper, makeStyles } from '@material-ui/core'
import ExitToAppOutlinedIcon from '@material-ui/icons/ExitToAppOutlined'

const useStyles = makeStyles( (theme) => ({
    small : {
        width: theme.spacing(4),
        height: theme.spacing(4),
        color: theme.palette.getContrastText(pink[500]),
        backgroundColor: pink[500]
    }
}));

const Home = (props) => {
    const route = constants.homeUrl,
        history = useHistory(),
        classes = useStyles();

    return (
        <>
            <Grid container spacing={2}>
                <Grid item xs={12}>
                    <Paper>
                        <div className = "top-navigation">
                            <Typography
                                variant="h4"
                                color = "primary"
                                className = "padding-top"
                                >
                                {constants.loginHeading}
                            </Typography>
                            <Avatar className = {classes.small} onClick={() => {
                                auth.logout(() => { history.push(route) })
                            }}>
                                <ExitToAppOutlinedIcon/>
                            </Avatar>
                        </div>
                    </Paper>
                </Grid>
                    <Sidebar />
            </Grid>
        </>
    )
}

export default Home;
