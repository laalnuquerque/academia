package com.hebertrfreitas.dynamodbexample.repository;

import com.hebertrfreitas.dynamodbexample.model.Painter;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.DeleteItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;

@Repository
public class PaintersRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public PaintersRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    private DynamoDbTable<Painter> getMappedTable() {
        return dynamoDbEnhancedClient.table("Painters", TableSchema.fromBean(Painter.class));
    }

    public void createPainter(Painter painter) {
        if (painter.getId() == null) {
            throw new IllegalArgumentException("Painter ID cannot be null");
        }

        if (getPainter(painter.getId()) != null) {
            throw new IllegalArgumentException("A painter with this id already exists [id=" + painter.getId() + "]");
        }

        PutItemEnhancedRequest<Painter> putItemRequest = PutItemEnhancedRequest.builder(Painter.class)
                .item(painter)
                .build();
        getMappedTable().putItem(putItemRequest);
    }

    public Painter getPainter(String painterId) {
        GetItemEnhancedRequest getItemRequest = GetItemEnhancedRequest.builder()
                .key(Key.builder()
                        .partitionValue(painterId)
                        .build())
                .build();
        return getMappedTable().getItem(getItemRequest);
    }

    public void deletePainter(Painter painter) {
        if (painter.getId() == null) {
            throw new IllegalArgumentException("Painter ID cannot be null");
        }

        DeleteItemEnhancedRequest deleteItemRequest = DeleteItemEnhancedRequest.builder()
                .key(Key.builder()
                        .partitionValue(painter.getId())
                        .build())
                .build();
        getMappedTable().deleteItem(deleteItemRequest);
    }
}
