import React from 'react';
import CohortDetails from './Components/CohortDetails';

function App() {
  const cohort = { cohortCode: 'CWE_Java_2026', startDate: '01-Jan-2026', status: 'ongoing' };
  return (
    <div className="App">
      <CohortDetails cohort={cohort} />
    </div>
  );
}

export default App;
