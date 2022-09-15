import React, { Component } from 'react'
import  {Button}  from 'react-bootstrap'
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from 'axios';

export default class FormInput extends Component {
  
  state = {username:''};

  handleSubmit = async (e) => {
    e.preventDefault();
    let res = null;
    
    
    try {
      res = await axios.get(`https://api.github.com/users/${this.state.username}`);
      this.props.onSubmit(res.data);
      console.log(res.data)
      console.log(typeof res.data.created_at)
      this.setState({username:''});
    } catch (error) {
      alert("User not found!")
    }
    
  }

  render() {
    return (
      <div className='text-center'>
        <form  onSubmit={this.handleSubmit}>
          <InputGroup className='mx-auto w-75'>
            <Form.Control type='text'
              placeholder = "Enter a username" value={this.state.username} onChange={ e => this.setState({username: e.target.value})} required
            />

            <button className='btn btn-dark bg-gradient'>Search</button>
          </InputGroup>
        </form>


        {/* <form onSubmit={this.handleSubmit}>
            <label>Enter name:</label>
            <input 
              type='text' 
              value={this.state.username} 
              onChange={ e => this.setState({username: e.target.value})} 
              placeholder='Enter a username' 
              required/> 

            <Button className='btn-dark bg-gradient ms-1'>Search</Button>

            <button className='btn btn-primary'>Search</button>

        </form> */}


      </div>
    )
  }
}
