package sheridan.chrisnei.rockpaperscissors.domain;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Result {

    private List<Player> players;
    private Player winner;

    public Result() {
        log.debug("Invoked Result() constructor");
        players = new ArrayList<>();
    }
    public Result(List<Player> player, Player winner) {
        log.debug("Invoked Result(List<Player> player, Player winner) constructor");
        this.players = player;
        this.winner = winner;
    }

    public List<Player> getPlayers() {
        log.debug("Invoked Result.getPlayers()");
        return players;
    }

    public void setPlayers(List<Player> player) {
        log.debug("Invoked Result.setPlayers()");
        this.players = player;
    }

    public Player getWinner() {
        log.debug("Invoked Result.getWinner()");
        return winner;
    }

    public void setWinner(Player winner) {
        log.debug("Invoked Result.setWinner()");
        this.winner = winner;
    }
}
