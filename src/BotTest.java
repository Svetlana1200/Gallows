import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BotTest {

	@Test
	void testCheck_input_string_one_symbol_without_game() {
		var bot = new Bot();
		bot.check_input_string("�");
		assertEquals(bot.str.toString(), "������� ����� ����\n");
	}

	@Test
	void testCheck_again_command() {
		var data = new Data();
		data.user_word = new char[] {'-', '-', '-'};
		data.definition = "���������� ������� ���������� � �������� ����������, ����������� �������� '0' ��� '1'.";
		data.entered_letters = new ArrayList<Character>() {{
			add('�');
			add('�');
		}};
		var bot = new Bot();
		bot.check_command("/again", data);
		assertEquals(bot.str.toString(), "������� ����� ����\n");
		bot.str = new StringBuilder();
		bot.is_game_continue = true;
		bot.check_command("/again", data);
		assertEquals(bot.str.toString(), "���������� ������� ���������� � �������� ����������, ����������� �������� '0' ��� '1'.\n---\n");
	}
	
	@Test
	void testCheck_letters_command() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('�');
			add('�');
		}};
		var bot = new Bot();
		bot.check_command("/letters", data);
		assertEquals(bot.str.toString(), "������� ����� ����\n");
		bot.str = new StringBuilder();
		bot.is_game_continue = true;
		bot.check_command("/letters", data);
		assertEquals(bot.str.toString(), "�, �\n");
	}
	
	@Test
	void testCheck_exit_command() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('�');
			add('�');
		}};
		var bot = new Bot();
		bot.check_command("/exit", data);
		assertEquals(bot.str.toString(), "�� ����� ������!\n");
		assertFalse(bot.is_work);
	}

	@Test
	void testCheck_wrong_command() {
		var bot = new Bot();
		bot.check_command("wrong", new Data());
		assertEquals(bot.str.toString(), "�� ����� �������� �������. ������: /help; ����� ����: /new; ��������� ������� ������: /again; ����� ���������: /hint; �����: /exit\n");
	}
	
	@Test
	void testCheck_again_symbol() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('�');
			add('�');
		}};
		var bot = new Bot();
		bot.check_symbol('�', data);
		assertEquals(bot.str.toString(), "�� ��� ������� ��� �����\n---\n");
	}
	
	@Test
	void testCheck_symbol_not_in_word() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('�');
			add('�');
		}};
		var bot = new Bot();
		bot.check_symbol('�', data);
		assertEquals(bot.str.toString(), "����� ����� ���\n---\n");
	}
	
	@Test
	void testCheck_symbol_in_word() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('�');
			add('�');
		}};
		var bot = new Bot();
		bot.check_symbol('�', data);
		assertEquals(bot.str.toString(), "�--\n");
	}
	
	@Test
	void testCheck_guess() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'�', '�', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('�');
			add('�');
		}};
		var bot = new Bot();
		bot.check_symbol('�', data);
		assertEquals(bot.str.toString(), "���\n�� �������!\n");
	}

	@Test
	void testOpen_one_symbol() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-'};
		Bot.try_open_symbol('�', data);
		assertArrayEquals(data.user_word, new char[] {'-', '�', '-'});
	}
	
	@Test
	void testNot_open_symbol() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-'};
		Bot.try_open_symbol('�', data);
		assertArrayEquals(data.user_word, new char[] {'-', '-', '-'});
	}
	
	@Test
	void testOpen_several_symbol() {
		var data = new Data();
		data.right_word = new char[] {'�', '�', '�', '�'};
		data.user_word = new char[] {'-', '-', '-', '-'};
		Bot.try_open_symbol('�', data);
		assertArrayEquals(data.user_word, new char[] {'-', '�', '-', '�'});
	}

}
