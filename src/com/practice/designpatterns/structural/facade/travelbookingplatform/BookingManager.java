package com.practice.designpatterns.structural.facade.travelbookingplatform;

import com.practice.designpatterns.structural.facade.travelbookingplatform.models.BookingResult;
import com.practice.designpatterns.structural.facade.travelbookingplatform.services.*;

import java.time.LocalDate;

public class BookingManager {
    private final BookingFacade bookingFacade;

    public BookingManager(AvailabilityService availabilityService, PaymentService paymentService,
                          NotificationService notificationService, LoyaltyService loyaltyService,
                          AccommodationDetailsService accommodationDetailsService) {
        this.bookingFacade = new BookingFacade(availabilityService, paymentService, notificationService,
                loyaltyService, accommodationDetailsService);
    }

    public BookingResult bookAccommodation(String userId, String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
        return this.bookingFacade.book(userId, accommodationId, checkInDate, checkOutDate);
    }
}
