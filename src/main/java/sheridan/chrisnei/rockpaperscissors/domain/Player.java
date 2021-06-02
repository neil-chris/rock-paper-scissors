package sheridan.chrisnei.rockpaperscissors.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * Models a player of the game
 */
@Slf4j
public class Player {
    private Choice choice;
    private Type type;

    /**
     * Constructs a player
     */
    public Player() {
        log.debug("Invoked Player() Constructor");
    }

    /**
     * Constructs a play with the given choice
     * @param choice
     */
    public Player(Choice choice, Type type) {
        log.debug("Invoked Player(Choice choice, Type type) constructor");
        this.choice = choice;
        this.type = type;
    }

    public Choice getChoice() {
        log.debug("Invoked Player.getChoice()");
        return choice;
    }

    public void setChoice(Choice choice) {
        log.debug("Invoked Player.setChoice()");
        this.choice = choice;
    }

    public Type getType() {
        log.debug("Invoked Player.getType()");
        return type;
    }

    public void setType(Type type) {
        log.debug("Invoked Player.setType()");
        this.type = type;
    }

    /**
     * An Enum to represent the type of player
     */
    public enum Type {

        /**
         * A computer player
         */
        COMPUTER {
            @Override
            public String toString() {
                log.debug("Invoked Type.COMPUTER.toString()");
                return "Computer";
            }
        },

        /**
         * A human player
         */
        HUMAN {
            @Override
            public String toString() {
                log.debug("Invoked Type.HUMAN.toString()");
                return "Human";
            }

        }
    }
}
