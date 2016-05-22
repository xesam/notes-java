#Compiler API

##java开启进程

输入，编译，类加载器

一个并不是很常用的功能

##创建一个进程来显示调用javac命令编译



##Java 6 Compiler API

###简单编译一个或多个文件



###更完整的编译

方法签名

    CompilationTask getTask(Writer out,
                            JavaFileManager fileManager,
                            DiagnosticListener<? super JavaFileObject> diagnosticListener,
                            Iterable<String> options,
                            Iterable<String> classes,
                            Iterable<? extends JavaFileObject> compilationUnits);



1. 


2. 


3. 


主要特点，可以从内存中编译，以为者数据来源多样化

