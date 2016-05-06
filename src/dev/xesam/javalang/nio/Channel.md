##channel

A Channel is an object from which you can read data and to which you can write data. Comparing NIO with original I/O, a channel is like a stream.

各个通道都建立了，全部注册到选择器中，一旦有通道就绪了，就会给选择器发出通知，这样就可以实行监控了。


channel与stream的区别

1. You can both read and write to a Channels. Streams are typically one-way (read or write).
2. Channels can be read and written asynchronously.
3. Channels always read to, or write from, a Buffer.


并不是说线程数量越少越好，处理线程的问题，如果cpu有多个内核，那么保持线程的数量合适，比单一线程更有优势。


###Channel vs Stream

Channel是双向的.