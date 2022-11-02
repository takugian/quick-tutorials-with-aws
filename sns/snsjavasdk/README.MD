# snsjavasdk

This project creates:
- A SNS Topic;

#### How to test

Step 1: Create the SNS topic using the template in this folder

Step 2: Edit the variables "topicArn" (check SNS console) and "email" (to receive the messages) the class SubscribeEmail

Step 3: Run the class SubscribeEmail and check the email's inbox to confirm the subscription

Step 4: Edit the variables "topicArn" (created on previous step) and "message" (the message that you want to send) the class Publish

Step 5: Run the class Publish and check the email's inbox to confirm the receiving of the message

Step 6: Edit the variable "subscriptionArn" (on SNS console, check Subscritions tab) of the class Unsubscribe

Step 7: Run the class Unsubscribe to unsubscribe the topic

## Helpful links

- [What is Amazon SNS?][1]

[1]: https://docs.aws.amazon.com/sns/latest/dg/welcome.html