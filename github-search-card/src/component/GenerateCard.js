import React from 'react'
import GitCard from './GitCard'

export default function GenerateCard(props) {
  return (
    <div>
        {props.profiles.map(profile => <GitCard key={profile.id} {...profile}/>)}
    </div>
  )
}

