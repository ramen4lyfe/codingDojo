import React, {useState} from 'react';

// Think of components as templates

// the file name is the component name
// props are parameters that get pass in by default
// jsx requierd one parent components
// component are grouping of personality into one piece of code
const PersonCard = (props) => {
    // this is how we instantiate useState 

    // const [getter, setter] = useState(initialValue or props.key)
    const [age, setAge] = useState(props.age);
    return (
        //insert jsx here 
        <div>
            <h2> {props.lastName}, {props.firstName}</h2>
            <p>Age: {age}</p>
            <p>Hair Color: {props.hairColor}</p>
            <button onClick={(event) => setAge(age + 1)}>Birthday for {props.firstName}</button>

        </div>
        
    )
}
// exporting allows this file to br found and use inseide other components

export default PersonCard;