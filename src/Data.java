import java.util.ArrayList;

public class Data {
	public char[] right_word; // ���������e �����
	public String definition;
	public char[] user_word; // ����� ������� �� ������ ������ ����� ������������
	public ArrayList<Character> entered_letters = new ArrayList<Character>();
	
	Data()
	{
		right_word = new char[] {'�', '�', '�'};
		user_word = new char [right_word.length];
		for (var i = 0; i < user_word.length; i++)
			user_word[i] = '-';
		definition = "���������� ������� ���������� � �������� ����������, ����������� �������� '0' ��� '1'.";
		//TODO
	}
	
	private void get_word()
	{
		//TODO
		// �������� �����
	}
	
	public String get_hint()
	{
		return "��������� ��� :(";
		//TODO
		// ������ ���������
	}
}
