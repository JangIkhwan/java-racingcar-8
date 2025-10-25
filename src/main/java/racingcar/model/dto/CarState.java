package racingcar.model.dto;

public class CarState{
    String name;
    int distance;

    public CarState(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    public String getName(){
        return this.name;
    }

    public int getDistance(){
        return this.distance;
    }
}