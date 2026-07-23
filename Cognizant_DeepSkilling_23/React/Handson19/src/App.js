import React, { useEffect, useState } from "react";
import GitClient from "./GitClient";

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
    GitClient.getRepositories("techiesyed")
      .then(data => setRepos(data));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>GitHub Repository List</h1>

      <ul>
        {repos.map((repo, index) => (
          <li key={index}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;