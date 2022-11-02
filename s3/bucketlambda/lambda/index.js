console.log('Loading function');

const aws = require('aws-sdk');

const s3 = new aws.S3({ apiVersion: '2006-03-01' });

exports.handler = async (event) => {

    const params = {
        Bucket: "tg-quicklabs-lambdasrc",
    };

    let response = { statusCode: 400, body: "", };

    try {

        console.log('Checking event action');

        if (event.action == "LIST") {

            let listObjectsResult = await s3.listObjects(params).promise();

            console.log('Listing objects has completed');

            if (listObjectsResult)
                response = { statusCode: 200, body: JSON.stringify(listObjectsResult.Contents), };

        }

    } catch (error) {
        response = { statusCode: 500, body: JSON.stringify(error), };
    }

    return response;

};