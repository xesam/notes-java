# RandomAccessFile
RandomAccessFile 的 mode

    r
    rw
    rwd
    rws

The "rwd" and "rws" modes ensure than any writes to a file located on a
local storage device are written to the device, which guarantees that critical
data isn’t lost when the operating system crashes. No guarantee is made
when the file doesn’t reside on a local device.

但是这两种模式会更慢。

随机读取的几个特征方法：

    long getFilePointer()
    void seek(long pos)
    int skipBytes(int n)

## FileDescriptor

When a file is opened, the underlying operating system creates an operating
system-dependent structure to represent the file. A handle to this structure
is stored in an instance of the java.io.FileDescriptor class, which getFD()
returns.

两个方法：

    sync()

    valid()


