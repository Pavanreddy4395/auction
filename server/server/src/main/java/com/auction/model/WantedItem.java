package com.auction.model;
import lombok.Data;
import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document;

@Document("wanted_items")
public class WantedItem {
    @Id
    private String id;
    private String keyword;
    private String userEmail;
}
