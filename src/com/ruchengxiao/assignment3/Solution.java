package com.ruchengxiao.assignment3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution test = new Solution();
        //System.out.println(test.removeVowelsFromString("apple"));
        //System.out.println(test.checkIfTwoStringsAreAnagrams("zxcvbnm", "mnbvcxz"));
        Calculator test2 = new Calculator();
        //System.out.println(Arrays.toString(test2.doQuadraticEquation(1,1,-2)));
        System.out.println(checkIfTwoStringsAreAnagrams("system", "ysstem"));
    }

    //Problem 1
    /*
    public class Book{
          int size;
          int price;
          String name;
          public Book(int size){
              this.size = size;
          }
          public Book(int size, int price, String name){
              super(); // Error: the classBook does not extend superclass
              this.size = size;
              this.price = price;
              this.name = name;
          }
          public Book(int price){
              this.price = price;//Error: It is not allowed to have two constructors take same type parameter
          }
          public setName(String name){
              return name;//Error: setName should be this.name = name, what it writes is getName()
          }
     }
    */

    //Problem 2
    /*
    class Clock{
        String time;
        void getTime(){
            return time;//Error: Here is a return statement.
                        //However it does not have no type declaration in the method declaration sentence.
        }
        void setTime(String t){
            time = t ;
        }
    }
    */

    //Problem 3
    public static String removeVowelsFromString(String input){
        String result = "";
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> set = new HashSet<>();
        for (char vowel : vowels) {
            set.add(vowel);
        }

        for (int i = 0; i < input.length(); i++) {
            if (set.contains(Character.toLowerCase(input.charAt(i)))) {
                continue;
            }
            result = result.concat(String.valueOf(input.charAt(i)));
        }

        return result;
    }

    //Probem 4
    public static boolean checkIfTwoStringsAreAnagrams(String s1, String s2){
        if (s1 == null || s2 == null || s1.equals(s2)) {
            return false;
        }

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    //Problem 5
    static class Calculator {

        public double add(double number1, double number2) {
            return number1 + number1;
        }

        public double subtraction(double number1, double number2) {
            return number1 - number2;
        }

        public double mutiplication(double number1, double number2) {
            return number1 * number2;
        }

        public double division(double number1, double number2) {
            return number1 / number2;
        }

        public double squareRoot(double number) {
            return Math.sqrt(number);
        }

        public double square(double number) {
            return Math.pow(number, 2);
        }

        public double cube(double number) {
            return Math.pow(number, 3);
        }

        public double convertFtoC(double number) {
            return (number - 32) / 1.8;
        }

        public double convertCToF(double number) {
            return number * 1.8 + 32;
        }

        public double convertFeetToInch(double number) {
            return number / 12;
        }

        public double convertInchToFeet(double number) {
            return number * 12;
        }

        public double[] doQuadraticEquation(int a, int b, int c) {
            if (a == 0) {
                double[] result = new double[1];
                result[0] = (double) -c / b;
                return result;
            }

            int temp = b * b - 4 * a * c;
            if (temp == 0) {
                double[] result = new double[1];
                result[0] = (double) -b / (2 * a);
                return result;
            } else if (temp > 0) {
                double[] result = new double[2];
                result[0] = (double) (-b + Math.sqrt(temp)) / (2 * a);
                result[1] = (double) (-b - Math.sqrt(temp)) / (2 * a);
                return result;
            } else {
                return null;
            }

        }



    }


}
