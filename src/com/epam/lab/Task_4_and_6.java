package com.epam.lab;
import org.apache.log4j.Logger;
import java.lang.reflect.Method;

public class Task_4_and_6 {
    private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());
    SomeMethods someMethods = new SomeMethods();
    Class aClass = someMethods.getClass();
        public void invokeMethod() throws Exception{
        invokeVolumeMethod();
        invokeAgeMethod();
        invokePerimeterMethod();
        invokeAverage();
        invokeEuropeanCountries();
    }
    public void invokeVolumeMethod() throws Exception{
        Class[] typesArguments1 = new Class[]{int.class,int.class,int.class};
        Method method1 = aClass.getMethod("takeVolumeMethod",typesArguments1);
        Object[]obj = new Object[]{6,8,12};
        LOGGER.info("The volume is "+method1.invoke(someMethods,obj));
    }
    public  void  invokeAgeMethod() throws Exception{
        Class[] typesArguments2 = new Class[]{String.class,int.class};
        Method method2 = aClass.getMethod("takeAgeMethod",typesArguments2);
        Object[]obj2 = new Object[]{new String("My name is Oleh. I'm "), 25};
        LOGGER.info(method2.invoke(someMethods,obj2));
    }
    public void invokePerimeterMethod()throws Exception{
        Class[] typesArguments3 = new Class[]{Double.class,Double.class,Double.class,Double.class,};
        Method method3 = aClass.getMethod("takePerimeterMethod",typesArguments3);
        Object[]obj3 = new Object[]{24.4,39.4,20.2,45.5};
        LOGGER.info("The perimeter is "+method3.invoke(someMethods,obj3));
    }
    public void invokeAverage() throws Exception{
        Class[] typesArguments = new Class[]{String.class, int[].class};
        Method method = aClass.getMethod("takeAverage",typesArguments);
        Object[]obj = new Object[]{new String("The average of numbers is "), new int[]{3,5,89,31,45,8,34}};
        LOGGER.info(method.invoke(someMethods,obj));
    }
    public void invokeEuropeanCountries() throws Exception{
        Class[] typesArguments = new Class[]{String[].class};
        Method method = aClass.getMethod("showEuropeanCountries",typesArguments);
        Object[]obj = new Object[]{new String[]{"Ukraine,", " Poland,", " Portugal,", " Vatican,", " Switzerland,"}};
        LOGGER.info(method.invoke(someMethods,obj));
    }
}
class SomeMethods{
    public int takeVolumeMethod(int x, int y, int z){
    return x*y*z;
    }
    public String takeAgeMethod(String someString, int age){
        return String.format("%s%d",someString,age);
    }
    public Double takePerimeterMethod(Double a,Double b,Double c,Double d ){
        return a+b+c+d;
    }
    public String takeAverage(String someString, int[] args){
       int average=0;
        for (int i=0;i<args.length;i++){
            average += args[i];
        }
        average = average/args.length;
        return String.format("%s%d",someString,average);
    }
    public String showEuropeanCountries(String[] someString){
        String massStrings = "Europeans countries: ";
        for (int i =0;i<someString.length;i++) {
            massStrings += someString[i];
        }
        return massStrings;
    }
}