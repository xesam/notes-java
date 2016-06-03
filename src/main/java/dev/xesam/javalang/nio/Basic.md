##
Because I/O is fundamentally byte-oriented, only ByteBuffer instances can be used with channels


##nio vs io

A stream-oriented I/O system

A block-oriented I/O system

stream vs buffer(channel?)

io就像打开水龙头一样，打开就直接放水,但是水龙头的口径只有一个字节那么大，如果想要前进或者后退，只能先用桶把水装起来 Buffered

nio就像直接用桶一桶一桶的装水一样，

##Streams versus blocks
The most important distinction between the original I/O library (found in java.io.* ) and NIO has to do with how data is packaged and transmitted.
As previously mentioned, original I/O deals with data in streams, whereas NIO deals with data in blocks.


A stream-oriented I/O system deals with data one byte at a time. An input stream produces one byte of data, and an output stream consumes one byte of data. It is very easy to create filters for streamed data. It is also relatively simply to chain several filters together so that each one does its part in what amounts to a single, sophisticated processing mechanism. On the flip side, stream-oriented I/O is often rather slow.

A block-oriented I/O system deals with data in blocks. Each operation produces or consumes a block of data in one step. Processing data by the block can be much faster than processing it by the (streamed) byte. But block-oriented I/O lacks some of the elegance and simplicity of stream-oriented I/O.


##阻塞与非阻塞，同步与异步

1. 阻塞，同步


2. 非阻塞，同步


3. 阻塞，异步


4. 非阻塞，异步

## readiness selection



