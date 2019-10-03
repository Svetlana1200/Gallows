import java.util.Arrays;

public class Bot 
{
	public boolean is_work = true;
	private Data data;
	private int count_user_mistakes = 0;
	public boolean is_game_continue = false;
	public StringBuilder str = new StringBuilder(); 

	public void check_input_string(String inp_str)
	{
		str = new StringBuilder();
		if (inp_str.length() == 1) // ���� ���� �����, ������� ��� ����������� ���� �������
		{
			if (is_game_continue)
				check_symbol(inp_str.charAt(0), data);
			else
				str.append("������� ����� ����\n");
		}
		else
			data = check_command(inp_str, data);
	}
	
	public Data check_command(String command, Data data)
	{
		switch(command)
		{
			case "/help":
				str.append("������: /help; ����� ����: /new; ��������� ������� ������: /again; ����� ���������: /hint; �����: /exit\n");
				break;
			case "/new":
				data = new Data();// ������ ����� ����
				is_game_continue = true;
				str.append(data.definition + "\n" + new String(data.user_word) + "\n");
				break;
			case "/again":
				if (is_game_continue)
					str.append(data.definition + "\n" + new String(data.user_word) + "\n");
				else
					str.append("������� ����� ����\n");
				break;
			case "/hint":
				if (is_game_continue)
					str.append(data.get_hint() + "\n");
				else
					str.append("������� ����� ����\n");
				break;
			case "/letters":	
				if (is_game_continue)
					str.append(data.entered_letters.toString().replaceAll("\\[", "").replaceAll("\\]", "") + "\n");
				else
					str.append("������� ����� ����\n");
				break;
			case "/exit":
				is_work = false;
				str.append("�� ����� ������!\n");
				break;
			default:
				str.append("�� ����� �������� �������. ������: /help; ����� ����: /new; ��������� ������� ������: /again; ����� ���������: /hint; �����: /exit\n");
		}	
		return data;
	}
	
	public void check_symbol(char symbol, Data data)
	{
		if (!data.entered_letters.contains(symbol))
		{
			if (!try_open_symbol(symbol, data))
			{
				count_user_mistakes++;
				str.append("����� ����� ���\n");
			}
			str.append(new String(data.user_word) + "\n");
			if (Arrays.equals(data.right_word, data.user_word))
			{
				str.append("�� �������!\n");
				is_game_continue = false;
			}
			data.entered_letters.add(symbol);
		}
		else
			str.append("�� ��� ������� ��� �����\n" + new String(data.user_word) + "\n");
	}
	
	public static boolean try_open_symbol(char symbol, Data data)
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
