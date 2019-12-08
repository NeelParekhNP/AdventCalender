package com.example.adventcalender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventCalender {
    public static void main(String[] args) {
        dayTwo();
    }

    public static void dayOne(){
        try{
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);

            String input;
            int finalFuel = 0;
            while ((input = br.readLine()) != null){
                int fuel = 0;
                int tempFuel = 0;
                fuel = (Integer.parseInt(input)/3) - 2;
                tempFuel = fuel;
                while (tempFuel > 0){
                    tempFuel = (tempFuel/3) - 2;
                    if(tempFuel > 0){
                        fuel += tempFuel;
                    }
                }
                finalFuel += fuel;
            }
            br.close();
            System.out.println(finalFuel);
        } catch (IOException e){
            System.out.println("File not found");
        }
    }

    public static void dayTwo(){
        List<String> intCodeString = new ArrayList<>();
        List<Integer> intCode = new ArrayList<>();
        try{
            FileReader fr = new FileReader("input2.txt");
            BufferedReader br = new BufferedReader(fr);

            String input;
            while ((input = br.readLine()) != null){
                intCodeString = Arrays.asList(input.split("\\s*,\\s*"));
            }

            br.close();

        } catch (IOException e){
            System.out.println("File not found");
        }
        for(String num : intCodeString){
            intCode.add(Integer.valueOf(num));
        }

        for(int i=0; i<intCode.size()-1; i+=4){
            int a = intCode.get(intCode.get(i+1));
            int b = intCode.get(intCode.get(i+2));
            switch (intCode.get(i)){
                case 1:
                    intCode.set(intCode.get(i+3), (a+b));
                    //System.out.println(a);
                    //System.out.println(b);
                    //System.out.println(a+b);
                    break;

                case 2:
                    intCode.set(intCode.get(i+3), (a*b));
                    break;

                default:
                    System.out.println("Answer: " + intCode.get(0));
                    break;
            }
        }
    }
}
