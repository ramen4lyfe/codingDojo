import React, {useReducer} from 'react';

const Form = (props) => {

    const createForm =(e) => {
        e.preventDefault();
    };

    const initialState = {
        firstName: {
            value: '',
            error: null
        },
        lastName: {
            value: '',
            error: null
        },
        email: {
            value: '',
            error: null
        }
    };

return (
    <form onSubmit={createForm}>
        <div>
            <label> First Name:</label>
            <input type="text" value={''} />
        </div>
        <div>
            <label> Last Name: </label>
            <input type="text" value={''}/>
        </div>
        <div>
            <label> Email: </label>
            <input type="text" value={''}/>
        </div>
        
        <input type="submit" value="Submit"/>
    </form>

);

}

export default Form;