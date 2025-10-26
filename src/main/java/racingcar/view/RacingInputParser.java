package racingcar.view;

import racingcar.model.dto.CarName;
import racingcar.model.dto.CarNameList;
import racingcar.model.dto.MoveNumber;

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

    public MoveNumber parseMoveNumber(String line) {
        try{
            int number = Integer.parseInt(line);
            return new MoveNumber(number);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("시도할 횟수는 자연수입니다.");
        }
    }
}
