import java.util.ArrayList;

public class Data {
	public char[] right_word; // загаданноe слово
	public String definition;
	public char[] user_word; // слово которое на данный момент видит пользователь
	public ArrayList<Character> entered_letters = new ArrayList<Character>();
	
	Data()
	{
		/*right_word = new char[] {'б', 'и', 'т'};
		user_word = new char [right_word.length];
		for (var i = 0; i < user_word.length; i++)
			user_word[i] = '-';
		definition = "Наименьшая единица информации в цифровом компьютере, принимающая значения '0' или '1'.";*/
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
