package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle{
    private int seats;
    private int seatsAll;
    private int[] busySeats;
    private List<Person> persons = new ArrayList<>(seatsAll);

    public <T extends Person> Vehicle(int seatsAll) {
        seats = 0;
        this.seatsAll = seatsAll;
        busySeats=new int[seatsAll];
    }

    public int getSeatsAll() {
        return seatsAll;
    }

    public void setSeatsAll(int seatsAll) {
        this.seatsAll = seatsAll;
    }

    public int getSeats() {
        return seats;
    }

    public Boolean addPerson(Person person) throws Exception{
        if(seatsAll - seats != 0){
            seats++;
            busySeats[seats]=person.getId();
            persons.add(person);
            return true;
        }
        throw new Exception("Vechicle is full");
    }
    public  Boolean removePerson(Person person) throws Exception{
        for(int i=0; i<busySeats.length; i++){
            if(busySeats[i] == person.getId()){
                seats--;
                persons.remove(person);

                return true;
            }
        }
        throw new Exception("We can't remove");
    }
}
