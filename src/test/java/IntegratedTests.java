import com.lincolnpomper.dishguess.logic.FoodNode;
import com.lincolnpomper.dishguess.logic.Game;
import com.lincolnpomper.dishguess.logic.GuessManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegratedTests {

	private GuessManager guessManager;
	private FoodNode rootNode;

	@Before public void setup() {

		rootNode = new FoodNode("Massa");

		FoodNode lasanha = new FoodNode("Lasanha");
		rootNode.setChildNo(new FoodNode("Bolo de chocolate"));

		FoodNode apimentado = new FoodNode("Apimentado");
		FoodNode pizza = new FoodNode("Pizza");
		apimentado.setChildYes(pizza);
		apimentado.setChildNo(lasanha);

		rootNode.setChildYes(apimentado);

		FoodNode macarrao = new FoodNode("Macarrão");
		FoodNode pratico = new FoodNode("Prático");
		pratico.setChildYes(macarrao);
		apimentado.setChildNo(pratico);

		guessManager = new GuessManagerPredefinedAnswersMock();
	}

	@Test public void whenPredefinedAnswerYesNoShouldFindMacarraoFood() {

		new Game(guessManager, rootNode).run();
		final String guess = ((GuessManagerPredefinedAnswersMock) guessManager).getRightGuess();

		Assert.assertEquals("Macarrão", guess);
	}

}
