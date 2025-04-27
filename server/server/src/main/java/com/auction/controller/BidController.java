package com.auction.controller;

import com.auction.model.Bid;
import com.auction.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bids")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class BidController {

    private final BidRepository bidRepository;

    // Submit a new bid
    @PostMapping("/place")
    public ResponseEntity<Bid> placeBid(@RequestBody Bid bid) {
        bid.setTimestamp(new Date());
        Bid savedBid = bidRepository.save(bid);
        return ResponseEntity.ok(savedBid);
    }

    // Get all bids for an auction
    @GetMapping("/auction/{auctionId}")
    public ResponseEntity<List<Bid>> getBidsForAuction(@PathVariable String auctionId) {
        return ResponseEntity.ok(bidRepository.findByAuctionId(auctionId));
    }
}
