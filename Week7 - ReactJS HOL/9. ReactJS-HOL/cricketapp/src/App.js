import React, { useState } from 'react';
import IndianPlayers from './Components/IndianPlayers';
import ListofPlayers from './Components/ListOfPlayers';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div style={{ textAlign: 'left' }}>
      <h1>Cricket App</h1>
      <button onClick={() => setFlag(!flag)}>
        Show {flag ? 'Indian Players' : 'List of Players'}
      </button>

      <hr />
      {flag ? <ListofPlayers/> : <IndianPlayers />}
    </div>
  );
}

export default App;