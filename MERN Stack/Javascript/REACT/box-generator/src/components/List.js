import React from 'react'
import Box from './Box';

function List(props) {
    const {boxArray} = props
    return <div style={{display:'flex', flexwrap:'wrap', justifyContent:'space-around',margin:'40px 10px',}} >
         
         {/* looping through box array and return box item */}
         {boxArray.map((box,i) => (
            <Box key={i} box={box} />
         ))}
    </div>;
};

export default List;