package dev.xesam.javalang.lang;

import java.util.Arrays;

/**
 * Created by xe on 14-10-27.
 */
public class LamdaTest {

    static interface Say1 {
        void say();
    }

    static interface Say2 {
        void say(String name);
    }

    public static void main(String[] args) {
        Say1 say = () -> {
            System.out.println("hello");
        };

        say.say();

        ((Say1) () -> {
            System.out.println("hello");
        }).say();

        Say2 say2 = name -> System.out.println("hello ".concat(name));
        say2.say("xesam");

        Player player = new Player();
        Play play = player::play;
        play.play();


        Integer[] ints = {3, 5, 7, 8, 51, 33, 1};
        Arrays.sort(ints, Integer::compare);

    }

    static interface Play {
        void play();
    }

    static class Player implements Play {
        public static void fn_1() {
            System.out.println("fn_1");
        }

        public static void fn_2(Object obj) {
            System.out.println("fn_2");
        }

        @Override
        public void play() {
            System.out.println("play");
        }
    }
}


