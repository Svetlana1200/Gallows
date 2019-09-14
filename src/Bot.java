
public class Bot {
	public boolean is_work = true;
	public Data data = new Data();
	public int count_mistakes = 0;
	
	public void check_command(String command)
	{
		if (command.length() == 1) // ���� ���� �����, ������� ��� ����������� ���� �������
		{
			//TODO
			// ���� command ���� � ���������� �����, �� ���������� � �����, ������� ����� ������������
			// ����� ����������� ���������� ������ � � ����������� �� ���-�� ������ ����� �������� ��������
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
				System.out.println("NEW"); // ������ ����� ����
				break;
			case "/again":
				System.out.println("AGAIN"); // ��������� ������� ������
				break;
			case "/hint":
				//TODO
				System.out.println("HINT"); // ����� ���������
				break;
			case "/exit": // ����� �� ����
				is_work = false;
				System.out.println("EXIT");
				break;
			default:
				//TODO
				System.out.println("Wrong command");
		}
	}
}
