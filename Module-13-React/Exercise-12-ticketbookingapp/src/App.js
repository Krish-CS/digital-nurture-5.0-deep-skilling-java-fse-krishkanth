import React, { useState } from 'react';

const GuestPage = () => {
    return (
        <div>
            <h3>Guest View</h3>
            <p>Welcome! Here are the flight details: Flight 101 to Paris, Flight 202 to New York.</p>
            <p><i>Please log in to book tickets.</i></p>
        </div>
    );
};

const UserPage = () => {
    return (
        <div>
            <h3>User View</h3>
            <p>Welcome User! Here are the flight details: Flight 101 to Paris, Flight 202 to New York.</p>
            <button style={{ backgroundColor: 'green', color: 'white', padding: '10px' }}>Book Tickets Now</button>
        </div>
    );
};

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h2>Flight Ticket Booking Portal</h2>
      
      {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)}>Logout</button>
      ) : (
          <button onClick={() => setIsLoggedIn(true)}>Login</button>
      )}

      <hr />
      
      {isLoggedIn ? <UserPage /> : <GuestPage />}
      
    </div>
  );
}

export default App;
