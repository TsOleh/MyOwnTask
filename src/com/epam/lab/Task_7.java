package com.epam.lab;
import org.apache.log4j.Logger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Task_7<T> {
    private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());
    public void allInformation(T obj){
        Class someType = obj.getClass();
        LOGGER.info("\nІмя клас: "+someType.getSimpleName());
        LOGGER.info("Суперклас: "+someType.getSuperclass());
        showFields(someType);
        showMethods(someType);
        showConstructors(someType);
    }
    public void showMethods(Class someType) {
        Method[] methods = someType.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("\nІмя метода: " + method.getName());
            System.out.println("Повертаючий тип: " + method.getReturnType().getSimpleName());
        }
    }
    public void showFields(Class someType){
        Field[] publicFields = someType.getDeclaredFields();
        for (Field field : publicFields) {
            Class fieldType = field.getType();
            LOGGER.info("\nІмя поля: " + field.getName());
            LOGGER.info("Тип: поля "+ fieldType.getName());
        }
    }
    public  void showConstructors(Class someType){
        Constructor[] constructors = someType.getConstructors();
        for (Constructor constructor : constructors) {
            LOGGER.info("\nІмя конструктора: "+constructor.getName());
            Class[] paramTypes = constructor.getParameterTypes();
            if (paramTypes.length==0)
                LOGGER.info("Конструктор без параметрів");
            for (Class paramType : paramTypes) {
                LOGGER.info("Тип параметру: "+paramType.getSimpleName());
            }
            System.out.println();
        }
    }
}
class SomeClassA{
    private int someNumber;
    private String someField;
    public SomeClassA(int someNumber, String someField) {
        this.someNumber = someNumber;
        this.someField = someField;
    }
    public SomeClassA() { }
}
class  SomeClassB extends SomeClassA{
    public  String someMethod(){
        return String.format("Method of SomeClassB");
    }
}
