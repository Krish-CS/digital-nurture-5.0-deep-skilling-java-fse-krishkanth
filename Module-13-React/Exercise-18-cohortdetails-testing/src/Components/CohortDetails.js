import React from 'react';

const CohortDetails = (props) => {
    return (
        <div>
            <h3>{props.cohort.cohortCode}</h3>
            <p>Start Date: {props.cohort.startDate}</p>
            <p>Status: {props.cohort.status}</p>
        </div>
    );
};

export default CohortDetails;
