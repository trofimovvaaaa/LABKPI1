package com.company;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Test {

    @org.junit.jupiter.api.Test
    public void trueUnitTest() throws Exception {
        Road road = new Road();
        Passenger passenger = new Passenger(1, 13);
        Boolean actual = road.addToVechicle(passenger);
        assertEquals(actual, true);
    }
    @org.junit.jupiter.api.Test
    public void falseUnitTest0() {
        Road road = new Road();
        SomethingStrange no=new SomethingStrange(3, 4);
        try{
            road.addToVechicle(no);
            fail();
        }
        catch(Exception e){
            assertThat(e.getMessage(),is("Person can't come in"));
        }
    }

    @org.junit.jupiter.api.Test
    public void falseUnitTest1() {
        Road road = new Road();
        SomethingStrange no=new SomethingStrange(3, 4);
        try{
            road.removeFromVechicle(no);
            fail();
        }
        catch(Exception e){
            assertThat(e.getMessage(),is("Person can't come out"));
        }
    }
    @org.junit.jupiter.api.Test
    public void falseUnitTest2() {
        Road road = new Road();
        SomethingStrange no=new SomethingStrange(3, 4);
        try{
            road.vechicles.get(0).removePerson(no);
            fail();
        }
        catch(Exception e){
            assertThat(e.getMessage(),is("We can't remove"));
        }
    }
}