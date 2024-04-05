import React, { useState } from "react";

function MemberInfo() {
    const [info, setInfo] = useState({
        firstName: "",
        lastName: "",
        email: "",
        password: "",

    })

    return (
        <div className="container">
            <form className="info1">

                <label for="firstName" >First Name</label>
                <input onChange={(e) => setInfo({ ...info, firstName: e.target.value })} />
                <label for="lastName" >Last Name</label>
                <input type="text" onChange={(e) => setInfo({ ...info, lastName: e.target.value })} />
                <label for="email" >Email</label>
                <input type="email" onChange={(e) => setInfo({ ...info, email: e.target.value })} />
                <label for="password" >Password</label>
                <input type="password" onChange={(e) => setInfo({ ...info, password: e.target.value })} />
            </form>
            <div className="info">
                <p>First Name: {info.firstName}</p>
                <p>Last Name: {info.lastName}</p>
                <p>Email: {info.email}</p>
                <p>Password: {info.password}</p>
            </div>
        </div>
    );
}
export default MemberInfo;