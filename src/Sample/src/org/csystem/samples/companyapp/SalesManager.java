package org.csystem.samples.companyapp;

public class SalesManager extends Manager {
    private double m_extra;

    public SalesManager(String citizenId, String name, String address, double salary, String department, double extra)
    {
        super(citizenId, name, address, salary, department);
        m_extra = extra;
    }

    public double calculateInsurancePayment()
    {
        return super.calculateInsurancePayment() + m_extra;
    }


}
