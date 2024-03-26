package xxx;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        String[] arr = {"1", "2", "3"};
        
        String word = "abc";
        String word2 = "bbb";
        
        
        int a = 10; 
         m3(a);
        System.out.println(a);
//        
//        String wodd= "abcbbb";
//
//        System.out.println(Arrays.toString(arr));
//
//        m1(arr);
////
//        System.out.println(Arrays.toString(arr));
////
//
//
//        Student student = new Student();
//
//        System.out.println(student.name);
//        System.out.println(student.age);
//
//        m2(student);
//
//        System.out.println(student.name);
//        System.out.println(student.age);

    }//main

    private static int m3(int a) {

    	a=7;
    	return a;
	}

	private static void m2(Student student) {

        student.name = "아무개";
        student.age = 30;                 

    }

    private static void m1(String[] arr) {

        arr[0] = "10";

    }

    private static class Student{

        public String name = "홍길동";
        public int age = 10;

    }
}