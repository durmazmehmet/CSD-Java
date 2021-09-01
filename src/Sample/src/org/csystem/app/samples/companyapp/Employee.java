package org.csystem.app.samples.companyapp;

public abstract class Employee {
    private String m_citizenId;
    private String m_name;
    private boolean m_married;

    public Employee(String citizenId, String name, boolean married)
    {
        //...
        m_citizenId = citizenId;
        m_name = name;
        m_married = married;
    }

    public String getCitizenId()
    {
        return m_citizenId;
    }

    public void setCitizenId(String citizenId)
    {
        m_citizenId = citizenId;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public boolean isMarried()
    {
        return m_married;
    }

    public void setMarried(boolean married)
    {
        m_married = married;
    }

    public abstract double calculatePayment();
}
