package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("введите 2 целых римских или арабских числа от 1 до 10: [5 + 1]/[I * X]");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(calc(str));

    }

    private static String toRoman(String arabNum) {
        String[] rom = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        String s = rom[Integer.parseInt(arabNum)];
        return s;
    }

    private static int toArab(String rom) {

        if (rom.equals("I")) {
            return 1;
        } else if (rom.equals("II")) {
            return 2;
        } else if (rom.equals("III")) {
            return 3;
        } else if (rom.equals("IV")) {
            return 4;
        } else if (rom.equals("V")) {
            return 5;
        } else if (rom.equals("VI")) {
            return 6;
        } else if (rom.equals("VII")) {
            return 7;
        } else if (rom.equals("VIII")) {
            return 8;
        } else if (rom.equals("IX")) {
            return 9;
        } else if (rom.equals("X")) {
            return 10;
        } else return -1;
    }

    public static String calc(String input) throws Exception {
        String[] input1 = input.split(" ");
        String result = " ";
        String romRes = " ";
        if (input1.length > 3)
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        else if (input1.length < 3) throw new Exception("т.к. строка не является математической операцией");
        else {
            try {

                input1[0] = String.valueOf(Integer.parseInt(input1[0]));
                input1[2] = String.valueOf(Integer.parseInt(input1[2]));

                if (Integer.parseInt(input1[0]) > 10 | Integer.parseInt(input1[2]) > 10 |
                        Integer.parseInt(input1[0]) < 1 | Integer.parseInt(input1[2]) < 1) {
                    throw new Exception("используются одновременно разные системы счисления, введите римские или арабские числа от 1 до 10");
                }


                switch (input1[1]) {
                    case "+":
                        result = Integer.toString(Integer.parseInt(input1[0]) + Integer.parseInt(input1[2]));
                        break;
                    case "-":
                        result = Integer.toString(Integer.parseInt(input1[0]) - Integer.parseInt(input1[2]));
                        break;
                    case "*":
                        result = Integer.toString(Integer.parseInt(input1[0]) * Integer.parseInt(input1[2]));
                        break;
                    case "/":
                        result = Integer.toString(Integer.parseInt(input1[0]) / Integer.parseInt(input1[2]));
                        break;
                    default:
                        throw new Exception("Введен неверный оператор");
                }
                return result;

            }catch (NumberFormatException e){
                input1[0] = String.valueOf(toArab(input1[0]));
                input1[2] = String.valueOf(toArab(input1[2]));
                if (Integer.parseInt(input1[0]) > 10 | Integer.parseInt(input1[2]) > 10 |
                        Integer.parseInt(input1[0]) < 1 | Integer.parseInt(input1[2]) < 1) {
                    throw new Exception("используются одновременно разные системы счисления, введите римские или арабские числа от 1 до 10");
                }

                switch (input1[1]) {
                    case "+":
                        result = Integer.toString(Integer.parseInt(input1[0]) + Integer.parseInt(input1[2]));
                        break;
                    case "-":
                        result = Integer.toString(Integer.parseInt(input1[0]) - Integer.parseInt(input1[2]));
                        break;
                    case "*":
                        result = Integer.toString(Integer.parseInt(input1[0]) * Integer.parseInt(input1[2]));
                        break;
                    case "/":
                        result = Integer.toString(Integer.parseInt(input1[0]) / Integer.parseInt(input1[2]));
                        break;
                    default:
                        throw new Exception("Введен неверный оператор");
                }

                try {
                    romRes = toRoman(result);
                }catch (Exception exe){
                    throw new Exception("т.к. в римской системе нет отрицательных чисел");
                }
                return romRes;
            }


        }

    }
}




