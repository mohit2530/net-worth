import React from 'react'
import { constants } from './constants'
import Snackbar from '@material-ui/core/Snackbar'
import MuiAlert from '@material-ui/lab/Alert';

function Alert(props) {
  return <MuiAlert elevation={6} variant="filled" {...props} />;
}

const PasswordHelper = (props) => {

  const {count} = props,
    [open, setOpen] = React.useState(true),
    handleClose = (event, reason) => {
      if (reason === 'clickaway') {
        return;
      }
    setOpen(false);
  };
  return (
    <>
      <div>
        { (count > 1) &&
          <Snackbar
              anchorOrigin={{
                vertical: 'bottom', horizontal: 'center'
              }}
              open={open}
              autoHideDuration={6000}
              onClick= {handleClose}
            >
            <Alert severity="error">{constants.passwordReqs}</Alert>
            </Snackbar>
          }
      </div>
    </>
  );
}

export default PasswordHelper;