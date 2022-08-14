import React, { useState } from 'react';

const Form = (props) => {
    // write getters and setter for form fields
    const [firstName, setFirstName ] = useState(" ");
    const [lastName, setLastName ] = useState(" ");
    const [email, setEmail ] = useState(" ");
    const [password, setPassword ] = useState(" ");
    const [hasBeenSubmitted, setHasBeenSubmitted] = useState(false);  // default value of false
    
    // validation code
    const [firstNameError, setFirstNameError] = useState("");
    const [lastNameError, setLastNameError] = useState("");
    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");
   
    // e variable is for event
    const createForm = (e) =>{
        // prevent browser's default refresh. So we should always have this in our code
        e.preventDefault();

        // now we are building the object using ES6 shorthand
        const newUser = {firstName, lastName, email, password};
        console.log ("Welcome", newUser);
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        // updating state will change the message to be displayed in the form
        setHasBeenSubmitted( true );
    };

    const formMessage = () => {
        if (hasBeenSubmitted){
            return "Thank you! Form has been submitted.";
        }else {
            return "Welcome, please fill out the form";
        }
    };

    const validateFirstName = (e) => {
        setFirstName(e.target.value);
        if(e.target.value.length < 1) {
            setFirstNameError("First Name is required!");
        } else if( e.target.value.length < 3){
            setFirstNameError("First Name must be atleast 2 characters");
        } else {
            setFirstNameError("");
        }
    };

    const validateLastName = (e) => {
        setLastName(e.target.value);
        if(e.target.value.length < 1) {
            setLastNameError("Last Name is required!");
        } else if( e.target.value.length < 3){
            setLastNameError("Last Name must be atleast 2 characters");
        } else {
            setLastNameError("");
        }
    };

    const validateEmail = (e) => {
        setLastName(e.target.value);
        if(e.target.value.length < 1) {
            setEmailError("Email is required!");
        } else if( e.target.value.length < 3){
            setEmailError("Email must be valid");
        } else {
            setEmailError("");
        }
    };
    const validatePassword = (e) => {
        setPassword(e.target.value);
        if(e.target.value.length < 1) {
            setPasswordError("Password is required");
        } else if( e.target.value.length < 3){
            setPasswordError("Password must be atleast 8 characters");
        } else {
            setPasswordError("");
        }
    };

    return (
        <div>
            <form onSubmit={createForm}>
                <h2>{ formMessage() }</h2>
                <div>
                    <label> First Name: </label>
                    <input type="text" value={firstName} onChange={validateFirstName}/>
                    {
                        firstNameError ?
                        <p>{ firstNameError }</p> :
                        ''
                    }
                </div>
                <div>
                    <label> Last Name: </label>
                    <input type="text" value={lastName} onChange={ validateLastName }/>
                    {
                        lastNameError ?
                        <p>{ lastNameError }</p> :
                        ''
                    }
                </div>
                <div>
                    <label> Email: </label>
                    <input type="text" value={email} onChange={ validateEmail }/>
                    {
                        emailError ?
                        <p>{ emailError }</p> :
                        ''
                    }
                </div>
                <div>
                    <label> Password: </label>
                    <input type="text" value={password} onChange={ validatePassword}/>
                    {
                        passwordError ?
                        <p>{ passwordError }</p> :
                        ''
                    }
                </div>
                
                <input type="submit" value="Sumbit Form"/>
            </form>

           
        </div>
        
    );
}

export default Form;