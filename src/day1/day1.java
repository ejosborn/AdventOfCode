package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day1 {
    public static void main(String[] args) {
        String fileName = "src/day1/input.txt";
        System.out.print("Day1 part1: " + day1p1(fileName));
    }

    public static int day1p1(String fileName) {
        int sum = 0;
        List<Integer> listOfNums = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                char firstNum = ' ';
                char lastNum = ' ';

                for (char letter : line.toCharArray()) {
                    if (Character.isDigit(letter)) {
                        if (firstNum == ' ') {
                            firstNum = letter;
                        } else {
                            lastNum = letter;
                        }
                    }
                }

                if (lastNum == ' ') {
                    lastNum = firstNum;
                }

                listOfNums.add(Integer.parseInt("" + firstNum + lastNum));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int num : listOfNums) {
            sum += num;
        }

        return sum;
    }
}
