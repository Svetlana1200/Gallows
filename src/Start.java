import java.util.Scanner;

public class Start 
{
	public static void main(String[] args) {
		var in = new Scanner(System.in);
		var bot = new Bot();
		System.out.print("Время поиграть! Помощь: /help; новая игра: /new; повторить текущий вопрос: /again; взять подсказку: /hint; выйти: /exit\n");
		while (bot.is_work)
		{
			String command = in.nextLine();
			bot.check_input_string(command);
			System.out.print(bot.str.toString());
		}
	}
}
