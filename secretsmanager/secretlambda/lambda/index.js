
var AWS = require('aws-sdk');

var client = new AWS.SecretsManager({
    region: "us-east-2"
});

exports.handler = async (event) => {

    let secretName = event.secretName;

    try {

        let data = await client.getSecretValue({ SecretId: secretName }).promise();

        const response = {
            statusCode: 200,
            body: JSON.stringify(data)
        };

        console.log('response', response);

    } catch (err) {
        return {
            statusCode: 500,
            body: JSON.stringify(err)
        };
    }

};