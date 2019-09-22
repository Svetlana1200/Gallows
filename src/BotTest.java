import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BotTest {

	@Test
	void testCheck_input_string_one_symbol_without_game() {
		var bot = new Bot();
		bot.check_input_string("я");
		assertEquals(bot.str.toString(), "Начните новую игру\n");
	}

	@Test
	void testCheck_again_command() {
		var data = new Data();
		data.user_word = new char[] {'-', '-', '-'};
		data.definition = "Наименьшая единица информации в цифровом компьютере, принимающая значения '0' или '1'.";
		data.entered_letters = new ArrayList<Character>() {{
			add('а');
			add('ь');
		}};
		var bot = new Bot();
		bot.check_command("/again", data);
		assertEquals(bot.str.toString(), "Начните новую игру\n");
		bot.str = new StringBuilder();
		bot.is_game_continue = true;
		bot.check_command("/again", data);
		assertEquals(bot.str.toString(), "Наименьшая единица информации в цифровом компьютере, принимающая значения '0' или '1'.\n---\n");
	}
	
	@Test
	void testCheck_letters_command() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('а');
			add('ь');
		}};
		var bot = new Bot();
		bot.check_command("/letters", data);
		assertEquals(bot.str.toString(), "Начните новую игру\n");
		bot.str = new StringBuilder();
		bot.is_game_continue = true;
		bot.check_command("/letters", data);
		assertEquals(bot.str.toString(), "а, ь\n");
	}
	
	@Test
	void testCheck_exit_command() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('а');
			add('ь');
		}};
		var bot = new Bot();
		bot.check_command("/exit", data);
		assertEquals(bot.str.toString(), "До новый встреч!\n");
		assertFalse(bot.is_work);
	}

	@Test
	void testCheck_wrong_command() {
		var bot = new Bot();
		bot.check_command("wrong", new Data());
		assertEquals(bot.str.toString(), "Вы ввели неверную команду. Помощь: /help; новая игра: /new; повторить текущий вопрос: /again; взять подсказку: /hint; выйти: /exit\n");
	}
	
	@Test
	void testCheck_again_symbol() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('а');
			add('ь');
		}};
		var bot = new Bot();
		bot.check_symbol('а', data);
		assertEquals(bot.str.toString(), "Вы уже вводили эту букву\n---\n");
	}
	
	@Test
	void testCheck_symbol_not_in_word() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('а');
			add('ь');
		}};
		var bot = new Bot();
		bot.check_symbol('р', data);
		assertEquals(bot.str.toString(), "Такой буквы нет\n---\n");
	}
	
	@Test
	void testCheck_symbol_in_word() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'-', '-', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('а');
			add('ь');
		}};
		var bot = new Bot();
		bot.check_symbol('б', data);
		assertEquals(bot.str.toString(), "б--\n");
	}
	
	@Test
	void testCheck_guess() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'б', 'и', '-'};
		data.entered_letters = new ArrayList<Character>() {{
			add('а');
			add('ь');
		}};
		var bot = new Bot();
		bot.check_symbol('т', data);
		assertEquals(bot.str.toString(), "бит\nВы угадали!\n");
	}

	@Test
	void testOpen_one_symbol() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'-', '-', '-'};
		Bot.try_open_symbol('и', data);
		assertArrayEquals(data.user_word, new char[] {'-', 'и', '-'});
	}
	
	@Test
	void testNot_open_symbol() {
		var data = new Data();
		data.right_word = new char[] {'б', 'и', 'т'};
		data.user_word = new char[] {'-', '-', '-'};
		Bot.try_open_symbol('ь', data);
		assertArrayEquals(data.user_word, new char[] {'-', '-', '-'});
	}
	
	@Test
	void testOpen_several_symbol() {
		var data = new Data();
		data.right_word = new char[] {'б', 'а', 'з', 'а'};
		data.user_word = new char[] {'-', '-', '-', '-'};
		Bot.try_open_symbol('а', data);
		assertArrayEquals(data.user_word, new char[] {'-', 'а', '-', 'а'});
	}

}
