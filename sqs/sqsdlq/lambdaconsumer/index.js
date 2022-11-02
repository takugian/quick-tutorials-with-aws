const AWS = require("aws-sdk");

const sqs = new AWS.SQS({ apiVersion: '2012-11-05' });

exports.handler = async (event, context) => {

    console.log(`Event ${JSON.stringify(event)}`)

    throw new Exception("An error has ocurred");

};