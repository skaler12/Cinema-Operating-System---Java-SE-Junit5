package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Spectacle extends Cinema {

    private String spectacleName;

    private int ticketPrice;

    private int spectacleDurationInMinutes;

    private CinemaHall cinemaHallInformation;

    private String spectacleDay;

    private String startingTime;

    private String endingTime;

    public Spectacle(String spectacleName, int ticketPrice, int spectacleDurationInMinutes, CinemaHall cinemaHallInformation, String spectacleDay, String startingTime, String endingTime) {
        this.spectacleName = spectacleName;
        this.ticketPrice = ticketPrice;
        this.spectacleDurationInMinutes = spectacleDurationInMinutes;
        this.cinemaHallInformation = cinemaHallInformation;
        this.spectacleDay = spectacleDay;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }
}
