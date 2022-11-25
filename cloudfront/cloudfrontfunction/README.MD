# cloudfrontfunction

This project creates a CloudFront Distribution with a CloudFront function.

## How to test

- Upload the files located in website folder into the bucket created;
- Use Distribution domain name to access the application
    - If you add header x-channel equal to 'mobile', you will be redirect to the page /mobile/index.html;

## Helpful links

- [What is Amazon CloudFront?][1]
- [Customizing at the edge with CloudFront Functions][2]
- [What is Amazon S3?][3]
- [Hosting a static website using Amazon S3][4]

[1]: https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html
[2]: https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/cloudfront-functions.html
[3]: https://docs.aws.amazon.com/AmazonS3/latest/userguide/Welcome.html
[4]: https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteHosting.html