import React, { useState } from 'react';

const BookDetails = () => <div><h4>Book Details: "React for Beginners" by John Doe</h4></div>;
const BlogDetails = () => <div><h4>Blog Details: 5 Tips for Better React Code</h4></div>;
const CourseDetails = () => <div><h4>Course Details: Full-Stack React Engineering</h4></div>;

function App() {
  const [view, setView] = useState('book');

  // Way 1: Switch Statement
  const renderViewSwitch = () => {
      switch(view) {
          case 'book': return <BookDetails />;
          case 'blog': return <BlogDetails />;
          case 'course': return <CourseDetails />;
          default: return null;
      }
  };

  return (
    <div style={{ padding: '20px' }}>
      <h2>Blogger App (Conditional Rendering)</h2>
      
      <div>
          <button onClick={() => setView('book')}>Books</button>
          <button onClick={() => setView('blog')}>Blogs</button>
          <button onClick={() => setView('course')}>Courses</button>
      </div>

      <hr />

      {/* Way 1: Using a function with switch statement */}
      <div style={{ border: '1px solid black', padding: '10px', margin: '10px 0' }}>
          <h3>Method 1: Switch Statement</h3>
          {renderViewSwitch()}
      </div>

      {/* Way 2: Ternary Operator */}
      <div style={{ border: '1px solid black', padding: '10px', margin: '10px 0' }}>
          <h3>Method 2: Ternary Operator</h3>
          {view === 'book' ? <BookDetails /> : (view === 'blog' ? <BlogDetails /> : <CourseDetails />)}
      </div>

      {/* Way 3: Logical && Operator */}
      <div style={{ border: '1px solid black', padding: '10px', margin: '10px 0' }}>
          <h3>Method 3: Logical &&</h3>
          {view === 'book' && <BookDetails />}
          {view === 'blog' && <BlogDetails />}
          {view === 'course' && <CourseDetails />}
      </div>

    </div>
  );
}

export default App;
