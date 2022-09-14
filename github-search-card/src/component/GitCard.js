import React, { Component } from 'react'
import { Button, Card } from 'react-bootstrap';

export default class GitCard extends Component {
  render() {
    const profile = this.props;
    
    return (
      <div className='d-inline-flex'>
        <Card style={{width: '18rem'}} className='mt-5 ms-4 bg-light'>
          <Card.Img variant='top' src={profile.avatar_url} />
          <Card.Body className='text-center'>
            <Card.Title>{profile.name ? profile.name : 'Name not available'}</Card.Title>
            <Card.Header>Works at : {profile.company ? profile.company : 'Not available'}</Card.Header>
            <Card.Link href={`https://github.com/${profile.login}`} className='text-info'>Github Link</Card.Link>
          </Card.Body>
        </Card>
      </div>
    )
  }
}
