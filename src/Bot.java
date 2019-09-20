import java.util.Arrays;

public class Bot 
{
	public boolean is_work = true;
	private static Data data;
	private int count_user_mistakes = 0;
	private boolean is_game_continue = false;
	
	Bot()
	{
		System.out.println("Время поиграть! Помощь: /help; новая игра: /new; повторить текущий вопрос: /again; взять подсказку: /hint; выйти: /exit");
	}
	
	public void check_input_string(String inp_str)
	{
		if (inp_str.length() == 1) // ввел одну букву, которую при возможности надо открыть
		{
			if (is_game_continue)
				check_symbol(inp_str.charAt(0));
			else
				System.out.println("Начните новую игру");
			return;
		}
		check_command(inp_str);	
	}
	
	public void check_command(String command)
	{
		switch(command)
		{
			case "/help":
				System.out.println("Помощь: /help; новая игра: /new; повторить текущий вопрос: /again; взять подсказку: /hint; выйти: /exit");
				break;
			case "/new":
				data = new Data();// начать новую игру
				is_game_continue = true;
				System.out.println(data.definition + "\n" + new String(data.user_word));
				break;
			case "/again":
				if (is_game_continue)
					System.out.println(data.definition);// повторить текущий вопрос
				else
					System.out.println("Начните новую игру");
				break;
			case "/hint":
				if (is_game_continue)
					System.out.println(data.get_hint()); // взять подсказку
				else
					System.out.println("Начните новую игру");
				break;
			case "/letters":	
				if (is_game_continue)
					System.out.println(data.entered_letters.toString().replaceAll("\\[\\]", "")); // посмотреть введенные буквы
				else
					System.out.println("Начните новую игру");
				break;
			case "/exit": // выход из бота
				is_work = false;
				System.out.println("До новый встреч!");
				break;
			default:
				System.out.println("Вы ввели неверную команду. Помощь: /help; новая игра: /new; повторить текущий вопрос: /again; взять подсказку: /hint; выйти: /exit");
		}	
	}
	
	public void check_symbol(char symbol)
	{
		if (!data.entered_letters.contains(symbol))
		{
			if (!try_open_symbol(symbol))
			{
				count_user_mistakes++;
				System.out.println("Такой буквы нет");
			}
			System.out.println(data.user_word);
			if (Arrays.equals(data.right_word, data.user_word))
			{
				System.out.println("Вы угадали!");
				is_game_continue = false;
			}
			data.entered_letters.add(symbol);
		}
		else
			System.out.println("Вы уже вводили эту букву");
	}
	
	public static boolean try_open_symbol(char symbol)
	{
		var is_in_word = false; 
	    for (int i = 0; i < data.right_word.length; i++)
	    {
	        if (data.right_word[i] == symbol)
	        {
	        	data.user_word[i] = symbol;
	        	is_in_word = true;
	        }
	    }
	    return is_in_word;
	}
}
