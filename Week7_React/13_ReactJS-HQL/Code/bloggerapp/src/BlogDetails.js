import React from 'react'

const BlogDetails = (props) => {
    const content=(
        <ul>
          {props.blog.map((blog)=>
           <div key={blog.id}>
           <h1>{blog.name}</h1>
           <b><p>{blog.author}</p></b>
           <p>{blog.cont}</p>
           </div>
        )}
        </ul>
    )
  return (
    <div>
      {content}
    </div>
  )
}

export default BlogDetails