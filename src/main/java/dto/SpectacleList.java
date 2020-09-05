package dto;

import entity.CinemaHall;
import entity.Spectacle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpectacleList {
        public static List<Spectacle> spectacleLinkedList = Arrays.asList(
            new Spectacle("Spiderman",15,120,CinemaHallList.cinemaHalls.get(0),"Monday","19:00","21:00"),
            new Spectacle("Batman",20,100, CinemaHallList.cinemaHalls.get(1),"Tuesday","11:00","13:00"),
            new Spectacle("Hulk",18,90,CinemaHallList.cinemaHalls.get(1),"Monday","15:30","17:00"),
            new Spectacle("Spiderman",15,120,CinemaHallList.cinemaHalls.get(1),"Tuesday","14:00","16:00")
        );

}
