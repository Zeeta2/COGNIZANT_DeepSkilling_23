import React, { Component } from "react";

class Register extends Component {

    constructor(props) {
        super(props);

        this.state = {
            name: "",
            email: "",
            password: "",
            message: ""
        };
    }


    handleChange = (event) => {

        this.setState({

            [event.target.name]: event.target.value

        });

    };


    handleSubmit = (event) => {

        event.preventDefault();


        let error = "";


        // Name validation

        if(this.state.name.length < 5) {

            error += "Name should have atleast 5 characters\n";

        }


        // Email validation

        if(
            !this.state.email.includes("@") ||
            !this.state.email.includes(".")
        ) {

            error += "Email should contain @ and .\n";

        }


        // Password validation

        if(this.state.password.length < 8) {

            error += "Password should have atleast 8 characters\n";

        }



        if(error === "") {

            alert("Registration Successful");

        }

        else {

            alert(error);

        }


    };


    render() {

        return (

            <div style={{textAlign:"center"}}>


                <h1>Mail Registration</h1>


                <form onSubmit={this.handleSubmit}>


                    <label>
                        Name:
                    </label>

                    <br/>

                    <input
                        type="text"
                        name="name"
                        value={this.state.name}
                        onChange={this.handleChange}
                    />


                    <br/><br/>


                    <label>
                        Email:
                    </label>

                    <br/>

                    <input
                        type="email"
                        name="email"
                        value={this.state.email}
                        onChange={this.handleChange}
                    />


                    <br/><br/>


                    <label>
                        Password:
                    </label>

                    <br/>

                    <input
                        type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handleChange}
                    />


                    <br/><br/>


                    <button type="submit">
                        Register
                    </button>


                </form>


            </div>

        );

    }

}


export default Register;