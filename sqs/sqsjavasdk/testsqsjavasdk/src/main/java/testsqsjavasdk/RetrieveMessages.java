package testsqsjavasdk;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SqsException;

public class RetrieveMessages {

	public static void main(String[] args) {

		SqsClient sqsClient = SqsClient.builder().region(Region.US_EAST_2)
				.credentialsProvider(ProfileCredentialsProvider.create()).build();

		final String queueUrl = "https://sqs.us-east-2.amazonaws.com/804473135082/SampleQueue";

		receiveMessages(sqsClient, queueUrl);

	}

	private static void receiveMessages(SqsClient sqsClient, String queueUrl) {
		try {
			ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder().queueUrl(queueUrl)
					.maxNumberOfMessages(5).build();
			ReceiveMessageResponse result = sqsClient.receiveMessage(receiveMessageRequest);
			System.out.println("Messages received. Status is " + result.sdkHttpResponse().statusCode());
			for (Message message : result.messages()) {
				System.out.println(message.body());
			}
		} catch (SqsException e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			System.exit(1);
		}
	}

}
