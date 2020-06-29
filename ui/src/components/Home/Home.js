import React from 'react'
import auth from '../../auth/auth'
import {useHistory} from 'react-router-dom'
import {constants} from '../../util/constants'

const Home = (props) => {
    const route = constants.homeUrl,
        history = useHistory();

    return (
        <div>
            <h1> Home </h1>
            <button onClick={ () => { 
                auth.logout( () => { history.push(route) }) }}
            >
                {constants.logout}
            </button>
        </div>
    )
}

export default Home;
