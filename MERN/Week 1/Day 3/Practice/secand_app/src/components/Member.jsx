import React, { useState } from 'react'

const Member = (props) => {
  const [age, setAge] = useState(props.age);
  const handleBirthday = () => {
    // setAge(prev => prev + 1);
    setAge(age + 1)
  };
  return (
    <div>
      <h1>{props.lastName}, {props.firstName}</h1>
      <p>Age: {age}</p>
      <p>Hair Color: {props.hairColor}</p>
      <button onClick={handleBirthday}>+1 </button>
    </div>

  )
}

export default Member
