package racingcar.model.dto;

import java.util.List;

public class GameResult {
    final List<GameState> gameStates;
    final List<String> winnerNames;

    public GameResult(List<GameState> gameStates, List<String> winnerNames) {
        this.gameStates = gameStates;
        this.winnerNames = winnerNames;
    }

    public List<GameState> getGameStates(){
        return this.gameStates;
    }

    public List<String> getWinnerNames(){
        return this.winnerNames;
    }
}
