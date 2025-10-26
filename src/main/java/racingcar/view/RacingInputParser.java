package racingcar.view;

import racingcar.model.dto.CarName;
import racingcar.model.dto.CarNameList;

public class RacingInputParser {
    private String NAME_DELIMITER_REGEXP = ",";

    public CarNameList parseCarNameList(String line) {
        String[] names = line.split(NAME_DELIMITER_REGEXP);
        CarNameList carNameList = new CarNameList();
        for(String name : names){
            carNameList.add(new CarName(name));
        }
        return carNameList;
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
