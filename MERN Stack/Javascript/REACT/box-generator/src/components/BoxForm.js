import React from 'react';
import {useState} from 'react';

const BoxForm = (props) => {
    const {boxArray, setBoxArray} = props;
    const [box, setBox] = useState({ background:'#000', width: 0, height:0 });     // inline styling
    const handleSubmit =(e) => {
        e.preventDefault();
        setBoxArray([...boxArray,box]);
        setBox({background: '#000', width: 0, height:0});
    };
    const handleChange = (e) => {
        setBox({...box, [e.target.name]: e.target.value});
    }
    return(
        <form onSubmit={handleSubmit}>
            <div>
                <label> Color: </label>
                <input type="text" value={box.background} name="background" onChange={handleChange}/>
                <label> Width: </label>
                <input type="number" value={box.width} name="width" onChange={handleChange}/>
                <label> Height: </label>
                <input type="number" value={box.height} name="height" onChange={handleChange}/>
                <button>Add</button>
            </div>
        </form>
    );
};

    

export default BoxForm; 