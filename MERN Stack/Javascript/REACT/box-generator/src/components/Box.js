import React from 'react'

const Box =(props) => {
    const {box} = props;
    return (
        <div style= {{background:box, background, width:`${box.width}px`, height:`${box.height}px`}}></div>
    );
};

export default Box;