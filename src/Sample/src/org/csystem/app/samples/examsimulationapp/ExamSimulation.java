package org.csystem.app.samples.examsimulationapp;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    private String m_examName;
    private int [][] m_grades;
    private double m_average;
    private double [] m_averages;
    private Scanner m_kb;

    private void getNumberOfClasses()
    {
        System.out.print("Şube sayısını giriniz:");
        m_grades = new int[Integer.parseInt(m_kb.nextLine())][];
    }

    private void fillGrades()
    {
        int numberOfClassess = m_grades.length;
        Random r = new Random();

        for (int i = 0; i < numberOfClassess; ++i) {
            System.out.printf("%d. şube öğrenci sayısı?", i + 1);
            int numberOfStudents = Integer.parseInt(m_kb.nextLine());
            m_grades[i] = ArrayUtil.getRandomArray(r, numberOfStudents, 0, 101);
        }
    }

    private void calculateAverages()
    {
        int totalNumberOfStudents = 0;
        int total = 0;

        m_averages = new double[m_grades.length];

        for (int i = 0; i < m_grades.length; ++i) {
            totalNumberOfStudents += m_grades[i].length;
            int sum = ArrayUtil.sum(m_grades[i]);
            total += sum;
            m_averages[i] = (double)sum / m_grades[i].length;
        }

        m_average = (double)total / totalNumberOfStudents;
    }

    public ExamSimulation(String name)
    {
        m_examName = name;
        m_kb = new Scanner(System.in);
    }

    public void displayGrades()
    {
        ArrayUtil.display(m_grades, 3);
    }

    public void displayReport()
    {
        System.out.printf("Dersin Adı:%s%n", m_examName);
        displayGrades();
        System.out.println("*************");

        for (int i = 0; i < m_averages.length; ++i)
            System.out.printf("%d. şube ortalaması:%f%n", i + 1, m_averages[i]);

        System.out.printf("Okul ortalaması:%f%n", m_average);
    }

    public void run()
    {
        getNumberOfClasses();
        fillGrades();
        calculateAverages();
        displayReport();
    }
}
