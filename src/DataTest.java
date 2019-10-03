import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {
    @Test
    void first_word() {
        Data data = new Data();
        data.parse_data(1);
        assertEquals(new String(data.right_word), "���");
        assertEquals(new String(data.user_word), "***");
        assertEquals(data.definition, "���������� ������� ���������� � �������� ����������, ����������� �������� '0' ��� '1'.");
    }

    @Test
    void double_word() {
        Data data = new Data();
        data.parse_data(2);
        assertEquals(new String(data.right_word), "���� ������");
        assertEquals(new String(data.user_word), "**** ******");
        assertEquals(data.definition, "���� ��� ��������� ������ ������, ��������������� ��� ��������, ��������� � ��������� ������� ������� ��������������� ����������.");
    }

    @Test
    void get_hint() {
        Data data = new Data();
        data.parse_data(3);
        assertEquals(new String(data.right_word), "�������");
        assertEquals(new String(data.user_word), "*******");
        assertEquals(data.definition, "���������� ����� ���������� � ������������� ������������.");
        data.get_hint();
        assertEquals(new String(data.user_word), "�******");
    }

    @Test
    void get_hint_double_word() {
        Data data = new Data();
        data.parse_data(20);
        assertEquals(new String(data.right_word), "������������ �����");
        assertEquals(new String(data.user_word), "************ *****");
        assertEquals(data.definition, "���������� ����������� �����, ����������� ��������� �������, � ���� ������� ������������������ ���������, � ������� ����������� ��� ����������, ����������� ��� ������������� ���� �������.");
        data.get_hint();
        assertEquals(new String(data.user_word), "�*********** *****");
    }

    @Test
    void get_hint_twice() {
        Data data = new Data();
        data.parse_data(4);
        assertEquals(new String(data.right_word), "��������");
        assertEquals(new String(data.user_word), "********");
        assertEquals(data.definition, "������� �������� �������� � ������ ����������� ���������� ����������� ��������� ������������ ������������������ �������� ��� ��������� ������� ������ �� �������� ����� �����.");
        data.get_hint();
        assertEquals(new String(data.user_word), "�*******");
        data.get_hint();
        assertEquals(new String(data.user_word), "�*******");
    }
}
