package com.lincolnpomper.jogogourmet;

import com.lincolnpomper.jogogourmet.gui.Frame;
import com.lincolnpomper.jogogourmet.logic.*;

import javax.swing.*;

public class Main implements GuessManager, StartGameManager {

	private Frame frame;
	private GameSimple game;

	private Main() {

		frame = new Frame(this);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.showScreen();
	}

	public static void main(String[] args) {
		new Main();
	}

	private void startNewGame() {

		FoodNode node;

		if (game == null) {
			node = createStarterNodes();
		} else {
			node = game.getRootNode();
		}
		game = new GameSimple(this, node);
		Thread thread = new Thread(game);
		thread.start();
	}

	private FoodNode createStarterNodes() {
		FoodNode node = new FoodNode("Massa");
		node.setChildYes(new FoodNode("Lasanha"));
		node.setChildNo(new FoodNode("Bolo de chocolate"));
		return node;
	}


	@Override public void startAgain() {
		startNewGame();
	}

	@Override public boolean hasAnswer() {
		return frame.hasAnswer();
	}

	@Override public Answer getAnswer() {
		return frame.getAnswer();
	}

	@Override public void insertNewFoodBeforeStart(String newFoodName, String newFoodTipName) {
		if (newFoodName != null) {
			game.insertNewNodes(new FoodNode(newFoodTipName), new FoodNode(newFoodName));
		}
	}

	@Override public void showTipOrGuess(String tip) {
		frame.showTipOrGuess(tip);
	}

	@Override public void found(String rightGuess) {
		frame.showFinalAnswer(rightGuess);
	}

	@Override public void showInput() {
		frame.showInputForNewFood();
	}

	@Override public void rememberNextParent(String nextParent) {
		frame.setParentFoodName(nextParent);
	}
}
