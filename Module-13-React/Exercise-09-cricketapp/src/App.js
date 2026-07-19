import React, { useState } from 'react';
import ListofPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div style={{ padding: '20px' }}>
      <h1>Cricket App</h1>
      <button onClick={() => setFlag(!flag)}>Toggle Flag ({flag ? 'true' : 'false'})</button>
      <hr />
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
