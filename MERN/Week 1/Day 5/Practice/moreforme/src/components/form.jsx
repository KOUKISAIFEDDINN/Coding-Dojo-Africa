import React, { useState } from "react";

function MemberInfo() {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const validText = (text) => {
        return text.length < 2;
    };
    const validEmail = () => {
        return email.length < 5;
    };
    const validPassword = () => {
        return password.length < 8;
    };
    return (
        <div className="container">
            <form className="info1">

                <label htmlFor="firstName">First Name</label>
                <input type="text" onChange={(e) => setFirstName(e.target.value)} value={firstName} />
                {validText(firstName) && (<p>First Name must be 2 characters</p>)}

                <label htmlFor="lastName">Last Name</label>
                <input type="text" onChange={(e) => setLastName(e.target.value)} value={lastName} />
                {validText(lastName) && (<p className="text-danger">Last Name must be 2 characters</p>)}

                <label htmlFor="email">Email</label>
                <input type="email" onChange={(e) => setEmail(e.target.value)} value={email} />
                {validEmail() && <p className="text-danger">Email must be 5 characters</p>}

                <label htmlFor="password">Password</label>
                <input type="password" onChange={(e) => setPassword(e.target.value)} value={password} />
                {validPassword() && <p className="text-danger">Password must be 8 characters</p>}

            </form>
            <div className="info">
                <p>First Name: {firstName}</p>
                <p>Last Name: {lastName}</p>
                <p>Email: {email}</p>
                <p>Password: {password}</p>
            </div>
        </div>
    );
}
export default MemberInfo;
