// src/components/GuestPage.js
import React from 'react';

const GuestPage = () => {
  return (
    <div>
      <h2>✈️ Welcome Guest!</h2>
      <p>Please log in to book tickets.</p>

      <h3>Available Flights</h3>
      <ul>
        <li>Flight: Air India - Delhi to Mumbai - 10:00 AM</li>
        <li>Flight: Indigo - Bangalore to Chennai - 1:30 PM</li>
        <li>Flight: Vistara - Hyderabad to Pune - 4:00 PM</li>
      </ul>
    </div>
  );
};

export default GuestPage;
