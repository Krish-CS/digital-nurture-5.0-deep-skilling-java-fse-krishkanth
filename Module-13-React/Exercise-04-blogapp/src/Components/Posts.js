import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    loadPosts = () => {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                let limitedData = data.slice(0, 4);
                const englishPosts = [
                    { title: 'Introduction to React', body: 'React is a popular JavaScript library for building user interfaces.' },
                    { title: 'Understanding Components', body: 'Components are the building blocks of any React application.' },
                    { title: 'State and Props', body: 'State allows components to manage their own data, while props pass data down.' },
                    { title: 'React Lifecycle', body: 'Lifecycle methods allow you to run code at specific times in a component.' }
                ];
                limitedData = limitedData.map((post, index) => ({
                    ...post,
                    title: englishPosts[index].title,
                    body: englishPosts[index].body
                }));
                this.setState({ posts: limitedData });
            })
            .catch(error => {
                this.setState({ error: error });
                alert("Error loading posts: " + error);
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert("Component Error: " + error);
    }

    render() {
        if (this.state.error) {
            return <div>Error loading posts.</div>;
        }

        return (
            <div>
                <h2>Blog Posts</h2>
                {this.state.posts.map(post => (
                    <Post key={post.id} title={post.title} body={post.body} />
                ))}
            </div>
        );
    }
}

export default Posts;
