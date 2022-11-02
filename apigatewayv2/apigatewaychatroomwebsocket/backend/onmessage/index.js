const AWS = require('aws-sdk');

const ddb = new AWS.DynamoDB.DocumentClient();

require('./patch.js');

let sendMessage = undefined;

function init(domainName, stage) {

    const apigwManagementApi = new AWS.ApiGatewayManagementApi({ apiVersion: '2018-11-29', endpoint: domainName + '/' + stage });

    sendMessage = async (connectionIdFrom, connectionIdTo, data) => {
        const message = `Message from ${connectionIdFrom}: ${data}`;
        console.log('Sending message to connection', JSON.stringify(message));
        await apigwManagementApi.postToConnection({ ConnectionId: connectionIdTo, Data: message }).promise();
        console.log('Message sent to connection ', JSON.stringify(message));
    }

}

exports.handler = (event, context, callback) => {

    console.log('Event received', JSON.stringify(event));

    const connectionIdFrom = event.requestContext.connectionId;
    const domainName = event.requestContext.domainName;
    const stage = event.requestContext.stage;

    init(domainName, stage);

    let message = JSON.parse(event.body).message;

    getConnections().then((data) => {
        console.log('Connections opened', data.Items);
        data.Items.forEach(function (connectionTo) {
            if (connectionIdFrom != connectionTo.connectionid) { // Only send message to different connections
                sendMessage(connectionIdFrom, connectionTo.connectionid, message);
            }
        });
    });

    callback(null, { statusCode: 200, });

};

function getConnections() {
    return ddb.scan({ TableName: 'Chat', }).promise();
}