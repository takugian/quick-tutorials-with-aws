# sqsjavasdk

This project creates:
- A SQS Queue;

#### How to test

Step 1: Create the SQS Queue using the template in this folder

Step 2: Edit the variables "queueUrl" (check on SQS console) and "message" (the message that you want to send) the class SendMessage

Step 3: Run the class SendMessage and check on SQS console to confirm the receiving of the message

Step 4: Edit the variables "queueUrl" (check on SQS console) and "messages" (the list of messages that you want to send) the class SendBatchMessage

Step 5: Run the class SendBatchMessage and check on SQS console to confirm the receiving of the messages

Step 6: Edit the variable "queueUrl" (check on SQS console) of the class RetrieveMessages

Step 7: Run the class RetrieveMessages to receive the messages

## Helpful links

- [What is Amazon Simple Queue Service?][1]

[1]: https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html