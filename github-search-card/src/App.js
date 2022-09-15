import React, { Component } from 'react'
import logo from './logo.svg';
import './App.css';
import Header from './component/Header';
import FormInput from './component/FormInput';
import GenerateCard from './component/GenerateCard';
import Footer from './component/Footer';

export default class App extends Component {
  state = {

    profiles : [],

  };

  addProfiles = (profile) => {
    this.setState(prevState => ({
      profiles : [...prevState.profiles, profile]
    }))
  }

  render() {
    return (
      <div>
        <Header />
        <FormInput onSubmit={this.addProfiles}/>
        <GenerateCard profiles = {this.state.profiles}/>
        <Footer />
      </div>
    )
  }
}