package dto;

import entity.CinemaHall;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CinemaHallList {
    public static List<Integer> seatsNumberFor1Hall = Arrays.asList(
            1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
    );
    public static List<Integer>seatsNumberFor2Hall = Arrays.asList(
            1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25
    );

    public static List<CinemaHall> cinemaHalls = Arrays.asList(
            new CinemaHall(1,seatsNumberFor1Hall),
            new CinemaHall(2,seatsNumberFor2Hall)
    );
}
