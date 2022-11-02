package testsqsjavasdk;

import java.util.ArrayList;
import java.util.Collection;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequestEntry;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchResponse;
import software.amazon.awssdk.services.sqs.model.SqsException;

public class SendBatchMessage {

	public static void main(String[] args) {

		SqsClient sqsClient = SqsClient.builder().region(Region.US_EAST_2)
				.credentialsProvider(ProfileCredentialsProvider.create()).build();

		final String queueUrl = "https://sqs.us-east-2.amazonaws.com/804473135082/SampleQueue";

		final String[] messages = { "Message 1", "Message 2" };

		sendBatchMessages(sqsClient, queueUrl, messages);

	}

	private static void sendBatchMessages(SqsClient sqsClient, String queueUrl, String[] messages) {
		try {
			Collection<SendMessageBatchRequestEntry> entries = new ArrayList<>();
			for (int i = 0; i < messages.length; i++) {
				entries.add(
						SendMessageBatchRequestEntry.builder().id(String.valueOf(i)).messageBody(messages[i]).build());

			}
			SendMessageBatchRequest sendMessageBatchRequest = SendMessageBatchRequest.builder().queueUrl(queueUrl)
					.entries(entries).build();
			SendMessageBatchResponse result = sqsClient.sendMessageBatch(sendMessageBatchRequest);
			System.out.println("Messages sent. Status is " + result.sdkHttpResponse().statusCode());
		} catch (SqsException e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			System.exit(1);
		}
	}

}
