package org.csystem.samples.examsimulation;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulationApp {
    private String m_name;
    private int [][] m_grades;
    private double m_average;
    private double [] m_averages;

    private void fillGrades()
    {
        Random r = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.print("Sınıf sayısını giriniz:");
        int n = Integer.parseInt(kb.nextLine());

        m_grades = new int[n][];

        for (int i = 0; i < n; ++i) {
            System.out.printf("%d. sınıf öğrenci sayısını giriniz:", i + 1);
            m_grades[i] = ArrayUtil.getRandomArray(r, Integer.parseInt(kb.nextLine()), 0, 101);
        }
    }

    private void calculateAverages()
    {
        int numberOfStudents = 0;
        int totalGrades = 0;

        m_averages = new double[m_grades.length];
        for (int i = 0; i < m_grades.length; ++i) {
            int n = m_grades[i].length;

            int total = ArrayUtil.sum(m_grades[i]);

            m_averages[i] = (double)total / n;
            numberOfStudents += n;
            totalGrades += total;
        }

        m_average = (double)totalGrades / numberOfStudents;
    }

    public ExamSimulationApp(String lectureName)
    {
        m_name = lectureName;
    }

    public void displayAvarage()
    {
        System.out.printf("Average:%f%n", m_average);
    }

    public void displayAverages()
    {
        for (int i = 0; i < m_averages.length; ++i)
            System.out.printf("%d. sınıf not ortalaması:%f%n", i + 1, m_averages[i]);
    }

    public void displayGrades()
    {
        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d.sınıf notları:", i + 1);
            ArrayUtil.display(m_grades[i], 2);
        }
    }

    public void display()
    {
        System.out.printf("'%s' dersi raporu:%n", m_name);
        System.out.println("Notlar:");
        displayGrades();
        System.out.println("Ortalamalar:");
        displayAverages();
        System.out.printf("Okul Ortalaması:%f%n", m_average);
    }

    public void run()
    {
        fillGrades();
        calculateAverages();
    }
}
