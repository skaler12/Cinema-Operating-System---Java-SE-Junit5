package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CinemaHall {

    private int hallNumber;

    private List<Integer>numbersOfSeats;

}
