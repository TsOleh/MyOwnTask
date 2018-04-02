package com.epam.lab;
import org.apache.log4j.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class Address {
    private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());
    @SomeFields
    String country;
    @SetValue
    String city;
    String street;
    @SomeFields
    int index;
    public Address(String country, String city, String street, int index) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.index = index;
    }
    public  void  showSomeFields(Object obj, Class addressClass)throws Exception{
        SomeFields someFields = SomeFields.class.getAnnotation(SomeFields.class);
        LOGGER.info(someFields.name);  //task3/ виводимо значення анотації @SomeFields на консоль
        Field[] myFields = addressClass.getDeclaredFields();
        for (Field fields: myFields) {
            if (fields.isAnnotationPresent(SomeFields.class)){
                LOGGER.info(fields.get(obj));  //task2/ виводимо поля позначені анотацією @SomeFields
            }
            if (fields.isAnnotationPresent(SetValue.class) ){
                String setNewValue="newCity";
                if(fields.getType().isInstance(setNewValue)) {//task5/  записуємо значення в поле, початково не знаючи його типу.
                    Object value = setNewValue;
                    fields.set(obj, value);
                    LOGGER.info("Значення змінене на " + fields.get(obj));
                }
            }
        }
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface SomeFields{
String name ="annotation value";
}
@Retention(RetentionPolicy.RUNTIME)
@interface SetValue {
}