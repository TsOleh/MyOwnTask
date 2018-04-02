package com.epam.lab;

public class MainClass {
        public static void main(String[]src) throws Exception{
        Task_4_and_6 task_4_and_6 = new Task_4_and_6();
        //Task 2,3,5
        Address address = new Address("Ukraine","Lviv", "Zelena34/6",96534);
        address.showSomeFields(address, address.getClass());
        //Task_7();
        //task_4_and_6.invokeMethod();
    }
    public static void Task_7(){
        SomeClassA someClassA = new SomeClassA(5,"some value");
        SomeClassB someClassB = new SomeClassB();
        Task_7 task_7 = new Task_7();
        task_7.allInformation(someClassA);
        task_7.allInformation(someClassB);
    }
}
