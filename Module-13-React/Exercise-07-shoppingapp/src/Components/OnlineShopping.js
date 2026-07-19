import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
    constructor(props) {
        super(props);
        this.cartItems = [
            { Itemname: 'Laptop', Price: 50000 },
            { Itemname: 'Washing Machine', Price: 30000 },
            { Itemname: 'Mobile', Price: 20000 },
            { Itemname: 'Fridge', Price: 25000 },
            { Itemname: 'Microwave', Price: 10000 }
        ];
    }

    render() {
        return (
            <div>
                <h2>Online Shopping Portal</h2>
                <div style={{ display: 'flex', flexWrap: 'wrap' }}>
                    {this.cartItems.map((item, index) => (
                        <Cart key={index} item={item} />
                    ))}
                </div>
            </div>
        );
    }
}
export default OnlineShopping;
