package com.lincolnpomper.jogogourmet.logic;

public class GameSimple implements Runnable {

	private final GuessManager guessManager;

	private FoodNode rootNode;
	private FoodNode currentNode;
	private FoodNode beforeYesNode;
	private FoodNode beforeNoNode;

	public GameSimple(GuessManager guessManager, FoodNode foodTree) {

		this.guessManager = guessManager;
		this.rootNode = this.currentNode = foodTree;
	}

	public FoodNode getRootNode() {
		return rootNode;
	}

	@Override public void run() {

		boolean run = true;

		while (run) {

			guessManager.showTipOrGuess(currentNode.getName());

			while (!guessManager.hasAnswer()) {
				waitForInput();
			}

			Answer answer = guessManager.getAnswer();

			if (answer.isYes() && currentNode.hasChildYes()) {

				beforeYesNode = currentNode;
				beforeNoNode = null;
				currentNode = currentNode.getChildYes();

			} else if (answer.isNo() && currentNode.hasChildNo()) {

				beforeNoNode = currentNode;
				beforeYesNode = null;
				currentNode = currentNode.getChildNo();

			} else {

				run = false;

				if (answer.isYes()) {
					guessManager.found(currentNode.getName());
				} else if (answer.isNo()) {
					guessManager.showInput();
					guessManager.rememberNextParent(currentNode.getName());
				}
			}
		}
	}

	public void insertNewNodes(FoodNode newYesNode, FoodNode secondYesNode) {

		if (beforeYesNode != null) {
			beforeYesNode.setChildYes(newYesNode);
		}

		if (beforeNoNode != null) {
			beforeNoNode.setChildNo(newYesNode);
		}

		newYesNode.setChildYes(secondYesNode);
		newYesNode.setChildNo(currentNode);
	}

	private void waitForInput() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
