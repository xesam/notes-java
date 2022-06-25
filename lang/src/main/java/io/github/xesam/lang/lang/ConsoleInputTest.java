package io.github.xesam.lang.lang;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by xe on 14-11-19.
 */
public class ConsoleInputTest {
    public static void main(String[] args) {
        test_2();
    }

    public static void test_1() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test_2() {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextLine());
    }

    public static void test_3() {
        Console console = System.console();
        if(console != null){
            System.out.println(console.readLine());
//            System.out.println(console.readPassword());
        }
    }
}
