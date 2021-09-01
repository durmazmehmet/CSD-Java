/*----------------------------------------------------------------------------------------------------------------------
    abstract sınıf türünden bir nesne new operatörü ile yaratılamaz. new işlemi sınıf içerisinde de yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample(); //error

        s.foo();
    }
}

abstract class Sample {
    public abstract void foo();
    public abstract void tar();

    public void bar()
    {
        Sample s = new Sample(); //error
    }
}