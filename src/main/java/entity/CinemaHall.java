package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class CinemaHall {

    private int hallNumber;

    private List<Integer>numbersOfSeats;

    public CinemaHall(int hallNumber, List<Integer> numbersOfSeats) {
        this.hallNumber = hallNumber;
        this.numbersOfSeats = numbersOfSeats;
    }
}
