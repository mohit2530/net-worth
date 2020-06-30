import React from 'react'
import '../../util/home.scss'
import FaceIcon from '@material-ui/icons/Face'
import InfoIcon from '@material-ui/icons/Info'
import {constants } from '../../util/constants'
import { Paper } from '@material-ui/core'
import ShareOutlinedIcon from '@material-ui/icons/ShareOutlined'
import ToggleOffOutlinedIcon from '@material-ui/icons/ToggleOffOutlined'
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import MonetizationOnOutlinedIcon from '@material-ui/icons/MonetizationOnOutlined'
import EnhancedEncryptionOutlinedIcon from '@material-ui/icons/EnhancedEncryptionOutlined'
import { Drawer, makeStyles, List, ListItem, ListItemIcon, ListItemText, Container, Typography } from '@material-ui/core'

const useStyles = makeStyles((theme) => ({
    drawerPaper: { width: 'inherit', marginTop: 'inherit' },
    link : { textDecoration : 'none', color: theme.palette.text.primary},
    container : {marginLeft: '1vh'},
    paper : { margin: '10px', padding : '10px'}
}));

const Sidebar = () => {
    const classes = useStyles();
    return (
        <>
            <Router>
                <div className="drawer-main">
                    <Drawer
                        className="sidenav-drawer"
                        variant="persistent"
                        anchor="left"
                        open={true}
                        classes={{ paper: classes.drawerPaper }}
                        >
                        <List>
                            <Link to = {constants.homeUrl}
                                className = {classes.link}>
                                <ListItem button>
                                    <ListItemIcon>
                                        <FaceIcon />
                                    </ListItemIcon>
                                    <ListItemText primary= {constants.home}/>
                                </ListItem>
                            </Link>

                            <Link to = {constants.personalInfoUrl}
                                className = {classes.link}>
                                <ListItem button>
                                    <ListItemIcon>
                                        <InfoIcon />
                                    </ListItemIcon>
                                    <ListItemText primary= {constants.personalInfo}/>
                                </ListItem>
                            </Link>

                            <Link to = {constants.personalization}
                                className = {classes.link}>
                                <ListItem button>
                                    <ListItemIcon>
                                        <ToggleOffOutlinedIcon />
                                    </ListItemIcon>
                                    <ListItemText primary= {constants.personalizeAccount}/>
                                </ListItem>
                            </Link>

                            <Link to = {constants.security}
                                className = {classes.link}>
                                <ListItem button>
                                    <ListItemIcon>
                                        <EnhancedEncryptionOutlinedIcon />
                                    </ListItemIcon>
                                    <ListItemText primary= {constants.securityInfo}/>
                                </ListItem>
                            </Link>

                            <Link to = {constants.dataSharing}
                                className = {classes.link}>
                                <ListItem button>
                                    <ListItemIcon>
                                        <ShareOutlinedIcon />
                                    </ListItemIcon>
                                    <ListItemText primary= {constants.dataInfo}/>
                                </ListItem>
                            </Link>

                            <Link to = {constants.payments}
                                className = {classes.link}>
                                <ListItem button>
                                    <ListItemIcon>
                                        <MonetizationOnOutlinedIcon />
                                    </ListItemIcon>
                                    <ListItemText primary= {constants.paymentsInfo}/>
                                </ListItem>
                            </Link>
                        </List>
                    </Drawer>
                    <Switch>
                        <Route exact path = {constants.homeUrl}>
                            <Container maxWidth="lg" className = {classes.container} >
                                <Paper className = {classes.paper}>
                                    {constants.home}
                                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                </Paper>
                            </Container>
                        </Route>
                        <Route exact path = {constants.homeUrl}>
                            <Container maxWidth="lg" className = {classes.container} >
                                {constants.home}
                            </Container>
                        </Route>
                        <Route exact path = {constants.homeUrl}>
                            <Container maxWidth="lg" className = {classes.container} >
                                {constants.home}
                            </Container>
                        </Route>
                        <Route exact path = {constants.homeUrl}>
                            <Container maxWidth="lg" className = {classes.container} >
                                {constants.home}
                            </Container>
                        </Route>
                        <Route exact path = {constants.homeUrl}>
                            <Container maxWidth="lg" className = {classes.container} >
                                {constants.home}
                            </Container>
                        </Route>
                        <Route exact path = {constants.homeUrl}>
                            <Container maxWidth="lg" className = {classes.container} >
                                {constants.home}
                            </Container>
                        </Route>
                    </Switch>
                </div>
            </Router>
        </>
    )
}

export default Sidebar
