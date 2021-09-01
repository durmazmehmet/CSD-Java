package org.csystem.samples.parserapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileSource implements ISource {
    private BufferedReader m_br;

    public FileSource(String filePath)
    {
        try {
            m_br = new BufferedReader(new FileReader(filePath));
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    public int getChar()
    {
        int ch = -1;
        try {
            ch = m_br.read();
        }
        catch (IOException ex) {

        }

        return ch;
    }
}
