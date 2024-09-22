import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class DynamoDBConfig {

    private final AwsProperties awsProperties;

    public DynamoDBConfig(AwsProperties awsProperties) {
        this.awsProperties = awsProperties;
    }

    @Bean
    public DynamoDbClient dynamoDBClient() {
        DynamoDbClient.Builder builder = DynamoDbClient.builder()
                .region(awsProperties.regionAsAwsEnum())
                .credentialsProvider(DefaultCredentialsProvider.create());

        String endpoint = awsProperties.getEndpoint();
        if (endpoint != null && !endpoint.isEmpty()) {
            builder.endpointOverride(URI.create(endpoint));
        }

        return builder.build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDBEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }
}
