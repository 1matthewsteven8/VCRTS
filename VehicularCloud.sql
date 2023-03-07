CREATE SCHEMA VehicularCloud;
use VehicularCloud;
    CREATE TABLE Vehicle(
		vehicleVIN varchar(200),
        vehicleYear varchar(200),
        vehicleMake varchar(200),
        vehicleModel varchar(200),
        vehicleColor varchar(200),
        vehicleAvailable varchar(200),
        vehicleDamageNotes varchar(200),
        username varchar(200)
	);
    CREATE TABLE Job(
		jobID varchar(200),
        jobDuration varchar(200),
        jobName varchar(200),
        jobInfo varchar(200),
        username varchar(200)
	);
