import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Card{
	public String[] types = { "·½¿é", "Ã·»¨", "ºìÌÒ", "ºÚÌÒ" };
	public String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	public List<String> cards = new LinkedList<>();

	public void initCards() {
		for (int i = 0; i < types.length; i++)
			for (int j = 0; j < values.length; j++) {
				cards.add(types[i] + values[j]);
			}
		Collections.shuffle(cards);
	}

	public void showAllCards() {
		for (String card : cards)
			System.out.println(card);
	}

}