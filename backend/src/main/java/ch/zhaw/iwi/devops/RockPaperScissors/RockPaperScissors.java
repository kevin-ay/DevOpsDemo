package ch.zhaw.iwi.devops.RockPaperScissors;

import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissors {

	private Object RockPaperScissors;

	public static void main(String[] args) {

		RockPaperScissors test = new RockPaperScissors();
		System.out.println("Game Start" + "\n");
		System.out.println("-------------------------------------");
		ArrayList<Integer> cpuMoves = new ArrayList<Integer>();

		cpuMoves.add(test.getMove(0));
		cpuMoves.add(test.getMove(1));

		System.out.println("Computer 1 wählt " + test.getMoveName(cpuMoves.get(0)));
		System.out.println("Computer 2 wählt " + test.getMoveName(cpuMoves.get(1)) + "\n");

		System.out.println(test.getMoveName(cpuMoves.get(0)) + " Gegen " + test.getMoveName(cpuMoves.get(1)));

		System.out.println(test.winEvaluation(cpuMoves.get(0), cpuMoves.get(1)));

	}

	public int getMove(int index) {

		// Initialisierung einer Liste / Random
		ArrayList<Integer> moves = new ArrayList<Integer>();
		Random rand = new Random();

		// Computer wählen mit Random jeweils eine Zahl zwischen 1 und 3
		int cpuGuess1 = rand.nextInt((3 + 1) - 1) + 1;
		int cpuGuess2 = rand.nextInt((3 + 1) - 1) + 1;

		// Werte werden der Liste hinzugefügt
		moves.add(cpuGuess1);
		moves.add(cpuGuess2);

		// Wert der Liste mit dem Index des Parameters wird zurückgegeben
		return moves.get(index);
	}

	public String getMoveName(int move) {
		String moveName;

		// Name je nach generierter Nummer vergeben
		if (move == 1) {
			moveName = "Schere";
		} else if (move == 2) {
			moveName = "Stein";
		} else {
			moveName = "Papier";
		}
		return moveName;
	}

	public String winEvaluation(int num1, int num2) {
		String result = null;
		if (num1 == num2) {
			result = "Unentschieden";
		} else if (num1 == 1 & num2 == 2) {
			result = "Computer 2 (Stein) gewinnt";
		} else if (num1 == 1 & num2 == 3) {
			result = "Computer 1 (Schere) gewinnt";
		} else if (num1 == 2 & num2 == 1) {
			result = "Computer 1 (Stein) gewinnt";
		} else if (num1 == 2 & num2 == 3) {
			result = "Computer 2 (Papier) gewinnt";
		} else if (num1 == 3 & num2 == 1) {
			result = "Computer 2 (Schere) gewinnt";
		} else if (num1 == 3 & num2 == 2) {
			result = "Computer 1 (Papier) gewinnt";
		}
		return result;

	}
}
