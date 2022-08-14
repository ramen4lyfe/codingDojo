import PersonCard from './components/PersonCard';
import './App.css';


function App() {
  return (
    <div className="App">
      
      {/* components use seld closing bracket and it can be use multiple times */}
      <PersonCard lastName={"Doe"} firstName={"Jane"} age={45} hairColor={"Black"}/>
      <PersonCard lastName={"Smith"} firstName={"John"} age={88} hairColor={"Brown"}/>
      <PersonCard lastName={"Fillmore"} firstName={"Millard"} age={50} hairColor={"Brown"}/>
      <PersonCard lastName={"Smith"} firstName={"Maria"} age={62} hairColor={"Brown"}/>
    </div>
  );
}

export default App;

