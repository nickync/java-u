import React from 'react'
import GitCard from './GitCard'

export default function GenerateCard(props) {
  return (
    <div className='text-center d-flex-row'>
        {props.profiles.map(profile => <GitCard key={profile.id} {...profile}/>)}
    </div>
  )
}

