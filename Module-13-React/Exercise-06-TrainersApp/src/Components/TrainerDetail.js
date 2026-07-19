import React from 'react';
import { useParams, Link } from 'react-router-dom';
import { trainers } from './TrainersMock';

const TrainerDetail = () => {
    const { id } = useParams();
    const trainer = trainers.find(t => t.TrainerId === parseInt(id));

    if (!trainer) {
        return <div>Trainer not found.</div>;
    }

    return (
        <div>
            <h2>Trainer Details</h2>
            <p><b>ID:</b> {trainer.TrainerId}</p>
            <p><b>Name:</b> {trainer.Name}</p>
            <p><b>Email:</b> {trainer.Email}</p>
            <p><b>Phone:</b> {trainer.Phone}</p>
            <p><b>Technology:</b> {trainer.Technology}</p>
            <p><b>Skills:</b> {trainer.Skills}</p>
            <Link to="/trainers">Back to List</Link>
        </div>
    );
};
export default TrainerDetail;
