// src/components/UserPage.js
import React from 'react';

const UserPage = () => {
  return (
    <div>
      <h2>👤 Welcome User!</h2>
      <p>You can now book your tickets.</p>

      <h3>Available Flights</h3>
      <ul>
        <li>
          Air India - Delhi to Mumbai - 10:00 AM
          <button style={{ marginLeft: '10px' }}>Book Now</button>
        </li>
        <li>
          Indigo - Bangalore to Chennai - 1:30 PM
          <button style={{ marginLeft: '10px' }}>Book Now</button>
        </li>
        <li>
          Vistara - Hyderabad to Pune - 4:00 PM
          <button style={{ marginLeft: '10px' }}>Book Now</button>
        </li>
      </ul>
    </div>
  );
};

export default UserPage;
