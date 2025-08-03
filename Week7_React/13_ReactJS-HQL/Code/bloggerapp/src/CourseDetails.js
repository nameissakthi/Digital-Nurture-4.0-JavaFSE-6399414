import React from 'react'

const CourseDetails = (props) => {
    const coursedet=(
        <ul>
            {props.course.map((course)=>
            <div key={course.id}>
              <h1>{course.cname}</h1>
              <p>{course.date}</p>
            </div>
            )}
        </ul>
    );
  return (
    <div>
      {coursedet}
    </div>
  )
}

export default CourseDetails