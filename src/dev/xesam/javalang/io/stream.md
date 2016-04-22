##什么是流（Stream）？
字节流[InputStream]——桥接[InputStreamReader]——>字符流[Reader]


## PipedOutputStream and PipedInputStream

线程间通信。（个人感觉没什么优势）

## FilterOutputStream and FilterInputStream

Byte array, file, and piped streams pass bytes unchanged to their
destinations. Java also supports filter streams that buffer, compress/
uncompress, encrypt/decrypt, or otherwise manipulate a stream’s byte
sequence (that is input to the filter) before it reaches its destination.



