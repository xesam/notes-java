package dev.xesam.jodd;

import jodd.props.Props;

import java.io.File;
import java.io.IOException;

/**
 * Created by xe on 17-12-29.
 */
public class PropsTest {
    public static void main(String[] args) {
        Props props = new Props();
        try {
            File file = new File(Thread.currentThread().getContextClassLoader().getResource("jodd.props").getFile());
            props.load(file);
            String story = props.getValue("story");
            System.out.println(story);
            System.out.println(props.getValue("local_users.data.width"));
            System.out.println(props.getValue("local_users.data.height"));
            System.out.println(props.getValue("local_users.data.size"));
            System.out.println(props.getValue("comment"));

            System.out.println(props.getValue("db.url"));
            System.out.println(props.getValue("db.username"));
            System.out.println(props.getValue("db.url", "develop"));
            System.out.println(props.getValue("db.username", "develop"));
            System.out.println(props.getValue("db.url", "deploy"));
            System.out.println(props.getValue("db.username", "deploy"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
