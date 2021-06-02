package sheridan.chrisnei.rockpaperscissors.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * An enum to model the choice that a user can make in the game
 */
@Slf4j
public enum Choice {
    /**
     * A constant representing a 'rock' choice
     */
    ROCK {
        @Override
        public String toString() {
            log.debug("Invoked Choice.ROCK.toString()");
            return "Rock";
        }
    },

    /**
     * A constant representing a 'paper' choice
     */
    PAPER {
        @Override
        public String toString() {
            log.debug("Invoked Choice.PAPER.toString()");
            return "Paper";
        }
    },

    /**
     * A constant representing a 'scissors' choice
     */
    SCISSORS {
        @Override
        public String toString() {
            log.debug("Invoked Choice.SCISSORS.toString()");
            return "Scissors";
        }
    };
}
