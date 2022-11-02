const AWS = require('aws-sdk');

const ddb = new AWS.DynamoDB.DocumentClient();

exports.handler = (event, context, callback) => {

    console.log('Event received', JSON.stringify(event));

    const connectionId = event.requestContext.connectionId;

    removeConnectionId(connectionId).then(() => { callback(null, { statusCode: 200, }) });

}

function removeConnectionId(connectionId) {
    console.log('Removing connectionId from the database', connectionId);
    return ddb.delete({ TableName: 'Chat', Key: { connectionid: connectionId, }, }).promise();
}