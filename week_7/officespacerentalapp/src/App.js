// src/App.js
import React from 'react';
import './App.css';

function App() {
  // Heading Element
  const heading = <h1>🏢 Office Space Rental Listings</h1>;

  // Image URL Attribute
  const officeImage = "https://images.unsplash.com/photo-1581090700227-1e8e9081a56e"; // Example image

  // Single Office Object
  const office = {
    name: "WorkZone Tower",
    rent: 55000,
    address: "123, MG Road, Bengaluru",
  };

  // List of Office Objects
  const officeList = [
    {
      name: "SkyHub Plaza",
      rent: 75000,
      address: "450, Connaught Place, Delhi",
    },
    {
      name: "Innovation Bay",
      rent: 48000,
      address: "56, Hitech City, Hyderabad",
    },
    {
      name: "TechNest Hub",
      rent: 62000,
      address: "89, Koregaon Park, Pune",
    },
  ];

  return (
    <div className="App">
      {heading}

      <img
        src={officeImage}
        alt="Office Space"
        width="400"
        height="250"
        style={{ borderRadius: '10px', marginBottom: '20px' }}
      />

      <h2>Main Office</h2>
      <p><strong>Name:</strong> {office.name}</p>
      <p><strong>Address:</strong> {office.address}</p>
      <p style={{ color: office.rent > 60000 ? 'green' : 'red' }}>
        <strong>Rent:</strong> ₹{office.rent}
      </p>

      <h2>Other Office Listings</h2>
      <ul>
        {officeList.map((o, index) => (
          <li key={index} style={{ marginBottom: '15px' }}>
            <p><strong>Name:</strong> {o.name}</p>
            <p><strong>Address:</strong> {o.address}</p>
            <p style={{ color: o.rent > 60000 ? 'green' : 'red' }}>
              <strong>Rent:</strong> ₹{o.rent}
            </p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
