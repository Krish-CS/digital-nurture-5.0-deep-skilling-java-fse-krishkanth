import React from 'react';

class Getuser extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            person: null,
            loading: true
        };
    }

    async componentDidMount() {
        try {
            const response = await fetch('https://api.randomuser.me/');
            const data = await response.json();
            this.setState({ person: data.results[0], loading: false });
        } catch (error) {
            console.error("Error fetching user data", error);
            this.setState({ loading: false });
        }
    }

    render() {
        if (this.state.loading) {
            return <div>Loading...</div>;
        }

        if (!this.state.person) {
            return <div>Error loading person data.</div>;
        }

        const { title, first } = this.state.person.name;
        const { large } = this.state.person.picture;

        return (
            <div style={{ textAlign: 'center', marginTop: '50px' }}>
                <h2>Random User Data</h2>
                <img src={large} alt="User profile" style={{ borderRadius: '50%' }} />
                <h3>{title} {first}</h3>
            </div>
        );
    }
}

export default Getuser;
