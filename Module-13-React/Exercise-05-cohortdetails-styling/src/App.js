import React from 'react';
import CohortDetails from './Components/CohortDetails';

function App() {
  return (
    <div className="App">
      <h2>Cohort Details</h2>
      <CohortDetails cohortCode="CWE_Java_2026" startDate="01-Jan-2026" status="ongoing" />
      <CohortDetails cohortCode="CWE_Python_2025" startDate="15-Mar-2025" status="completed" />
    </div>
  );
}

export default App;
