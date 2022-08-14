import React from "react";
import { useState } from "react";
import './App.css';
import Todo from "./components/Todo"

function App() {
  const [newTodo, setNewTodo] = useState("");

  const [todos, setTodos] = useState([]); 



  const handleNewTodoSubmit = (event) => {
    event.preventDefault();

    // prevent adding empty item
    if(newTodo.length === 0 ) {
      return;
    }

    // creating an object with name of newTodo and default to false for completion
    // doing this to make sure we can check off everysingle todo item by grouping its name and complete state in an object
    const todoItem = {
      text: newTodo,
      complete: false
    }

    setTodos([...todos, todoItem]);
    setNewTodo("");
  };

  const handleTodoDelete = (delIdx) => {
    const filteredTodos = todos.filter((todo, i) => {
      return i !== delIdx;
    });
    setTodos(filteredTodos);
  }

  const handleToggleComplete = (idx) => {
    const updatedTodo = todos.map((todo, i) => {
      if(idx === i) {
        todo.complete = !todo.complete;
      }
      
      return todo;
    })

    setTodos(updatedTodo);
  }
  
  return (
    <div className="App">
      <form onSubmit={(event) => { handleNewTodoSubmit(event); }}>
        <input onChange={(event) => { setNewTodo(event.target.value); }} type="text" value={newTodo}/>
        <div>
          <button>Add</button>
        </div>
      </form>
      <hr/>
      {/* need to conver the array of string into an array of JSX */}
      {
        todos.map((todo, i) => {
          return <Todo 
            key = {i} 
            i={i}
            todo ={todo}  
            handleToggleComplete={handleToggleComplete} 
            handleTodoDelete={handleTodoDelete}
            />;
          
        })
      }
    </div>
  );
}

export default App;
