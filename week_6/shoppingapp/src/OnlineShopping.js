import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        { itemname: 'T-shirt', price: 499 },
        { itemname: 'Shoes', price: 1499 },
        { itemname: 'Headphones', price: 1999 },
        { itemname: 'Backpack', price: 899 },
        { itemname: 'Sunglasses', price: 799 }
      ]
    };
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1> Online Shopping Cart</h1>
        {this.state.items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
