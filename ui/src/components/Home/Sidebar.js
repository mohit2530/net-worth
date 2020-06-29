import React from 'react'
import FaceIcon from '@material-ui/icons/Face'
import InfoIcon from '@material-ui/icons/Info'
import {constants } from '../../util/constants'
import ShareOutlinedIcon from '@material-ui/icons/ShareOutlined'
import ToggleOffOutlinedIcon from '@material-ui/icons/ToggleOffOutlined'
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import MonetizationOnOutlinedIcon from '@material-ui/icons/MonetizationOnOutlined'
import EnhancedEncryptionOutlinedIcon from '@material-ui/icons/EnhancedEncryptionOutlined'
import { Drawer, makeStyles, List, ListItem, ListItemIcon, ListItemText } from '@material-ui/core'

const useStyles = makeStyles((theme) => ({
    drawerPaper: { width: 'inherit', marginTop: 'inherit' },
    link : {textDecoration : 'none', color: theme.palette.text.primary}
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
                </div>
            </Router>
        </>
    )
}

export default Sidebar
