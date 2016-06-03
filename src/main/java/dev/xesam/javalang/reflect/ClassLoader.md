#ClassLoader

##在虚拟机中如何唯一确定一个类？

类加载器与类全名唯一标定一个类。

##类加载器的加载步骤：

1. loadClass(String name)[ ->findLoadedClass -> parent.loadClass()]
2. findClass()
3. defineClass()


注意问题：不要让待加载的类被系统类加载加载了,所以，不要显式的使用待加载的类(import)，也不要将待加载的类放在系统类路径上。


loadClass(String name)的注意事项
loadClass(String name)中的name会被当作Class<?> c = findLoadedClass(name);的参数来使用，如果同一个类加载机器第一次加载了类，但是name与class不对应的话，那么第二次再加载的时候，就会再次加载一个新的类，由于第一次已经存在一个同名的类，就会报错了。


###Class.forName(String name) 与 loadClass(String name)的不同之处：

loadClass(String name)只会加载一个类，而不会初始化一个类

Class.forName(String name)会同时初始化一个类，相当与loadClass(name, true)