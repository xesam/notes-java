#SeekableByteChannel

RAF：随机访问文件

A byte channel that maintains a current <i>position</i> and allows the position to be changed.

##创建

##StandardOpenOption

创建一个SeekableByteChannel的选项

    To write into a file that exists, at the beginning, use WRITE
    To write into a file that exists, at the end, use WRITE and APPEND
    To write into a file that exists and clean up its content before writing, use WRITE and TRUNCATE_EXISTING
    To write into a file that does not exist, use CREATE (or CREATE_NEW) and WRITE

##读取文件

##position() & position(long)

可以随机访问位置




