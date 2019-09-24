package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bot bot = new Bot();
        System.out.println("Âðåìÿ ïîèãðàòü! Ïîìîùü: /help; íîâàÿ èãðà: /new; ïîâòîðèòü òåêóùèé âîïðîñ: /again; âçÿòü ïîäñêàçêó: /hint; âûéòè: /exit\n");
        while (bot.is_work)
        {
            String command = in.nextLine();
            bot.check_input_string(command);
            System.out.print(bot.str.toString());
        }
    }

}
