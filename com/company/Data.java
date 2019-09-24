package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;
        /*String content = Files.lines(Paths.get(fileName))
                .filter(s -> s.contains("$"))
                .map(s -> {
                    Data data = new Data();

                })
                .reduce("", String::concat);
        System.out.println(content);
        */
//System.out.println(new File(".").getAbsolutePath());
//Pattern whole = Pattern.compile("<number=" + num +  " word=\"([а-яеё\\s.]+)\" definition=\"([а-яеё\\s.]+)\" hints=\"([а-яеё\\s.]*)\"");
//Pattern whole = Pattern.compile("word=\"([a-z\\u0400-\\u04FFа-яеё])");
//File file = Paths.get(".", "src\\resources", "wordsbase.txt").normalize().toFile();
//String text = new String(Files.readAllBytes(Paths.get(String.valueOf(file))), "windows-1251");

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            String filename = ("resources/wordsbase.txt");
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File words_base = new File(classLoader.getResource(filename).getFile());
            String text = new String(Files.readAllBytes(words_base.toPath()), "UNICODE");
            System.out.println(num);
            Pattern whole = Pattern.compile(num + " word=\"([а-яеё\\s]*)\" definition=\"([a-z\\dа-яеё\\s.,:;\\-<>/\'.()]*)\" hints=\"([а-яеё\\s.]*)\"", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher m = whole.matcher(text);
            m.find();
            right_word = m.group(1).toCharArray();
            definition = m.group(2);
            hints = m.group(3);
            user_word = new String(right_word).replaceAll("[а-яеё]", "*").toCharArray();
            System.out.println(definition + "\n" + new String(right_word) + "\n" + new String(user_word));
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
