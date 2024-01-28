package com.practice.designpatterns.structural.facade.travelbookingplatform;

import com.practice.designpatterns.structural.facade.travelbookingplatform.models.BookingConfirmation;
import com.practice.designpatterns.structural.facade.travelbookingplatform.models.BookingResult;
import com.practice.designpatterns.structural.facade.travelbookingplatform.models.PaymentStatus;
import com.practice.designpatterns.structural.facade.travelbookingplatform.services.*;

import java.time.LocalDate;

public class BookingFacade {
    private final AvailabilityService availabilityService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;
    private final LoyaltyService loyaltyService;
    private final AccommodationDetailsService accommodationDetailsService;

    public BookingFacade(AvailabilityService availabilityService, PaymentService paymentService,
                         NotificationService notificationService, LoyaltyService loyaltyService,
                         AccommodationDetailsService accommodationDetailsService) {
        this.availabilityService = availabilityService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.loyaltyService = loyaltyService;
        this.accommodationDetailsService = accommodationDetailsService;
    }

    public BookingResult book(String userId, String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
        boolean isAvailable = availabilityService.checkAvailability(accommodationId, checkInDate, checkOutDate);

        if (!isAvailable) {
            return BookingResult.notAvailable("Accommodation not available for the given dates");
        }

        PaymentStatus paymentStatus = paymentService.makePayment(userId, accommodationId);
        if (paymentStatus != PaymentStatus.SUCCESS) {
            return BookingResult.paymentFailed("Payment failed with status: " + paymentStatus);
        }

        BookingConfirmation confirmation = new BookingConfirmation(userId, accommodationId, checkInDate, checkOutDate);
        notificationService.sendBookingConfirmation(confirmation);

        loyaltyService.updateLoyaltyPoints(userId, paymentService.calculatePaymentAmount(accommodationId));
        accommodationDetailsService.updateAccommodationDetails(accommodationId, checkInDate, checkOutDate);

        return BookingResult.success(confirmation);
    }
}
