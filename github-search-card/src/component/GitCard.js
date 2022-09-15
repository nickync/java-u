import React, { Component } from 'react'
import { Button, Card } from 'react-bootstrap';

export default class GitCard extends Component {

  render() {
    const profile = this.props;

    // const convert = (a) => {
    //   let i = 0;
    //   let date = '';
    //   while (i <= a.length){
    //     if (a.charAt(i) == 'T'){
    //       break
    //     }
    //     date += a.charAt(i)
    //     i ++
    //   }
    //   return date
    // }

    function location(){
      if (profile.location !== null){
        return <Card.Header>{profile.location}</Card.Header>
      } else {

      }return <Card.Header>Somewhere over the Rainbow</Card.Header>
    }
    
    return (
      <div className='d-inline-flex'>
        <Card style={{width: '18rem'}} className='mx-auto mt-5 ms-3 bg-light'>
          <Card.Img variant='top' src={profile.avatar_url} />
          <Card.Body className='text-center bg-warning'>
            <Card.Title>{profile.name ? profile.name : 'Name not available'}</Card.Title>
            <Card.Header>Works at : {profile.company ? profile.company : 'Not available'}</Card.Header>
            <Card.Header>Created at : {profile.created_at.substring(0, profile.created_at.indexOf('T'))}</Card.Header>
            {/* <Card.Header>Created at : {convert(profile.created_at)}</Card.Header> */}
            <Card.Header>Last Update : {profile.updated_at.substring(0, profile.updated_at.indexOf('T'))}</Card.Header>
            <Card.Header>Follower: {profile.followers}</Card.Header>
            <Card.Header>Following: {profile.following}</Card.Header>
            {location(profile)}
            <Card.Link href={`https://github.com/${profile.login}`} className='text-dark-gradient' style={{ textDecoration: 'none' }}>Github HERE</Card.Link>
          </Card.Body>
        </Card>
      </div>
    )
  }
}
