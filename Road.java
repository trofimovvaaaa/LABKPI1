package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Road{
    public List<Vehicle> vechicles = new ArrayList<Vehicle>();
    public void addVechicle(Vehicle vechicle){vechicles.add(vechicle); }

    public Road(){addStartInformationVechicles();}
    
    private void addStartInformationVechicles(){

        vechicles.add(new Bus(30));
        vechicles.add(new Taxi(4));
        vechicles.add(new PoliceCar(2));
        vechicles.add(new FireCar(1));
    }

    public <T extends Person> Boolean addToVechicle(T t) throws Exception{
        Field vechicleListField = Road.class.getDeclaredField("vechicles");
        ParameterizedType vechicleListType = (ParameterizedType)vechicleListField.getGenericType();
        if(t instanceof Passenger){
            vechicles.get(0).addPerson(t);
            return true;
        }else if(t instanceof Policeman){
            vechicles.get(1).addPerson(t);
            return true;
        }else if(t instanceof Fireman){
            vechicles.get(2).addPerson(t);
            return true;
        }
        throw new Exception("Person can't come in");
    }

    public <T extends Person> Boolean removeFromVechicle(T t)throws Exception{
        if(t instanceof Passenger){
            vechicles.get(0).removePerson(t);
            return true;
        }else if(t instanceof Policeman){
            vechicles.get(1).removePerson(t);
            return true;
        }else if(t instanceof Fireman){
            vechicles.get(2).removePerson(t);
            return true;
        }
        throw new Exception("Person can't come out");
    }

    public int getCountOfPersons(){
        int count = 0;
        for (Vehicle element:vechicles) {
            count+=element.getSeats();
        }
        return count;
    }
}
