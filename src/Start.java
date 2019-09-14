import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		var in = new Scanner(System.in);
		var bot = new Bot();
		while (bot.is_work)
		{
			String command = in.nextLine();
			bot.check_command(command);
		}
	}

}
