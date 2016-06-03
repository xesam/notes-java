#SelectionKey

The interest set 感兴趣的事件集合
The ready set 准备就绪的事件集合

##操作类型

1. SelectionKey.OP_ACCEPT (acceptable): The associated client requests a connection (usually created on the server side for indicating that a client requires a connection).
1. SelectionKey.OP_CONNECT (connectable): The server accepts the connection
(usually created on the client side).
1. SelectionKey.OP_READ (readable): This indicates a read operation.
1. SelectionKey.OP_WRITE (writable): This indicates a write operation.


###G

##Selector

1. Selector.open(): 创建一个新的 selector.
1. Selector.select(): Selects a set of keys by performing a blocking selection operation.（阻塞）
1. Selector.select(t): Same as select, but the blocking is performed only for the specified milliseconds. If time expires and there is nothing to select, it returns 0.
1. Selector.selectNow(): Same as select, but with non-blocking selection operation. It returns 0 if there is nothing to select.（非阻塞）
1. Selector.selectedKeys(): Returns this selector’s selected key set as Set<SelectionKey>.
1. Selector.keys(): Returns this selector’s key set as Set<SelectionKey>.
1. Selector.wakeup(): Causes the first selection operation that has not yet returned to return immediately.（优雅的将当前selector的阻塞select终止）

##SelectionKey

1. SelectionKey.isValid(): Checks if the key is valid. A key is invalid if it is cancelled, its channel is closed, or its selector is closed.
1.  SelectionKey.isReadable(): Tests whether this key’s channel is ready for reading.
1.  SelectionKey.isWritable(): Tests whether this key’s channel is ready for writing.
1.  SelectionKey.isAcceptable(): Tests whether this key’s channel is ready to accept a new socket connection.
1.  SelectionKey.isConnectable(): Tests whether this key’s channel has either finished or failed to finish its socket connection operation.
1.  SelectionKey.cancel(): Requests that the registration of this key’s channel with its selector be cancelled.
1.  SelectionKey.interestOps(): Retrieves this key’s interest set.
1.  SelectionKey.interestOps(t): Sets this key’s interest set to the given value.
1.  SelectionKey.readyOps(): Retrieves this key’s ready-operation set.