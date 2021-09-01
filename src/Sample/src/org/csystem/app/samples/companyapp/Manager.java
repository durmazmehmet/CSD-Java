package org.csystem.app.samples.companyapp;

public class Manager extends Employee {
    private String m_department;
    private double m_salary;

    public Manager(String citizenId, String name, boolean married, String department, double salary)
    {
        super(citizenId, name, married);
        m_department = department;
        m_salary = salary;
    }

    public String getDepartment()
    {
        return m_department;
    }

    public void setDepartment(String department)
    {
        m_department = department;
    }

    public double getSalary()
    {
        return m_salary;
    }

    public void setSalary(double salary)
    {
        m_salary = salary;
    }

    public double calculatePayment()
    {
        return m_salary * 30;
    }
}
