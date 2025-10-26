package racingcar.model.dto;

public class MoveNumber {
    private final int value;

    public MoveNumber(int value){
        if(value <= 0){
            throw new IllegalArgumentException("시도할 횟수는 자연수입니다.");
        }
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
