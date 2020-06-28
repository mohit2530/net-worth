import React from 'react'
import auth from '../../auth/auth'

const Home = (props) => {
    return (
        <div>
            <h1> Home </h1>
            <button onClick={() => { auth.logout(() => { props.history.push("/") }) }}> Log out</button>
        </div>
    )
}

export default Home;
