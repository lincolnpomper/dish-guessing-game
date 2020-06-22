package com.lincolnpomper.dishguess.logic;

public interface GuessManager {

	boolean hasAnswer();

	Answer getAnswer();

	void showTipOrGuess(String tip);

	void found(String rightGuess);

	void showInput();

	void rememberNextParent(String parent);
}
