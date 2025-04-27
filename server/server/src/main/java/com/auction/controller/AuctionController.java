package com.auction.controller;

import com.auction.model.Auction;
//import com.auction.model.Auction.Bid;
import com.auction.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/auctions")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionRepository auctionRepo;

    // Create new auction
    @PostMapping("/create")
    public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
        auction.setCreatedAt(new Date());
        return ResponseEntity.ok(auctionRepo.save(auction));
    }

    // Get all auctions
    @GetMapping("/all")
    public ResponseEntity<List<Auction>> getAllAuctions() {
        return ResponseEntity.ok(auctionRepo.findAll());
    }

    // Search by title
    @GetMapping("/search")
    public ResponseEntity<List<Auction>> searchAuctions(@RequestParam String keyword) {
        List<Auction> results = auctionRepo.findByTitleContainingIgnoreCase(keyword);
        return ResponseEntity.ok(results);
    }

    // Place a bid
//    @PostMapping("/{id}/bid")
//    public ResponseEntity<Auction> placeBid(@PathVariable String id, @RequestBody Bid bid) {
//        Auction auction = auctionRepo.findById(id).orElseThrow();
//        auction.getBids().add(bid);
//        Auction updated = auctionRepo.save(auction);
//        return ResponseEntity.ok(updated);
//    }
}
