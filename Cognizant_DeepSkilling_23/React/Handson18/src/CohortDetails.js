function CohortDetails({ cohort }) {
  return (
    <div>
      <h3>
        {cohort.cohortCode} - {cohort.technology}
      </h3>

      <p><b>Started On:</b> {cohort.startDate}</p>
      <p><b>Current Status:</b> {cohort.currentStatus}</p>
      <p><b>Coach:</b> {cohort.coachName}</p>
      <p><b>Trainer:</b> {cohort.trainerName}</p>

      <hr />
    </div>
  );
}

export default CohortDetails;