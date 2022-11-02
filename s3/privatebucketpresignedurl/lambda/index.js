console.log('Loading function');

const aws = require('aws-sdk');

const s3 = new aws.S3({ apiVersion: '2006-03-01' });

exports.handler = async (event) => {

    const params = {
        'Bucket': event.bucket,
        'Key': event.key,
        ContentType: event.input.filetype
    };

    s3.getSignedUrl('putObject', params, (error, url) => {
        if (error) {
            console.log('error:', error)
            context.done(error)
        } else {
            context.done(null, {
                url: url,
                name: key,
                filetype: event.input.filetype
            });
        }
    })

};