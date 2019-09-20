import java.util.ArrayList;

public class Data {
	public char[] right_word; // загаданноe слово
	public String definition;
	public char[] user_word; // слово которое на данный момент видит пользователь
	public ArrayList<Character> entered_letters = new ArrayList<Character>();
	
	Data()
	{
		//TODO
	}
	
	private void get_word()
	{
		//TODO
		// получаем слово
	}
	
	public String get_hint()
	{
		return "Подсказок нет :(";
		//TODO
		// дается подсказка
	}
}
