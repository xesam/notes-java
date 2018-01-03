package dev.xesam.jodd;

import jodd.props.Props;

import java.io.File;
import java.io.IOException;

/**
 * Created by xe on 17-12-29.
 */
public class PropsTest {
    public static void main(String[] args) {
        fn1();
        fn2();
        fn3();
    }

    public static Props getProps(String path) {
        Props props = new Props();
        try {
            File file = new File(Thread.currentThread().getContextClassLoader().getResource(path).getFile());
            props.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static void fn1() {
        Props props = getProps("jodd.props");

        String story = props.getValue("story");
        System.out.println(story);
    }

    public static void fn2() {
        Props props = getProps("jodd.props");

        System.out.println(props.getValue("section1.width"));
        System.out.println(props.getValue("section1.height"));
        System.out.println(props.getValue("section1.size"));
        System.out.println(props.getValue("section2.width"));
        System.out.println(props.getValue("section2.height"));
        System.out.println(props.getValue("section2.size"));
        System.out.println(props.getValue("width"));
        System.out.println(props.getValue("height"));
        System.out.println(props.getValue("size"));
    }

    public static void fn3() {
        Props props = getProps("jodd.props");

        System.out.println("===================active empty");
        System.out.println(props.getValue("db.url"));
        System.out.println(props.getValue("db.username"));
        System.out.println(props.getValue("db.url", "develop"));
        System.out.println(props.getValue("db.username", "develop"));
        System.out.println(props.getValue("db.url", "deploy"));
        System.out.println(props.getValue("db.username", "deploy"));

        props.setActiveProfiles("deploy");
        System.out.println("===================active deploy");

        System.out.println(props.getValue("db.url"));
        System.out.println(props.getValue("db.username"));
        System.out.println(props.getValue("db.url", "develop"));
        System.out.println(props.getValue("db.username", "develop"));
        System.out.println(props.getValue("db.url", "deploy"));
        System.out.println(props.getValue("db.username", "deploy"));
    }
}
