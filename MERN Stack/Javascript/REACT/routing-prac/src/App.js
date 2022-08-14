import React from 'react';
import Navbar from './Navbar';
import Pricing from "./pages/Pricing";
import Home from "./pages/Home";
import About from "./pages/About";
import { Route, Routes } from "react-router-dom";

function App() {


  return (
    <>
      <Navbar />
      <div className="conatainer">
        <Routes>
          <Route path="/" element={<Home />} />  
          <Route path="/Pricing" element={<Pricing />} />  
          <Route path="/About" element={<About />} />  
        </Routes>  
      </div>
    </>
  )
}

export default App;