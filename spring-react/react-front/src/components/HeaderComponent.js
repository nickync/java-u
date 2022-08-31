import React, { Component } from 'react'

export default class HeaderComponent extends Component {
  render() {
    return (
      <div>
        <header>
            <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                <div><a href='https://zheng-li.netlify.app' className='navbar-brand'> Employee Management App </a></div>
            </nav>
        </header>
      </div>
    )
  }
}
