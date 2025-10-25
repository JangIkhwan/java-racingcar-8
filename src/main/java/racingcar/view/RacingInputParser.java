package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingInputParser {
    public List<String> parseCarNames(String line) {
        String[] names = line.split(",");
        Set<String> nameSet = new HashSet<>();
        for(String name : names){
            if(isInvalidName(name)){
                throw new IllegalArgumentException("자동차 이름은 공백이 아닌 1자 이상 5자 이하의 문자열입니다.");
            }
            if(isDuplicateName(nameSet, name)){
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
        return Arrays.asList(names);
    }

    private static boolean isInvalidName(String name) {
        return name.isEmpty() || name.length() > 5;
    }

    private boolean isDuplicateName(Set<String> set, String name) {
        if(set.contains(name)){
            return true;
        }
        set.add(name);
        return false;
    }

    public int parseMoveNumber(String line) {
        try{
            int moveNumber = Integer.parseInt(line);
            if(moveNumber <= 0){
                throw new IllegalArgumentException("시도할 횟수는 자연수입니다.");
            }
            return moveNumber;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("시도할 횟수는 자연수입니다.");
        }
    }
}
