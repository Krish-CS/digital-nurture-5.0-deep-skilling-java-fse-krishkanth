import React, { useState } from 'react';
import ThemeContext from './Components/ThemeContext';
import EmployeeList from './Components/EmployeeList';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
      setTheme(prev => (prev === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h2>Theme Context App</h2>
        <button onClick={toggleTheme}>Toggle Theme (Current: {theme})</button>
        <hr />
        <EmployeeList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
