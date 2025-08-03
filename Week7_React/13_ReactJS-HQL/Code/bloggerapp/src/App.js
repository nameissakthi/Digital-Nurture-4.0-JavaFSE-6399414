import './App.css';
import BookDetials from './BookDetials';
import CourseDetails from './CourseDetails';
import BlogDetails from './BlogDetails';

function App() {
  const books = [
    { id: 101, bname: "Master React", price: 670 },
    { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
    { id: 103, bname: "Mongo Essentials", price: 450 },
  ];
  const course = [
    { id: 1, cname: "Angular", date: "4/5/2021" },
    { id: 2, cname: "React", date: "6/3/2021" }
  ];
  const blog = [
    { id: 11, name: "React Learning", author: "Stephen Biz", cont: "Welcome to learning React!" },
    { id: 12, name: "Installation", author: "Schewzdenier", cont: "You can install React from npm" }
  ];

  return (
    <div className="App">
  <div className="content-wrapper">
    <div className="v1">
      <h1>Course Details</h1>
      <CourseDetails course={course} />
    </div>

    <div className="st2">
      <h1>Book Details</h1>
      <BookDetials books={books} />
    </div>

    <div className="mystyle1">
      <h1>Blog Details</h1>
      <BlogDetails blog={blog} />
    </div>
  </div>
</div>

  );
}

export default App;
