var AWS = require('aws-sdk'),
    region = "us-east-2",
    secretParams,
    databaseConnection

var secretsManagerClient = new AWS.SecretsManager({
    region: region
});

var mysql = require('mysql');

exports.handler = async (event, context, callback) => {

    try {

        if (!secretParams) {
            console.log('Preparing to get secrets');
            const secretValue = await secretsManagerClient.getSecretValue({ SecretId: 'RDSSecret-umGqepnON6nV' }).promise();
            secretParams = JSON.parse(secretValue.SecretString);
            console.log('Secret obtained');
        }

        console.log('Preparing to get connection');
        databaseConnection = mysql.createConnection({
            host: secretParams.host,
            user: secretParams.username,
            password: secretParams.password,
            port: secretParams.port,
            database: "mysqllab" // Comment when you want to create the database
        });
        console.log('Database connection created');

        if (event.action == "CREATE_DATABASE") {

            await new Promise((resolve, reject) => {
                databaseConnection.query("CREATE DATABASE mysqllab", function (err, result) {
                    return err ? reject(err) : resolve(result);
                });
            })
            console.log("Database created");

        } else if (event.action == "CREATE_TABLE") {

            await new Promise((resolve, reject) => {
                databaseConnection.query("CREATE TABLE MESSAGE (message VARCHAR(255))", function (err, result) {
                    return err ? reject(err) : resolve(result);
                });
            })
            console.log("Table created");

        } else if (event.action == "CONSUME_DATABASE") {

            let promiseInsert = await new Promise((resolve, reject) => {
                databaseConnection.query("INSERT INTO MESSAGE (message) VALUES ('I am MySQL')", function (err, result) {
                    return err ? reject(err) : resolve(result);
                });
            })
            console.log("Record inserted", promiseInsert);

            let promiseSelect = await new Promise((resolve, reject) => {
                databaseConnection.query("SELECT * FROM MESSAGE", function (err, result) {
                    return err ? reject(err) : resolve(result);
                });
            })
            console.log("Record selected", promiseSelect);

        }

    } catch (error) {
        console.log(error);
    }

};