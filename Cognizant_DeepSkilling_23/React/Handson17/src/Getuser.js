import React, { Component } from "react";

class Getuser extends Component {
  constructor() {
    super();
    this.state = {
      user: null,
    };
  }

  componentDidMount() {
    fetch("https://api.randomuser.me/")
      .then((response) => response.json())
      .then((data) => {
        this.setState({
          user: data.results[0],
        });
      });
  }

  render() {
    const { user } = this.state;

    if (!user) {
      return <h2>Loading...</h2>;
    }

    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h2>User Details</h2>

        <img
          src={user.picture.large}
          alt="User"
          width="150"
          height="150"
        />

        <h3>{user.name.title}</h3>
        <h3>{user.name.first}</h3>
      </div>
    );
  }
}

export default Getuser;