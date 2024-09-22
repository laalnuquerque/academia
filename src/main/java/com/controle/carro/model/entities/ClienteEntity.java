import software.amazon.awssdk.enhanced.dynamodb.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbPartitionKey;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamoDbBean
public class Painter {

    private String codigoCliente;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private String estadoCivl;
    private Integer celular;
    private String email;



@DynamoDbBean
public class Paint {

    private String name;
    private String location;

    public Paint() {
        // Default constructor
    }
}
