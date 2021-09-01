package org.csystem.app.samples.companyapp;

public class HumanResources {
    //...
    public void payInsurance(Employee e)
    {
        System.out.printf("Citizen Id:%s%n", e.getCitizenId());
        System.out.printf("Name:%s%n", e.getName());
        System.out.printf("Payment:%f%n", e.calculatePayment());
    }
}
