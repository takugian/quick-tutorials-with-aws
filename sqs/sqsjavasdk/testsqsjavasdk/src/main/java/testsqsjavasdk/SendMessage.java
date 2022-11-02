package testsqsjavasdk;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;
import software.amazon.awssdk.services.sqs.model.SqsException;

public class SendMessage {

	public static void main(String[] args) {

		SqsClient sqsClient = SqsClient.builder().region(Region.US_EAST_2)
				.credentialsProvider(ProfileCredentialsProvider.create()).build();

		final String queueUrl = "<>";

		final String message = "Testing...";

		sendMessage(sqsClient, queueUrl, message);

	}

	private static void sendMessage(SqsClient sqsClient, String queueUrl, String message) {
		try {
			SendMessageResponse result = sqsClient.sendMessage(
					SendMessageRequest.builder().queueUrl(queueUrl).messageBody(message).delaySeconds(1).build());
			System.out
					.println(result.messageId() + " Message sent. Status is " + result.sdkHttpResponse().statusCode());
		} catch (SqsException e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			System.exit(1);
		}
	}

}
