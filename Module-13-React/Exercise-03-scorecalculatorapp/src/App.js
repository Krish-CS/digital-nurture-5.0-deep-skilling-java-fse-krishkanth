import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        Name="Krishkanth" 
        School="KV" 
        Total={284} 
        goal={300} 
      />
    </div>
  );
}

export default App;
