package org.csystem.samples.commandpromptapp;

import org.csystem.util.StringUtil;

import java.util.Scanner;

public class CommandPrompt {
    private static String [] ms_commands = {"length", "reverse", "lower", "upper", "change"};
    private String m_prompt;
    private Scanner m_kb;

    private void lengthProc(String [] commandInfo)
    {
        System.out.println(commandInfo[1].length());
    }

    private void reverseProc(String [] commandInfo)
    {
        System.out.println(StringUtil.reverse(commandInfo[1]));
    }

    private void lowerProc(String [] commandInfo)
    {
        System.out.println(commandInfo[1].toLowerCase());
    }

    private void upperProc(String [] commandInfo)
    {
        System.out.println(commandInfo[1].toUpperCase());
    }

    private void changeProc(String [] commandInfo)
    {
        m_prompt = commandInfo[1];
    }

    private boolean commandProc(String [] commandInfo)
    {
        String cmd = commandInfo[0];

        for (int i = 0; i < ms_commands.length; ++i) {
            if (ms_commands[i].startsWith(cmd)) {
                switch (i) {
                    case 0:
                        lengthProc(commandInfo);
                        break;
                    case 1:
                        reverseProc(commandInfo);
                        break;
                    case 2:
                        lowerProc(commandInfo);
                        break;
                    case 3:
                        upperProc(commandInfo);
                        break;
                    case 4:
                        changeProc(commandInfo);
                        break;
                }
                return  true;
            }
        }

        return false;
    }

    public CommandPrompt(String text)
    {
        m_prompt = text;
        m_kb = new Scanner(System.in);
    }

    public void run()
    {
        System.out.println("Komut yorumlayıcı Program");
        System.out.println("Copyleft C and System Programmers Association");
        for (;;) {
            System.out.print(m_prompt + ">");
            String cmdText = m_kb.nextLine().trim();
            String [] commandInfo = cmdText.split("[ \t]+");

            if (commandInfo.length == 1) {
                if (commandInfo[0].equals("quit"))
                    break;

                System.out.println("Invalid command");
            }
            else if (commandInfo.length != 2) {
                System.out.println("Invalid command");
                continue;
            }

            if (!commandProc(commandInfo))
                System.out.println("Invalid command");
        }

        System.out.println("Good bye");
    }
}
