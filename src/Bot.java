import java.util.Arrays;

public class Bot 
{
	public boolean is_work = true;
	private static Data data;
	private int count_user_mistakes = 0;
	private boolean is_game_continue = false;
	
	Bot()
	{
		System.out.println("����� ��������! ������: /help; ����� ����: /new; ��������� ������� ������: /again; ����� ���������: /hint; �����: /exit");
	}
	
	public void check_input_string(String inp_str)
	{
		if (inp_str.length() == 1) // ���� ���� �����, ������� ��� ����������� ���� �������
		{
			if (is_game_continue)
				check_symbol(inp_str.charAt(0));
			else
				System.out.println("������� ����� ����");
			return;
		}
		check_command(inp_str);	
	}
	
	public void check_command(String command)
	{
		switch(command)
		{
			case "/help":
				System.out.println("������: /help; ����� ����: /new; ��������� ������� ������: /again; ����� ���������: /hint; �����: /exit");
				break;
			case "/new":
				data = new Data();// ������ ����� ����
				is_game_continue = true;
				System.out.println(data.definition + "\n" + new String(data.user_word));
				break;
			case "/again":
				if (is_game_continue)
					System.out.println(data.definition);// ��������� ������� ������
				else
					System.out.println("������� ����� ����");
				break;
			case "/hint":
				if (is_game_continue)
					System.out.println(data.get_hint()); // ����� ���������
				else
					System.out.println("������� ����� ����");
				break;
			case "/letters":	
				if (is_game_continue)
					System.out.println(data.entered_letters.toString().replaceAll("\\[\\]", "")); // ���������� ��������� �����
				else
					System.out.println("������� ����� ����");
				break;
			case "/exit": // ����� �� ����
				is_work = false;
				System.out.println("�� ����� ������!");
				break;
			default:
				System.out.println("�� ����� �������� �������. ������: /help; ����� ����: /new; ��������� ������� ������: /again; ����� ���������: /hint; �����: /exit");
		}	
	}
	
	public void check_symbol(char symbol)
	{
		if (!data.entered_letters.contains(symbol))
		{
			if (!try_open_symbol(symbol))
			{
				count_user_mistakes++;
				System.out.println("����� ����� ���");
			}
			System.out.println(data.user_word);
			if (Arrays.equals(data.right_word, data.user_word))
			{
				System.out.println("�� �������!");
				is_game_continue = false;
			}
			data.entered_letters.add(symbol);
		}
		else
			System.out.println("�� ��� ������� ��� �����");
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
