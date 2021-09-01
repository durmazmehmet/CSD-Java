package org.csystem.app.samples.util;

import org.csystem.util.StringUtil;

import java.util.Scanner;

public class CommandPrompt {
    private String m_prompt;
    private Scanner m_kb;

    public static String getCommand(String cmd)
    {
        if (cmd.length() < 3)
            return "";

        String [] cmds = {"upper", "lower", "reverse", "length", "change"};
        int len = cmds.length;

        for (int i = 0; i < len; ++i)
            if (cmds[i].startsWith(cmd))
                return cmds[i];

        return "";
    }

    public void doCommand(String cmd, String [] cmdInfo)
    {
        if (cmd.isEmpty()) {
            System.out.println("Geçersiz komut");
            return;
        }

        switch (cmd) {
            case "upper":
                upperProc(cmdInfo);
                break;
            case "lower":
                lowerProc(cmdInfo);
                break;
            case "length":
                lengthProc(cmdInfo);
                break;
            case "reverse":
                reverseProc(cmdInfo);
                break;
            case "change":
                changeProc(cmdInfo);
                break;
        }
    }

    public void upperProc(String [] cmdInfo)
    {
        if (cmdInfo.length > 2) {
            System.out.println("Komuta çok argüman verilmiş");
            return;
        }
        System.out.println(cmdInfo[1].toUpperCase());
    }

    public void lowerProc(String [] cmdInfo)
    {
        if (cmdInfo.length > 2) {
            System.out.println("Komuta çok argüman verilmiş");
            return;
        }
        System.out.println(cmdInfo[1].toLowerCase());
    }

    public void lengthProc(String [] cmdInfo)
    {
        if (cmdInfo.length > 2) {
            System.out.println("Komuta çok argüman verilmiş");
            return;
        }
        System.out.println(cmdInfo[1].length());
    }

    public void reverseProc(String [] cmdInfo)
    {
        if (cmdInfo.length > 2) {
            System.out.println("Komuta çok argüman verilmiş");
            return;
        }
        System.out.println(StringUtil.reverse(cmdInfo[1]));
    }

    public void changeProc(String [] cmdInfo)
    {
        if (cmdInfo.length > 2) {
            System.out.println("Komuta çok argüman verilmiş");
            return;
        }
        m_prompt = cmdInfo[1];
    }

    public CommandPrompt(String p)
    {
        m_prompt = p;
        m_kb = new Scanner(System.in);
    }

    public void run()
    {
        for (;;) {
            System.out.printf("%s>", m_prompt);
            String cmd = m_kb.nextLine().trim();

            String [] cmdInfo = cmd.split("[ \t]+");

            if (cmdInfo.length == 1) {
                if (cmdInfo[0].equals("quit"))
                    break;

                System.out.println("Geçersiz tek argümanlı komut");
                continue;
            }

            cmd = getCommand(cmdInfo[0]);
            doCommand(cmd, cmdInfo);
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
