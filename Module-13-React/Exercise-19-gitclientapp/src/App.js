import React, { useState, useEffect } from 'react';
import GitClient from './Components/GitClient';

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
      const client = new GitClient();
      client.getRepositories('techiesyed')
        .then(data => setRepos(data))
        .catch(err => console.error(err));
  }, []);

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h2>GitHub Repositories for techiesyed</h2>
      <ul>
          {repos.map((repo, idx) => (
              <li key={idx}>{repo.name}</li>
          ))}
      </ul>
    </div>
  );
}

export default App;
