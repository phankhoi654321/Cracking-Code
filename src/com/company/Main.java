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
//        System.out.println(permutation2("abc", "cga"));

        // Test change space to '20%'
        char[] ch = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
        char[] ch1 = {'t', 'h', 'e', ' ', 'd', 'o', 'g'};
        char[] chars = "   the dog   ".toCharArray();
        char[] chars1 = "the dog".toCharArray();
//        System.out.println(ch1);
//        System.out.println(ch);
//        System.out.println(chars);
//        replaceSpace(chars, chars.length);
//        replaceSpace(chars1, chars1.length);

        // Test Permutation Palindrome
        String a = "tact Coa oddgg";
        System.out.println(isPermutationOfPalindrome(a));


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
        if (str.length() > 128) return false;    // ma ASCII co 128 ky tu, lon hon 128 ky tu nghia la da lap lai

        boolean[] char_set = new boolean[128];      //xac dinh duoc chi dung 128 ky tu nen xac dinh kich thuoc cho array
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);            // tra ve vi tri cua ky tu thu i trong bang ASCII, vi du chu a trong bang ASCII la 97
//            System.out.println(val);
//            System.out.println(char_set[val]);
            if (char_set[val]) {                 // kiem tra neu tai vi tri 97 da co trong chuoi String chua, ban dau chua co nen char_set[var] = false
                return false;
            }
//            System.out.println(char_set[val]);
            char_set[val] = true;               // ban dau khi nhap vao khong co se co gia tri la false, sau khi nhap set ve true
//            System.out.println(char_set[val]);
//            System.out.println("##");

        }

        return true;

    }

    //Test Permutation
    //Solution 1
    static boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
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

    //Solution 2
    static boolean permutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
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
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }


    // Test Write a method to replace all spaces in a string with '%20'
    static void replaceSpace(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // indexNew is the length of new String, trueLength is the length of the old String
        // spaceCount * 2 : because already have space = ' ' in the old length, mean length for space already have 1 so instead *3 for '%20" we *2
        int indexNew = trueLength + spaceCount * 2;

        // check if the end of old string is the space or not, if have space will make the end of array
        if (trueLength < str.length) {
            str[trueLength] = '\0';     //END ARRAY: trueLength is the end index of old String, so make it the end of array of old String have the end is space
        }

        // Solution 1: backward
        char[] newArray = new char[indexNew];

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                newArray[indexNew - 1] = '0';        // str[i]: char of old string at index i => consider old string
                newArray[indexNew - 2] = '2';        // str[indexNew]: char of new string at new index => consider new string
                newArray[indexNew - 3] = '%';
                indexNew = indexNew - 3;        // -3 because already make for 3 new char
            } else {
                newArray[indexNew - 1] = str[i];
                indexNew--;
            }
        }
        System.out.println(newArray);

        // Solution 2: forward
//        char[] newArray = new char[indexNew];
//        int newArrayPosition = 0;
//
//        for (int i = 0; i < trueLength; i++) {
//            if (str[i] == ' ') {
//                newArray[newArrayPosition] = '%';
//                newArray[newArrayPosition + 1] = '2';
//                newArray[newArrayPosition + 2] = '0';
//                newArrayPosition = newArrayPosition + 3;
//            } else {
//                newArray[newArrayPosition] = str[i];
//                newArrayPosition++;
//            }
//        }
////        return newArray;      //https://stackoverflow.com/questions/10007631/write-a-method-to-replace-all-spaces-in-a-string-with-20
//        System.out.println(newArray);
    }



    //1.4 Palindrome Permutation
    // Is Strings with even length(after remove all non-letter) must have all even counts of characters.
    // Is Strings of an odd length must have exactly one character with an odd.
    // It's therefore sufficient to say that, to be a permutation of a palindrome, a string can have no more than one character that is odd.
    static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable02(phrase);
        return checkMaxOfOdd(table);
    }

    // getNumericValue of char z to a is 35 to 10
    static int[] buildCharFrequencyTable02(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharacterNumber02(c);
            if(x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    // check it must be a character from a to z, if not return -1
    static int getCharacterNumber02(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(val >= a && val <= z ) {
            return val - a;
        }

        return -1;
    }

    static boolean checkMaxOfOdd(int[] table) {
        boolean check = false;
        for (int count : table) {
            if(count % 2 == 1) {     // lan dau nhay vo bo qua va set check = true
                if(check) {
                    return false;
                }

                check = true;
            }
        }
        return true;
    }

}
