import React, { Component } from 'react'

export default class HeaderComponent extends Component {
  render() {
    return (
      <div>
        <header>
            <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                <div><a href='http://localhost:3000/' className='navbar-brand'> Employee Management App </a></div>
            </nav>
        </header>
      </div>
    )
  }
}
