#buffer

buffer的特点

In the NIO library, all data is handled with buffers. When data is read, it is read directly into a buffer.
When data is written, it is written into a buffer. Anytime you access data in NIO, you are pulling it out of the buffer.


###几个特征参数

1. Limit:表示缓冲区的当前终点，不能对缓冲区超过极限的位置进行读写操作。(逻辑有效容量)
1. Position:下一个要被读或写的元素的索引，每次读写缓冲区数据时都会改变改值，为下次读写作准备
1. Capacity:可以容纳的最大数据量；在缓冲区创建时被设定并且不能改变。（物理有效容量）

position <= limit <= capacity

###flip()

向buffer里面写完数据之后，为从缓冲区取出数据做准备，实际效果：

    capacity = capacity
    limit = position
    position = 0

###rewind()

为从缓冲区重新取出数据做准备，实际效果：

    capacity = capacity
    limit = limit
    position = 0

###clear()

为重新向缓冲区取出数据做准备，实际效果：

    capacity = capacity
    limit = capacity
    position = 0

###mark() & reset()

标记一个position,为从缓冲区重新取出部分数据做准备：

    0 <= mark <= position

###compat()

如果只是从缓冲区读取了一部分数据，希望下一次写入之后，再接着读取，就可以先压缩一下当前缓冲区，效果如下：

    capacity = capacity
    limit = capacity
    //copy data
    position = limit - position

##随机读取方法

###The get() methods

1. byte get(); //Relative
1. ByteBuffer get( byte dst[] );//Relative
1. ByteBuffer get( byte dst[], int offset, int length );//Relative
1. byte get( int index ); //absolute

###The put() methods

1. ByteBuffer put( byte b );//Relative
1. ByteBuffer put( byte src[] );//Relative
1. ByteBuffer put( byte src[], int offset, int length );//Relative
1. ByteBuffer put( ByteBuffer src );//Relative
1. ByteBuffer put( int index, byte b );//absolute

##分配

A byte buffer can be direct or non-direct. The JVM will perform native I/O operations on direct buffers.

Direct buffers

Direct buffers are created by using the allocateDirect() method,

non-direct buffers are

non-direct buffers are created by using the allocate() method.


