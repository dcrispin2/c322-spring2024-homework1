package part2;

import java.util.Arrays;
import java.util.LinkedList;

public class Problems {
    public static int[] problem1(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){

            for (int j = 0; j < nums.length; j++){
                if (i != j){
                    if (nums[i] + nums[j] == target){
                        return new int[]{nums[i], nums[j]};
                    }
                }
            }
        }
        return new int[]{};
    }

    public static boolean problem2(int x){
        //turns the integer into a character array because we don't actually care what the numbers are -- just that the number can be reversed
        //easier to work with arrays in that way
        char[] comp = (x + "").toCharArray();
        char[] temp = comp.clone();

        int hLength = (int)Math.floor((comp.length) / 2.0);

        for (int i = 0; i < hLength; i++){
            char tmp = temp[i];
            temp[i] = temp[temp.length - i - 1];
            temp[temp.length - i - 1] = tmp;
        }

        return Arrays.equals(comp, temp);
    }

    public static String problem3(String[] input){
        //Set the first string as the baseline to check against (if it exists) -- avoids issues with empty arrays
        String output = "";
        if(input.length != 0) {output = input[0];}

        for (String str : input){
            while (!str.contains(output)) {
                //iterate through each string in the array, and if the current string does not contain our initial prefix it cuts off the last letter until
                //it becomes a prefix or is reduced to ""
                output = output.substring(0, output.length() - 1);

                if (output.equals("")) {return "";}
            }
        }
        //returns an empty string (if empty array) or the product of the while loop (either a string or an empty string)
        return output;
    }

    public static int problem4(String s){
        int num = 0;

        if (s.length() == 0) {return 0;}

        //Creates an int array for the raw values of each roman numeral + a nothing EOF value for use in the summation loop
        int[] numeral = new int[s.length() + 1];
        numeral[s.length()] = 0;

        //magic
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c) {
                case 'M' -> numeral[i] = 1000;
                case 'D' -> numeral[i] = 500;
                case 'C' -> numeral[i] = 100;
                case 'L' -> numeral[i] = 50;
                case 'X' -> numeral[i] = 10;
                case 'V' -> numeral[i] = 5;
                case 'I' -> numeral[i] = 1;
            }
        }

        for (int i = 0; i < s.length(); i++){
            int current = numeral[i];
            int next = numeral[i + 1];

            //If the current value is less than the next value (only ever happens in cases like IV, IX, etc. ex: {10, 100}) subtract the current from the next, add it to the sum num, and skip the next index
            if (current < next){
                num = num + (next - current);
                i++;
            }
            else {
                num = num + current;
            }
        }
        return num;
    }


    //uses an operator string to keep track of open brackets in the order they occur, removing them in order as valid closing brackets are read
    //using linkedlist would've worked better in retrospect
    public static boolean problem5(String input){
        if(input.length() < 2){return false;}

        String operator = "0" + input.charAt(0);

        for (int i = 1; i < input.length(); i++){
            char c = input.charAt(i);
            char p = operator.charAt(operator.length() - 1);

            switch (c) {
                case '(' -> operator = operator + "(";
                case '{' -> operator = operator + "{";
                case '[' -> operator = operator + "[";
                case ')' -> {
                    if (p == '(') {
                        operator = operator.substring(0, operator.length() - 1);
                    } else return false;
                }
                case '}' -> {
                    if (p == '{') {
                        operator = operator.substring(0, operator.length() - 1);
                    } else return false;
                }
                case ']' -> {
                    if (p == '[') {
                        operator = operator.substring(0, operator.length() - 1);
                    } else return false;
                }
            }
        }
        return operator.length() == 1;
    }

    public static LinkedList<Integer> problem6(LinkedList<Integer> list1, LinkedList<Integer> list2){
        list1.addLast(null);
        list2.addLast(null);
        LinkedList<Integer> output = new LinkedList<>();

        while (list1.getFirst() != null && list2.getFirst() != null){
            int int1 = list1.getFirst();
            int int2 = list2.getFirst();

            if (int2 <= int1){
                output.add(int2);
                list2.removeFirst();
            }
            else{
                output.add(int1);
                list1.removeFirst();
            }
        }

        if (list1.getFirst() == null){
            list2.removeLast();
            output.addAll(list2);
        }
        if (list2.getFirst() == null){
            list1.removeLast();
            output.addAll(list1);
        }

        return output;
    }

    public static int[] problem7 (int[] input){
        String intStr = "";
        for (int num : input){
            intStr = intStr + num;
        }
        int intNum = Integer.parseInt(intStr);
        intNum++;

        int[] output = new int[intStr.length()];

        String finalStr = intNum + "";
        for (int i = 0; i < finalStr.length(); i++){
            output[i] = Integer.parseInt(finalStr.substring(i, i + 1));
        }

        return output;
    }
}
