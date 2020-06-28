import Login from './Login/Login'
import React, { useState }  from 'react'
import Register from './Registration/Register'



export default function Landing() {
    const [isLogin, setIsLogin] = useState(true);
    return (
        <>
            {isLogin && <Login onClick = {() => {setIsLogin(!isLogin)}}/>}
            {!isLogin && <Register onClick = {() => {setIsLogin(true)}}/>}

        </>
    )
}