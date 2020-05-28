package Game;
import javax.swing.*;

import GUI.Window;

import java.util.ArrayList;
import java.util.Collections;
public class Game {
	//INSTANCE VARIABLES
    static String[] options = {"Player vs Player", "Player vs Computer", "Exit"};
    static String[] choices = {"Rock", "Paper", "Scissors", "HighScore", "Exit"};
    static String[] restart = {"Yes", "No"};

    static String rock;
    static String paper;
    static String scissors;

    static int cnt =0;

    static boolean continueGame = true;

    static ArrayList<Integer> highScore = new ArrayList<Integer>();

    static ArrayList<Integer> highScoreP2 = new ArrayList<Integer>();

    static int loss;
    static int win;
    static int totalWins;
    static int totalWinsP2;
    static boolean keepPlaying = true;
/*This is the main method, it begins by telling the player about the game, then the game begins, all the regular rules
 * of rock paper scissors apply, if rock is played and the other player plays paper, the other player's wins increase
 * and you gain one loss and vice versa, regular rules apply for all other plays, if both players play the same hand 
 * nothing happens, a full game is three turns, if all three games are won by any player their highscore is increased
 * by one. if you choose not to restart when the game ends, the application will close 
 * 
 * */
    public static void main(String[] args) {
        loss = 0;
        win = 0;
        totalWins = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Rock Paper Scissors!");
        JOptionPane.showMessageDialog(null, "In both game modes you can leave at any time");
        JOptionPane.showMessageDialog(null, "A counter will display your score");
        JOptionPane.showMessageDialog(null, "Have fun!");
        int x = Window.option(options, "Welcome to Rock Paper Scissors!");
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "Player vs Player mode pressed");
            JOptionPane.showMessageDialog(null, "Player one chooses first");
            while (continueGame) {
                while (keepPlaying) {
                    int a = Window.option(choices, "Player one's choice\nCurrent Score: Player One's score: " +win +" Player Two's score: " + loss
                            +"\nPlayer One's Wins: " +totalWins +" Player Two's Wins: " + totalWinsP2);
                    if (a == 0) {
                        //Rock
                        rock = "Rock";
                        int p2 = Window.option(choices, "Player two's choice\nCurrent Score: Player One's score: " +win +" Player Two's score: " + loss +"\n"
                                + "Player One's score: " +totalWins +" Player Two's score: " + totalWinsP2);
                        if(p2 == 0){
                            JOptionPane.showMessageDialog(null, "Same Play, no one wins");
                        }
                        else if(p2 == 1){
                            //rock loses paper
                            loss++;
                            if(loss == 3){
                                updateList(totalWins);
                                totalWins = 0;
                                totalWinsP2 += 1;
                                win = 0;
                                loss = 0;
                            }
                        }
                        else if (p2 == 2){
                            //scissors
                            win++;
                            if(win == 3){
                                updateListP2(totalWinsP2);
                                totalWinsP2 = 0;
                                totalWins += 1;
                                win = 0;
                                loss = 0;
                            }
                        }
                        else if(p2 == 3){
                            //highscore
                            JOptionPane.showMessageDialog(null, "HighScores:\n" + highScoreP2);
                        }
                        else{
                            cnt = 1;
                            break;
                        }
                    } else if (a == 1) {
                        paper = "Paper";
                        int p2 = Window.option(choices, "Player two's choice\nCurrent Score: Player One's score: " +win +" Player Two's score: " + loss +"\n"
                                + "Player One's score: " +totalWins +" Player Two's score: " + totalWinsP2);
                        if(p2 == 1){
                            JOptionPane.showMessageDialog(null, "Same Play, no one wins");
                        }
                        else if(p2 == 2){
                            //scissor beats paper
                            loss++;
                            if(loss == 3){
                                updateList(totalWins);
                                totalWins = 0;
                                totalWinsP2 += 1;
                                win = 0;
                                loss = 0;
                            }
                        }
                        else if (p2 == 0){
                            //rock
                            win++;
                            if(win == 3){
                                updateListP2(totalWinsP2);
                                totalWinsP2 = 0;
                                totalWins += 1;
                                win = 0;
                                loss = 0;
                            }
                        }
                        else if(p2 == 3){
                            //highscore
                            JOptionPane.showMessageDialog(null, "HighScores:\n" + highScoreP2);
                        }
                        else{
                            cnt = 1;
                            break;
                        }
                    } else if (a == 2) {
                        scissors = "Scissors";
                        int p2 = Window.option(choices, "Player two's choice\nCurrent Score: Player One's score: " +win +" Player Two's score: " + loss +"\n"
                                + "Player One's WinStreak: " +totalWins +" Player Two's WinStreak: " + totalWinsP2);
                        if(p2 == 2){
                            JOptionPane.showMessageDialog(null, "Same Play, no one wins");
                        }
                        else if(p2 == 0){
                            //rock loses paper
                            loss++;
                            if(loss == 3){
                                updateList(totalWins);
                                totalWins = 0;
                                totalWinsP2 += 1;
                                win = 0;
                                loss = 0;
                            }
                        }
                        else if (p2 == 1){
                            //scissors
                            win++;
                            if(win == 3){
                                updateListP2(totalWinsP2);
                                totalWinsP2 = 0;
                                totalWins += 1;
                                win = 0;
                                loss = 0;
                            }
                        }
                        else if(p2 == 3){
                            //highscore
                            JOptionPane.showMessageDialog(null, "HighScores:\n" + highScoreP2);
                        }
                        else{
                            cnt = 1;
                            break;
                        }
                    } else if (a == 3) {
                        JOptionPane.showMessageDialog(null, "HighScores:\n" + highScore);
                    } else {
                        cnt = 1;
                        break;
                    }
                }
                if(cnt == 1){
                    continueGame = false;
                    System.exit(0);
                }
            }

        } else if (x == 1) {
            JOptionPane.showMessageDialog(null, "Player vs Computer mode pressed");
            while (continueGame) {
                while (keepPlaying) {
                    int b = Window.option(choices, "Pick a choice\nCurrent Scores: Player's Score: " + win + " Computer's Score: " + loss +
                            "\nRounds Won: " + totalWins);
                    String computer = choices[(int) (Math.random() * 3)];
                    if (b == 0) {
                        rock = "Rock";
                        if (rock.equals(computer)) {
                            JOptionPane.showMessageDialog(null, "Same Play, no one wins");
                        } else if (computer.equals("Paper")) {
                            //player won
                            win++;
                            if (win == 3) {
                                totalWins++;
                                loss = 0;
                                win = 0;
                                //keepPlaying = false;
                            }
                        } else if (computer.equals("Scissors")) {
                            //player loss
                            loss++;
                            if (loss == 3) {
                                keepPlaying = false;
                                updateList(totalWins);
                                loss = 0;
                                win = 0;
                                totalWins = 0;
                            }
                        }
                    } else if (b == 1) {
                        paper = "Paper";
                        if (paper.equals(computer)) {
                            JOptionPane.showMessageDialog(null, "Same Play, no one wins");
                        } else if (computer.equals("Rock")) {
                            win++;
                            if (win == 3) {
                                totalWins++;
                                loss = 0;
                                win = 0;
                                //keepPlaying = false;
                            }
                        } else if (computer.equals("Scissors")) {
                            loss++;
                            if (loss == 3) {
                                keepPlaying = false;
                                updateList(totalWins);
                                loss = 0;
                                win = 0;
                                totalWins = 0;
                            }
                        }
                    } else if (b == 2) {
                        scissors = "Scissors";
                        if (scissors.equals(computer)) {
                            JOptionPane.showMessageDialog(null, "Same Play, no one wins");
                        }
                        if (computer.equals("Paper")) {
                            win++;
                            if (win == 3) {
                                totalWins++;
                                loss = 0;
                                win = 0;
                                //keepPlaying = false;
                            }
                        }
                        if (computer.equals("Rock")) {
                            loss++;
                            if (loss == 3) {
                                keepPlaying = false;
                                updateList(totalWins);
                                loss = 0;
                                win = 0;
                                totalWins = 0;
                            }
                        }
                    } else if (b == 3) {
                        JOptionPane.showMessageDialog(null, "HighScores:\n" + highScore);
                    } else {
                        cnt = 1;
                        break;
                    }
                }
                if(cnt == 1){
                    continueGame = false;
                    System.exit(0);
                }
                int re = Window.option(restart, "Do you want to play again?");
                if (re == 0) {
                    keepPlaying = true;
                } else {
                    continueGame = false;
                    System.exit(0);
                }
            }
        }
    }
//updates player 1's Highscore
    public static void updateList(int number){
        if(number > 0) {
            highScore.add(number);
            Collections.sort(highScore);
            Collections.reverse(highScore);
        }
    }
//Updates player 2's highscore 
    public static void updateListP2(int number){
        if(number > 0) {
            highScoreP2.add(number);
            Collections.sort(highScoreP2);
            Collections.reverse(highScoreP2);
        }
    }

}
