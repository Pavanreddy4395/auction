package com.auction.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "auctions")
public class Auction {

    @Id
    private String id;

    private String title;
    private String description;
    private double startingPrice;

    private Date createdAt = new Date(); // auto timestamp

    private String sellerId; // optional: link to User (for ownership)

    private boolean isLive = false; // for WebSocket/live tracking
}
