import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohortCode, startDate, status }) => {
    const headingStyle = {
        color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
    };

    return (
        <div className={styles.box}>
            <h3 style={headingStyle}>{cohortCode}</h3>
            <dl>
                <dt>Start Date</dt>
                <dd>{startDate}</dd>
                <dt>Status</dt>
                <dd>{status}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;
