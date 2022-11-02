const AWS = require('aws-sdk');

const ddb = new AWS.DynamoDB.DocumentClient();

exports.handler = (event, context, callback) => {

    console.log('Event received', JSON.stringify(event));

    const connectionId = event.requestContext.connectionId;

    addConnectionId(connectionId).then(() => { callback(null, { statusCode: 200, }) });

}

function addConnectionId(connectionId) {
    console.log('Adding connectionId to the database', connectionId);
    return ddb.put({ TableName: 'Chat', Item: { connectionid: connectionId }, }).promise();
}