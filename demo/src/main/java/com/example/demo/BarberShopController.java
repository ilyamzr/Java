package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BarberShopController {

    private final List<Barber> availableBarbers = Arrays.asList(
            new Barber("John", Arrays.asList("Monday", "Wednesday", "Friday")),
            new Barber("Mike", Arrays.asList("Tuesday", "Thursday", "Saturday")),
            new Barber("Steve", Arrays.asList("Monday", "Thursday")),
            new Barber("Anna", Arrays.asList("Wednesday", "Saturday"))
    );

    @GetMapping("/query")
    public ResponseDTO getBarberQuery(@RequestParam String barberName) {
        for (Barber barber : availableBarbers) {
            if (barber.getName().equalsIgnoreCase(barberName)) {
                return new ResponseDTO("Barber " + barberName + " is available on: " + String.join(", ", barber.getWorkingDays()));
            }
        }
        return new ResponseDTO("Barber " + barberName + " is not found.");
    }

    @GetMapping("/path/{barberName}")
    public ResponseDTO getBarberPath(@PathVariable String barberName) {
        for (Barber barber : availableBarbers) {
            if (barber.getName().equalsIgnoreCase(barberName)) {
                return new ResponseDTO("Barber " + barberName + " is available on: " + String.join(", ", barber.getWorkingDays()));
            }
        }
        return new ResponseDTO("Barber " + barberName + " is not found.");
    }
}