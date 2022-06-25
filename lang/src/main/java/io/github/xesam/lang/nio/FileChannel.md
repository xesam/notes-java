#FileChannel

nio2中的FileChannel被增强

##创建

FileChannel.open(path, EnumSet.of(StandardOpenOption.READ, StandardOpenOption.WRITE)))

或者

FileChannel fileChannel = (FileChannel)(Files.newByteChannel(path, EnumSet.of(StandardOpenOption.READ, StandardOpenOption.WRITE)))

##Mapping a Channel’s File Region Directly into Memory

FileChannel.map()

mode: Mapping a region into memory can be accomplished in one of three modes:

1. MapMode.READ_ONLY (read-only mapping; writing attempts will throw ReadOnlyBufferException),
1. MapMode.READ_WRITE (read/write mapping; changes in the resulting buffer can be propagated to the file and can be visible from other
programs that map the same file),
1. MapMode.PRIVATE (copy-on-write mapping;
changes in the resulting buffer can’t be propagated to the file and aren’t visible
from other programs).


• position: The mapped region starts at the indicated position within the file (non-negative).

• size: Indicates the size of the mapped region (0 ≤ size ≤ Integer.MAX_VALUE).

##MappedByteBuffer

直接内存映射的buffer，三个新方法：

1. force(): Forces the changed over buffer to be propagated to the originating file
2. load(): Loads the buffer content into physical memory
3. isLoaded(): Verifies whether the buffer content is in physical memory

##file copy

1. 用一个buffer手动中转
2. FileChannel.transferTo() 或者 FileChannel.transferFrom()，直接两个channel之间转移
3. FileChannel.map() 将file映射到内存，然后写入


