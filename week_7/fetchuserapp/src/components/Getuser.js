// src/components/Getuser.js
import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true
    };
  }

  // Fetch user data when component mounts
  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      const user = data.results[0];
      this.setState({ user, loading: false });
    } catch (error) {
      console.error("Error fetching user:", error);
      this.setState({ loading: false });
    }
  }

  render() {
    const { user, loading } = this.state;

    if (loading) {
      return <h3>Loading user data...</h3>;
    }

    if (!user) {
      return <h3>No user data available.</h3>;
    }

    return (
      <div className="user-card">
        <h2>User Info</h2>
        <img src={user.picture.large} alt="User" />
        <p><strong>Title:</strong> {user.name.title}</p>
        <p><strong>First Name:</strong> {user.name.first}</p>
      </div>
    );
  }
}

export default Getuser;
