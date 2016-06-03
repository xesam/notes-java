package dev.xesam.javalang.tools;

import javax.tools.*;
import java.io.IOException;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

/**
 * Created by xe on 14-11-20.
 */
public class CompilerTest {
    public static void main(String[] args) {
        test_3();
    }

    //检测有效的JavaCompiler
    public static void test_3() {
        ServiceLoader<JavaCompiler> compilers;
        compilers = ServiceLoader.load(JavaCompiler.class);
        System.out.println(compilers.toString());

        compilers.forEach((compiler) -> {
            System.out.println(compiler);
        });
    }

    public static void test_1() throws IOException {
        Process p = Runtime.getRuntime().exec("javac HelloWorld.java");
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (p.exitValue() == 0) {

        }
    }

    public static void test_2() {
        //tools.jar

//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run(null, null, null, args);

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(javaCompiler.run(System.in, System.out, System.err, "/home/xe/tmp/java/Prop.java"));


        //简单编译一个文件


        JavaFileObject j;
        FileObject fileObject;
        SimpleJavaFileObject simpleJavaFileObject;


//        javaCompiler.getSourceVersions()

        URLClassLoader urlClassLoader;

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager javaFileManager = javaCompiler.getStandardFileManager(diagnostics, null, null);
//        javaFileManager.list()
        javaFileManager.getJavaFileObjectsFromStrings(null);
        JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask(
                null,
                null,
                null,
                null,
                null,
                null
//                javaFileManager.get

        );
        compilationTask.call();

//        compilationTask

        try {
            javaFileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Diagnostic d : diagnostics.getDiagnostics()) {
            System.out.println(d);
        }


//        cl.loadClass("")

    }

}
