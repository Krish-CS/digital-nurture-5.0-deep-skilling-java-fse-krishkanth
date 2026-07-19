import React from 'react';

class CountPeople extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }

    UpdateEntry = () => {
        this.setState(prevState => ({
            entrycount: prevState.entrycount + 1
        }));
    }

    UpdateExit = () => {
        this.setState(prevState => ({
            exitcount: prevState.exitcount + 1
        }));
    }

    render() {
        return (
            <div style={{ textAlign: 'center', marginTop: '50px' }}>
                <h2>Mall People Counter</h2>
                <div>
                    <button onClick={this.UpdateEntry} style={{ padding: '10px', margin: '10px' }}>Login</button>
                    <span>{this.state.entrycount} People Entered!</span>
                </div>
                <div>
                    <button onClick={this.UpdateExit} style={{ padding: '10px', margin: '10px' }}>Exit</button>
                    <span>{this.state.exitcount} People Left!</span>
                </div>
            </div>
        );
    }
}
export default CountPeople;
