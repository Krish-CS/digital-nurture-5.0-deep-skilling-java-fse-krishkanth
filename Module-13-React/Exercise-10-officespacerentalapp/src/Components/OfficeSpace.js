import React from 'react';

const OfficeSpace = () => {
    const offices = [
        { Name: 'Tech Hub', Rent: 50000, Address: '123 IT Park, Chennai', Image: 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=300&q=80' },
        { Name: 'Startup Space', Rent: 70000, Address: '456 Business Rd, Bangalore', Image: 'https://images.unsplash.com/photo-1497366811353-6870744d04b2?w=300&q=80' },
        { Name: 'Co-working Center', Rent: 45000, Address: '789 Cyber City, Hyderabad', Image: 'https://images.unsplash.com/photo-1524758631624-e2822e304c36?w=300&q=80' },
        { Name: 'Corporate Tower', Rent: 90000, Address: '101 Finance St, Mumbai', Image: 'https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=300&q=80' }
    ];

    return (
        <div>
            <h1>Office Space Rental Portal</h1>
            <div style={{ display: 'flex', flexWrap: 'wrap' }}>
                {offices.map((office, index) => {
                    const rentColor = office.Rent <= 60000 ? 'red' : 'green';
                    
                    return (
                        <div key={index} style={{ border: '1px solid #ccc', margin: '10px', padding: '15px', width: '250px' }}>
                            <img src={office.Image} alt={office.Name} style={{ width: '100%' }} />
                            <h2>{office.Name}</h2>
                            <p><b>Address:</b> {office.Address}</p>
                            <p>
                                <b>Rent:</b> <span style={{ color: rentColor }}>Rs. {office.Rent}</span>
                            </p>
                        </div>
                    );
                })}
            </div>
        </div>
    );
};

export default OfficeSpace;
