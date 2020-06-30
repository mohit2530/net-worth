import React from 'react'
import '../../util/home.scss'
import Sidebar from './Sidebar'
import auth from '../../auth/auth'
import { useHistory } from 'react-router-dom'
import { Grid, Paper } from '@material-ui/core'
import { constants } from '../../util/constants'
import Typography from '@material-ui/core/Typography'

const Home = (props) => {
    const route = constants.homeUrl,
        history = useHistory();

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
                            <button className = "button" onClick={() => {
                                auth.logout(() => { history.push(route) })
                            }}
                            >
                                {constants.logout}
                            </button>
                        </div>
                    </Paper>
                </Grid>
                    <Sidebar />
            </Grid>
        </>
    )
}

export default Home;
