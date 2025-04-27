package com.auction.repository;

import com.auction.model.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends MongoRepository<Auction, String> {

    // Optional: custom query methods
    List<Auction> findBySellerId(String sellerId);

    List<Auction> findByIsLiveTrue();
    List<Auction> findByTitleContainingIgnoreCase(String keyword);

}
