import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  // Fetch posts and map to Post model
  loadPosts = async () => {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      const data = await response.json();
      const postList = data.map(
        (item) => new Post(item.userId, item.id, item.title, item.body)
      );
      this.setState({ posts: postList });
    } catch (error) {
      throw new Error("Failed to load posts");
    }
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred while loading posts.");
    console.error("Error info:", info);
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id} style={{ marginBottom: "20px" }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
