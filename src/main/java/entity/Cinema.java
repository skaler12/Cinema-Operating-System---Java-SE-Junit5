package entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cinema {

    private String cinemaName;

    private String openingHours;

    private String closeHours;

    public Cinema(String cinemaName, String openingHours, String closeHours) {
        this.cinemaName = cinemaName;
        this.openingHours = openingHours;
        this.closeHours = closeHours;
    }
    public static Cinema GoodMovies = new Cinema("GoodMovies","08:00","22:00");
}

