1.byte
关于byte的转换/java7
byte b1 = 1; //正确
byte b2 = 2; //正确
byte b3 = b1 + b2; //错误，窄化无法保证兼容性
byte b3 = (byte) (b1 + b2); //正确
byte b4 = 1 + 2; //正确

byte的用处：
在虚拟机中，单个byte会占用4个字节，但是byte[]的占用空间会进行处理，完全按照1个byte占用1个字节来处理，因此，使用byte[]会比较节省空间。

short
使用场景，节约内存

char
char占有两个字节（java使用unicode编码），如果使用InputStream来读取输入，那么可以这么做：
int b1 = in.read();
int b2 = in.read();
char c = (char) (b1*256 + b2);
将连续的两个字节组合成一个字符。

缺点:
需要区分哪个字节属于前一个字符，哪一个字节属于后一个字符，不然会错误的把分属于不同字符的字节读取到一起了。

int
在java8以及以后，可以用来表示无符号的整数。

long
在java8以及以后，可以用来表示无符号的长整数。

float
不应该用于精确数值

double
不应该用于精确数值

基本类型的默认值：

Data Type	Default Value (for fields)
byte	0
short	0
int	0
long	0L
float	0.0f
double	0.0d
char	'\u0000'
boolean	false
附加一个：
String (or any object)  	null

一个说明：
对于局部变量，如果在声明的时候没有赋值，编译器也是不会自动赋予默认值的。

字面量：
在java7之后，可以使用二进制字面量整数赋值,并且可以在数字中使用下划线

几个特殊的字面量：
null
x.class



