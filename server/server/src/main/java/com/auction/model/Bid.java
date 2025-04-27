package com.auction.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "bids")
public class Bid {
    @Id
    private String id;
    private String auctionId;
    private String itemTitle;
    private String userId;
    private double amount;
    private Date timestamp = new Date();
}