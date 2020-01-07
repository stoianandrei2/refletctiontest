package pack;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.BiFunction;
import java.util.function.Function;

class BadClass {
    public int a, b, c;

}

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        TestClass testClass = new TestClass();
        Field[] f = TestClass.class.getDeclaredFields();
        String secondFieldName = f[1].getName();
        try {
            Field secondField = TestClass.class.getDeclaredField(secondFieldName);
            secondField.setAccessible(true);
            Object fieldValue = secondField.get(testClass);
            System.out.println(fieldValue);
            secondField.set(testClass, "blablalba");
            fieldValue = secondField.get(testClass);
            if(fieldValue instanceof String) System.out.println("Field is string");
            System.out.println("Field is of type : "+secondField.getType().getName());
            System.out.println(fieldValue);




        } catch (NoSuchFieldException | IllegalAccessException e) {e.printStackTrace();};

        try {

            Method firstImpMethod = TestClass.class.getDeclaredMethod("printSomething", null);
            firstImpMethod.invoke(testClass);
        } catch (NoSuchMethodException e) {e.printStackTrace();} catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Method [] methods = PrintClass.class.getDeclaredMethods();
        PrintClass printClass = new PrintClass();

        for (int i = 0; i < 3; i++) {
            if (methods[i].getParameterCount() == 0) methods[i].invoke(printClass);
            else methods[i].invoke(printClass, 12);
        }

        Integer a = 12;
        Integer b = 2;
        BiFunction <Object, Object, Boolean> testSameClass = (obj1, obj2) -> {
          return  obj1.getClass().getName().equals(obj2.getClass().getName());
        };



    }


    }


