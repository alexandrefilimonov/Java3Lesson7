package ru.geekbrains.Lesson7;
import java.util.Random;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class Array1and4 {
    protected int n;
    int [] a = new int [] {};

    public static void start(Class objClass, String strClassName) {
        //1.Run @BeforeSuite (if exists)
        try {
            boolean bBeforeSuiteExistsAsOneMethod = false;
            Method[] methods = objClass.getDeclaredMethods();
            for (Method o : methods) {
                if (o.getAnnotation(BeforeSuite.class) != null ) {
                    if (bBeforeSuiteExistsAsOneMethod)
                        bBeforeSuiteExistsAsOneMethod = false;
                    else {
                        bBeforeSuiteExistsAsOneMethod = true;
                        o.invoke(objClass);
                    }
                }
            }
            if (!bBeforeSuiteExistsAsOneMethod) throw new RuntimeException("A method with annotation BeforeSuite is not single!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.Run @Test
        try {
 
            Method[] methods = objClass.getDeclaredMethods();
			
            for (int iPriority=1; iPriority<=10; iPriority++) {
				
                for (Method o : methods) {
                    Test annotation = m.getAnnotation(Test.class);
                    //System.out.println( "value: " + annotation.value());
                    if (o.getAnnotation(Test.class) != null && (annotation.value()==iPriority)) {
                        o.invoke(objClass);
                    }
                }
				
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.Run @AfterSuite (if exists)
        try {
            boolean bAfterSuiteExistsAsOneMethod = false;
            Method[] methods = objClass.getDeclaredMethods();
            for (Method o : methods) {
                if (o.getAnnotation(AfterSuite.class) != null ) {
                    if (bAfterSuiteExistsAsOneMethod)
                        bAfterSuiteExistsAsOneMethod = false;
                    else {
                        bAfterSuiteExistsAsOneMethod = true;
                        o.invoke(objClass);
                    }
                }
            }
            if (!bAfterSuiteExistsAsOneMethod) throw new RuntimeException("A method with annotation AfterSuite is not single!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Array1and4(int n) {
        a = new int [n];
        Random r = new Random();
        for (int i=0; i<n; i++) {
            int j = r.nextInt(2);
            if (j==1) {
                a[i]=1;
            }
            else {
                a[i]=4;
            }
        }
    }

    @BeforeSuite
    public void emptyBeforeSuite() {
    }

    @Test (value = 2)
    public boolean exist1and4(int n) {
        boolean b1=false;
        boolean b4=false;
        for (int i=0; i<n; i++) {
            if (this.a[i]==1) {
                b1=true;
            }
            if (this.a[i]==4) {
                b4=true;
            }
        }
        if (b1 && b4) return true;
        else return false;
    }

    @AfterSuite
    public void emptyAfterSuite() {
    }
}
