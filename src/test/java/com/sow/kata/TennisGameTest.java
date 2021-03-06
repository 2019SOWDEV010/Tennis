package com.sow.kata;

import com.sow.kata.model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    TennisGame game;
    Player playerOne;
    Player playerTwo;


    @Before
    public void initializeGame() {
        playerOne = new Player();
        playerTwo = new Player();
        game = new TennisGame(playerOne,playerTwo);
    }

    @Test
    public void shouldReturnLoveAllWhenBothPlayersHasZeroPoints() {

        assertEquals("Love_All", game.getScore());
    }

    @Test
    public void shouldReturnFifteenALlWhenBothPlayersScoresOnePointEach() {
        player1WinsBall(1);
        player2WinsBall(1);

        assertEquals("Fifteen_All", game.getScore());
    }

    @Test
    public void shouldReturnThirtyALlWhenBothPlayersScoresTwoPointEach() {
        player1WinsBall(2);
        player2WinsBall(2);

        assertEquals("Thirty_All", game.getScore());
    }

    @Test
    public void shouldReturnDeuceWhenBothPlayersScoresThreePointsEach() {
        player1WinsBall(3);
        player2WinsBall(3);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void shouldReturnDeuceWhenBothPlayersHasEqualScoreAndGreaterThanThree() {
        player1WinsBall(4);
        player2WinsBall(4);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void shouldReturnFifteenLoveWhenPlayer1WinsOneBallAndPlayer2WinsNoBall() {
        player1WinsBall(1);
        player2WinsBall(0);

        assertEquals("Fifteen_Love", game.getScore());
    }

    @Test
    public void shouldReturnThirtyLoveWhenPlayer1WinsTwoBalls() {
        player1WinsBall(2);

        assertEquals("Thirty_Love", game.getScore());
    }

    @Test
    public void shouldReturnFortyLoveWhenPlayer1WinsTwoBalls() {
        player1WinsBall(3);

        assertEquals("Forty_Love", game.getScore());
    }

    @Test
    public void shouldReturnPlayer1HasWonWhenPlayer1WinsFourBallsAndPlayer2WonOneBall() {
        player1WinsBall(4);
        player2WinsBall(1);

        assertEquals("Player1 Has Won", game.getScore());
    }

    @Test
    public void shouldReturnPlayer2HasWonWhenPlayer1WinsOneBallsAndPlayer2WinsFourBall() {
        player1WinsBall(1);
        player2WinsBall(4);

        assertEquals("Player2 Has Won", game.getScore());
    }

    @Test
    public void shouldReturnPlayer1HasAdvantageWhenPlayer1WinsFourBallsBallsAndPlayer2WinsThreeBall() {
        player1WinsBall(4);
        player2WinsBall(3);

        assertEquals("Player1 Has Advantage", game.getScore());
    }

    @Test
    public void shouldReturnPlayer2HasAdvantageWhenPlayer1WinsThreeBallsAndPlayer2WinsFourBalls() {
        player1WinsBall(3);
        player2WinsBall(4);

        assertEquals("Player2 Has Advantage", game.getScore());
    }

    private void player1WinsBall(int times) {
        for(int i=1; i<=times; i++) {
            playerOne.winABall();
        }
    }

    private void player2WinsBall(int times) {
        for(int i=1; i<=times; i++) {
            playerTwo.winABall();
        }
    }
}

