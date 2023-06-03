package application.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BookingSystem_SpringConfigured extends BookingSystem {
    private Restaurant restaurant;


    public BookingSystem_SpringConfigured(Restaurant restaurant) {
        super();
        this.restaurant = restaurant;
    }
}
