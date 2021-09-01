package org.csystem.samples.companyapp;

public class HumanResources {
    //...
    public void payInsurance(Employee e)
    {
        System.out.printf("Citizen Id:%s%n", e.getCitizenId());
        System.out.printf("Name:%s%n", e.getName());
        System.out.printf("Insurance Payment:%f%n", e.calculateInsurancePayment());
    }
}
