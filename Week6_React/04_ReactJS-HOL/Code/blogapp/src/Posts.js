import React from "react";
import Post from "./Post";

class Posts extends React.Component {

    state = {
        posts : [],
        error : null,
        success : false
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(posts => posts.json())
            .then(posts => {

                const postObjects = posts.map(postData => new Post(postData.id, postData.title, postData.body))

                this.setState({
                    posts : postObjects,
                    success : true
                })
            })
            .catch(error => {
                this.setState({
                    error : error.message
                })
            })
    }

    componentDidMount() {
        this.loadPosts();
    }

    render() {
        return (
            <div>
                <h1>Posts</h1>

                <div>
                    {
                        this.state.success && this.state.posts.map((post, index) => {
                            return (
                                <div key={index} style={{border: "2px solid black", padding: "10px", margin: "10px", display: "flex"}}>
                                    <div style={{paddingRight: "50px", alignSelf: "center"}}>
                                        <p>{post.id}</p>
                                    </div>
                                    <div style={{display: "flex", flexDirection: "column", textAlign: "left"}}>
                                        <p style={{fontWeight: 800, fontSize: "1.5rem"}}>{post.title}</p>
                                        <p>{post.body}</p>
                                    </div>
                                </div>
                            )
                        })
                    }
                </div>
            </div>
        );
    }

    componentDidCatch(error, info) {
        console.log(error);
        console.log(info);
    }
}

export default Posts;