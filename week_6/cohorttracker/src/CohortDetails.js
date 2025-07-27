import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ title, status, startDate }) {
  return (
    <div className={styles.box}>
      <h3 style={{ color: status === 'ongoing' ? 'green' : 'blue' }}>{title}</h3>
      <dl>
        <dt>Status:</dt>
        <dd>{status}</dd>
        <dt>Start Date:</dt>
        <dd>{startDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
