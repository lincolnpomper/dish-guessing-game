import com.lincolnpomper.dishguess.logic.Answer;
import com.lincolnpomper.dishguess.logic.GuessManager;

public class GuessManagerPredefinedAnswersMock implements GuessManager {


	private String rightGuess;
	private boolean[] yesAnswers = {true, false, true, true};
	private boolean[] noAnswers = {false, true, false, false};
	private int pos = 0;

	@Override public boolean hasAnswer() {
		return true;
	}

	@Override public Answer getAnswer() {
		return new Answer(nextYesAnswer(), nextNoAnswer());
	}

	private boolean nextYesAnswer() {
		return yesAnswers[pos];
	}

	private boolean nextNoAnswer() {
		return noAnswers[pos++];
	}

	@Override public void showTipOrGuess(String tip) {
		System.out.println(tip);
	}

	@Override public void found(String rightGuess) {
		this.rightGuess = rightGuess;
	}

	@Override public void showInput() {
	}

	@Override public void rememberNextParent(String parent) {
	}

	String getRightGuess() {
		return rightGuess;
	}
}
