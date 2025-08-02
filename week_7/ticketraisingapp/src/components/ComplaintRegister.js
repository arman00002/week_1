// src/components/ComplaintRegister.js
import React, { useState } from 'react';

const ComplaintRegister = () => {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!employeeName.trim() || !complaint.trim()) {
      alert("Please enter both name and complaint.");
      return;
    }

    // Generate a random reference number
    const refNumber = `REF-${Math.floor(100000 + Math.random() * 900000)}`;
    
    alert(
      `Complaint submitted successfully!\nReference Number: ${refNumber}`
    );

    // Clear form fields
    setEmployeeName('');
    setComplaint('');
  };

  return (
    <div className="form-container">
      <h2>📝 Raise a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Employee Name:</label><br />
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            placeholder="Enter your name"
          />
        </div>
        <div>
          <label>Complaint:</label><br />
          <textarea
            rows="5"
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            placeholder="Describe your issue..."
          ></textarea>
        </div>
        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
};

export default ComplaintRegister;
