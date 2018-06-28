package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        int[] a = {3, 5, 6, 2};
//        swapMinMax(a);
//        swapMinMaxBetter(a);
        //Test Unique
//        System.out.println("Test Is Unique");
//        isUniqueChars("ahshfgdfds");
//        System.out.println("####");
//        System.out.println(isUniqueChars("ketQua: " + "ahshfgdfds"));
        //Test is permutation
//        System.out.println(permutation("abc", "cga"));
        System.out.println(permutation2("abc", "cga"));



    }

    //Modular, page 79,80
    //Solution 1
    static void swapMinMax(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        int temp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = temp;
        System.out.println(array[maxIndex]);
        System.out.println(array[minIndex]);
    }

    //Solution 2

    static void swapMinMaxBetter(int[] array) {
        int minIndex = getMinIndex(array);
        int maxIndex = getMaxIndex(array);

        System.out.println("Min " + array[minIndex]);
        System.out.println("Max " + array[maxIndex]);


        swap(array, minIndex, maxIndex);

        System.out.println("####");
        System.out.println("Min " + array[minIndex]);
        System.out.println("Max " + array[maxIndex]);




    }

    static int getMinIndex(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    static int getMaxIndex(int[] array) {
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static void swap(int[] array, int minIndex, int maxIndex) {
        int temp = 0;
        temp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = temp;

        System.out.println("Min swap " + array[minIndex]);
        System.out.println("Max swap " + array[maxIndex]);
    }

    // Test is Unique Char
    // Thuat toan kiem tra xem trong chuoi String co ky tu lap lai hay ko
    // ahshfgdfds

    static boolean isUniqueChars(String str) {
        if(str.length() > 128) return false;    // ma ASCII co 128 ky tu, lon hon 128 ky tu nghia la da lap lai

        boolean[] char_set = new boolean[128];      //xac dinh duoc chi dung 128 ky tu nen xac dinh kich thuoc cho array
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);            // tra ve vi tri cua ky tu thu i trong bang ASCII, vi du chu a trong bang ASCII la 97
//            System.out.println(val);
//            System.out.println(char_set[val]);
            if(char_set[val]) {                 // kiem tra neu tai vi tri 97 da co trong chuoi String chua, ban dau chua co nen char_set[var] = false
                return false;
            }
//            System.out.println(char_set[val]);
            char_set[val] = true;               // ban dau khi nhap vao khong co se co gia tri la false, sau khi nhap set ve true
//            System.out.println(char_set[val]);
//            System.out.println("##");

        }

        return true;

    }

    static boolean permutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        } else {
            return sort(s1).equals(sort(s2));
        }


    }

    static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    static boolean permutation2(String s1, String s2){
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[128];
        char[] s1_array = s1.toCharArray();
        
        for (char c : s1_array) {
            System.out.println(c);
            System.out.println(letters[c]);

            letters[c]++;
            System.out.println("###");
            System.out.println(letters[c]);
        }

        System.out.println("------");

        for (int i = 0; i < s2.length(); i++) {
            int c = (int) s2.charAt(i);

            System.out.println(c);
            System.out.println(letters[c]);
            letters[c]--;
            System.out.println("###");
            System.out.println(letters[c]);
            if(letters[c] < 0) {
                return false;
            }
        }

        return true;
    }







}
