// src/components/Register.js
import React, { useState } from 'react';

const Register = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
  });

  const [errors, setErrors] = useState({});

  // Validation logic
  const validate = () => {
    const newErrors = {};
    if (formData.name.length < 5) {
      newErrors.name = 'Name must be at least 5 characters long.';
    }
    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      newErrors.email = 'Email must contain "@" and "."';
    }
    if (formData.password.length < 8) {
      newErrors.password = 'Password must be at least 8 characters long.';
    }
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  // Handle real-time field updates
  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData(prev => ({
      ...prev,
      [name]: value,
    }));
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    if (validate()) {
      alert(`Registration successful for ${formData.name}!`);
      // Reset form
      setFormData({ name: '', email: '', password: '' });
      setErrors({});
    }
  };

  return (
    <div className="register-form">
      <h2>📬 Mail Register Form</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label><br />
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter your name"
          />
          {errors.name && <p className="error">{errors.name}</p>}
        </div>

        <div>
          <label>Email:</label><br />
          <input
            type="text"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter your email"
          />
          {errors.email && <p className="error">{errors.email}</p>}
        </div>

        <div>
          <label>Password:</label><br />
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Enter password"
          />
          {errors.password && <p className="error">{errors.password}</p>}
        </div>

        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Register;
