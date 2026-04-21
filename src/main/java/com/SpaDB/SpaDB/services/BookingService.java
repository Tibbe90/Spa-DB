package com.SpaDB.SpaDB.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.SpaDB.SpaDB.models.BookingInfo;

@Service
public class BookingService {
    
private final MongoOperations mongoOperations;

public BookingService(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
}

public BookingInfo newBooking(BookingInfo bookingInfo) {
    int basePrice;
    int atendeePrice;
    switch (bookingInfo.getPackageTitle()) {
        case "Kallt spa":
            if (bookingInfo.getNrOfAtendees() > 5) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Maximum of 5 atendees allowed for this package");
            }
            basePrice = 390;
            atendeePrice = 500;
            break;
        case "Varmt spa":
            if (bookingInfo.getNrOfAtendees() > 4) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Maximum of 4 atendees allowed for this package");
            }
            basePrice = 390;
            atendeePrice = 700;
            break;
        case "Lugn och ro":
            if (bookingInfo.getNrOfAtendees() > 4) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Maximum of 4 atendees allowed for this package");
            }
            basePrice = 200;
            atendeePrice = 400;
            break;
        default:
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Package title incorrect");
    }
    bookingInfo.setPackagePrice(basePrice);
    bookingInfo.setTotalPrice(calculatePrice(atendeePrice, bookingInfo.getNrOfAtendees(), basePrice));
    return mongoOperations.insert(bookingInfo);
}

public List<BookingInfo> getBookings() {
    return mongoOperations.findAll(BookingInfo.class);
}

public BookingInfo displayOrder(String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(id));
    BookingInfo booking = mongoOperations.findOne(query, BookingInfo.class);
    if (booking == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find this booking");
    }
        return booking;
}

public int calculatePrice(int price, int nrOfAtendees, int basePrice) {
            int totalPrice = nrOfAtendees * price;
            totalPrice += basePrice;
            return totalPrice;
}
}
