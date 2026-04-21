package com.SpaDB.SpaDB.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpaDB.SpaDB.models.BookingInfo;
import com.SpaDB.SpaDB.services.BookingService;

@CrossOrigin
@RestController
public class BookingController {

    private BookingService bookingService;
    
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/orders")
    public List<BookingInfo> displayOrders() {
        return bookingService.getBookings();
    }

    @GetMapping("/order/{id}")
    public BookingInfo getOrder(@PathVariable String id) {
        return bookingService.displayOrder(id);
    }

    @PostMapping("/order")
    public ResponseEntity<BookingInfo> newOrder(@RequestBody BookingInfo bookingInfo) {
        BookingInfo updatedBooking = bookingService.newBooking(bookingInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedBooking);
    }
}
