# JNI

## 定义类

    package dev.xesam;

    public class Hello{

        static{
            System.loadLibrary("hello");
        }

        public static void main(String[] args){
            System.out.println("hello world");
            sayHello();
        }

        public static native void sayHello();
    }

## 编译类

    javah dev/xesam/Hello.java

## javah生成接口文件

    javah dev.xesam.Hello

得到 dev_xesam_Hello.h

## 实现生成的接口

dev_xesam_Hello.cpp：

    #include "dev_xesam_Hello.h"
    #include <stdio.h>

    JNIEXPORT void JNICALL Java_dev_xesam_Hello_sayHello(JNIEnv *, jclass){
        printf("%s\n", "Hello xesam");
    }

## 编译打包

    gcc -I/usr/local/lib/jdk/include/ -I/usr/local/lib/jdk/include/linux/ -fPIC -c dev_xesam_Hello.cpp

    打包so

    gcc -shared -Wl,-soname,libhello.so.1 -o libhello.so.1.0 dev_xesam_Hello.o

    cp libhello.so.1.0 libhello.so

## 将so加入java路径

    export LD_LIBRARY_PATH=`pwd`:$LD_LIBRARY_PATH

## 执行

    java dev.xesam.Hello

输出：

    hello world
    Hello xesam



