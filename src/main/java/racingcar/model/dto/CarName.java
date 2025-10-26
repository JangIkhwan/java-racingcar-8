package racingcar.model.dto;

import java.util.Objects;

public class CarName {
    private final String value;

    public CarName(String value){
        if(validate(value)){
            throw new IllegalArgumentException("자동차 이름은 공백이 아닌 1자 이상 5자 이하의 문자열입니다.");
        }
        this.value = value;
    }

    private static boolean validate(String name) {
        return name.isEmpty() || name.length() > 5;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
