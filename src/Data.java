import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {
    static char[] right_word; // загаданноe слово
    public static String definition;
    static char[] user_word; // слово которое на данный момент видит пользователь
    static String hints;
    public ArrayList<Character> entered_letters = new ArrayList<>();
    private boolean letter_hint = false;


    Data()
    {
        int num = (int)(( Math.random() * (40 - 1 + 1) + 1));
        parse_data(num);
    }

    public static void parse_data(int num) {
        try {
            String filename = ("resources/words_base.txt");
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File words_base = new File(classLoader.getResource(filename).getFile());
            String text = new String(Files.readAllBytes(words_base.toPath()), "utf8");

            Pattern whole = Pattern.compile(num + " word=\"([а-яеё\\s]*)\" definition=\"([a-z\\dа-яеё\\s.,:;\\-<>/\'.()]*)\" hints=\"([а-яеё\\s.]*)\"", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher m = whole.matcher(text);
            m.find();
            right_word = m.group(1).toCharArray();
            definition = m.group(2);
            hints = m.group(3);
            user_word = new String(right_word).replaceAll("[а-яеё]", "*").toCharArray();
        }
        catch (IOException e)
        {
            System.out.println("Cant read this file" + e);
        }
    }


    public String get_hint()
    {
        //Открывает первую неизвестную букву
        if (!letter_hint) {
            for (int i=0; i<right_word.length; i++){
                if (user_word[i] != right_word[i]){
                    entered_letters.add(right_word[i]);
                    user_word[i] = right_word[i];
                    letter_hint = true;
                    break;
                }
            }
            return("Буква открыта: " + new String(user_word));
        }
        else{
            return ("Вы использовали эту подсказку");
        }
    }

}
