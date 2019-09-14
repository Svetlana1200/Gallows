
public class Bot {
	public boolean is_work = true;
	public Data data = new Data();
	public int count_mistakes = 0;
	
	public void check_command(String command)
	{
		if (command.length() == 1) // ввел одну букву, которую при возможности надо открыть
		{
			//TODO
			// если command есть в загаданном слове, то записываем в слово, которое видит пользователь
			// иначе увеличиваем количество ошибок и в зависимости от кол-ва ошибок можно рисовать виселицу
			return;
		}
		switch(command)
		{
			case "/help":
				//TODO
				System.out.println("HELP");
				break;
			case "/new":
				//TODO
				System.out.println("NEW"); // начать новую игру
				break;
			case "/again":
				System.out.println("AGAIN"); // повторить текущий вопрос
				break;
			case "/hint":
				//TODO
				System.out.println("HINT"); // взять подсказку
				break;
			case "/exit": // выход из бота
				is_work = false;
				System.out.println("EXIT");
				break;
			default:
				//TODO
				System.out.println("Wrong command");
		}
	}
}
