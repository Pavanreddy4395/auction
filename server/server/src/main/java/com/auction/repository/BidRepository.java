package com.auction.repository;

import com.auction.model.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BidRepository extends MongoRepository<Bid, String> {
    List<Bid> findByAuctionId(String auctionId);
}