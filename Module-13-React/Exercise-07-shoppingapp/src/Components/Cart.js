import React from 'react';

class Cart extends React.Component {
    render() {
        return (
            <div style={{ border: '1px solid gray', padding: '10px', margin: '10px', width: '200px' }}>
                <p><b>Item Name:</b> {this.props.item.Itemname}</p>
                <p><b>Price:</b> {this.props.item.Price}</p>
            </div>
        );
    }
}
export default Cart;
