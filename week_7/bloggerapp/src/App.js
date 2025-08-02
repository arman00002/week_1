// src/App.js
import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import './App.css';

function App() {
  const [view, setView] = useState("book");

  // Render method: if-else block
  let componentToRender;
  if (view === "book") {
    componentToRender = <BookDetails />;
  } else if (view === "blog") {
    componentToRender = <BlogDetails />;
  } else {
    componentToRender = <CourseDetails />;
  }

  return (
    <div className="App">
      <h1>📖 Blogger App</h1>
      
      <div className="button-group">
        <button onClick={() => setView("book")}>Show Book</button>
        <button onClick={() => setView("blog")}>Show Blog</button>
        <button onClick={() => setView("course")}>Show Course</button>
      </div>

      <hr />

      {/* Method 1: If-Else assigned before JSX */}
      {componentToRender}

      {/* Method 2: Ternary Operator */}
      {/* {view === "book" ? <BookDetails /> : <BlogDetails />} */}

      {/* Method 3: Short-circuit rendering */}
      {/* {view === "course" && <CourseDetails />} */}
    </div>
  );
}

export default App;
