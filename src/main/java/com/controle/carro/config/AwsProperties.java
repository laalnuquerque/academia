import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {

    private final String region;
    private final String endpoint;
    private static final Logger logger = LoggerFactory.getLogger(AwsProperties.class);

    public AwsProperties(String region, String endpoint) {
        this.region = region;
        this.endpoint = endpoint;
    }

    public String getRegion() {
        return region;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public Region regionAsAwsEnum() {
        try {
            return Region.of(region);
        } catch (Exception e) {
            logger.warn("The specified region property does not match any AWS region, " +
                    "defaulting to SA_EAST_1. [specified-region={}]", region);
            return Region.SA_EAST_1;
        }
    }
}
