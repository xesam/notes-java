#File

几个平时不怎么用的方法。

## 创建临时文件

    static File createTempFile(String prefix, String suffix)

## JVM 退出的时候删除

    void deleteOnExit()

## 重命名

    boolean renameTo(File dest)

这个方法可能根据系统不同而不同，因此一定要检查返回值

## 修改文件权限

    setReadable
    setXXX
    setXXX
    ...

