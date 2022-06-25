重要的三个步骤：
1 Examine the program for its structure or data.
2 Make decisions using the results of the examination.
3 Change the behavior, structure, or data of the program based upon the
 decisions.

反射的定义：
Reflection is the ability of a running program to examine itself and its software
environment, and to change what it does depending on what it finds.
元数据，元对象和自省
To perform this self-examination, a program needs to have a representation of
itself. This information we call metadata. In an object-oriented world, metadata is
organized into objects, called metaobjects. The runtime self-examination of the
metaobjects is called introspection.
Reflection—introspection followed by behavior change


反射常见的API类型
In general, there are three techniques that a reflection API can
use to facilitate behavior change: 
1. direct metaobject modification
2. operations for using metadata (such as dynamic method invocation)
3. intercession

java限制
Java supplies a rich set of operations for using metadata and just a few important intercession capabilities. 
In addition, Java avoids many complications by not allowing direct metaobject modification.

反射是强大的，但不是万能的，阻止反射广泛运用的三个主要原因：
1. security
2. code complexity
3. runtime performance

反射就像照镜子一样，你可以了解自身的穿着和行为是否得体。
Similarly, in order to introspect, a program must have access to a representa-
tion of itself. This self-representation is the most important structural element of a
reflective system. By examining its self-representation, a program can obtain the
right information about its structure and behavior to make important decisions

Meta解说

We refer to
objects that are part of a program’s self-representation as metaobjects. Meta is a
prefix that usually means about or beyond.

Class and Method are classes whose instances represent the program. We refer
to these as classes of metaobjects or metaobject classes. Metaobject classes are most of
what make up Java’s reflection API.

We refer to objects that are used to accomplish the main purposes of an appli-
cation as base-level objects
We refer to the nonreflective parts of a program as the base program

方法参考
public final native Class<?> getClass();

类只是java.lang.Class的一个实例而已
反射通常由这个方法开始。

Class objects provide programming metadata about a class’s fields, methods,
constructors, and nested classes. Class objects also provide information about the
inheritance hierarchy and provide access to reflective facilities


Class literals are Java’s way to specify a class object statically. Syntactically, any class
name followed by .class evaluates to a class object

Class通过自省获取方法的几种方法：
方法参考
Method getMethod ( String name, Class[] parameterTypes )
//获取指定方法名和签名的public方法（声明的或者继承的）
Method[] getMethods () 
//获取所有的公开方法
Method getDeclaredMethod ( String name,  Class[] parameterTypes ) 
//获取指定方法名和签名的方法，不论是public或者private方法。methods explicitly declared by a class，does not include methods that the class inherits
Method[] getDeclaredMethods () 
//获取所有的声明方法，不论是public或者private方法

类型识别

Java reflection uses instances of Class to represent types
For example, getMethod from listing 1.1 uses an array of Class to indicate the types of the parameters of the desired method
This seems fine for methods that take objects as parameters, but what about types
not created by a class declaration?

Methods defined by Class that deal with type representation
方法参考
String getName() Returns the fully qualified name of the target Class object
Class getComponentType() If the target object is a Class object for an array, returns the Class object representing the component type
boolean isArray() Returns true if and only if the target Class object represents an array
boolean isInterface() Returns true if and only if the target Class object represents an interface
boolean isPrimitive() Returns true if and only if the target Class object represents a primitive type or void

Java represents primitive, array, and interface types by introducing class objects to
represent them. These class objects cannot do everything that many other class
objects can. For instance, you cannot create a new instance of a primitive or inter-
face. However, such class objects are necessary for performing introspection

表征基本类型
Although primitives are not objects at all, Java uses class objects to represent all eight primitive types。to specify type int, use int.class
A class object that represents a primitive type can be identified using isPrimitive

关于void关键字
The keyword void is not a type in Java,void.class is used to indicate that a method returns no value

表征接口
The addAll method of Vector takes an implementation of the Collection interface as an
argument. Querying the Vector class for its addAll method can be written as
Method m = Vector.class.getMethod( "addAll", new Class[] {Collection.class} );

The isInterface method of Class can be used to identify class objects that represent interfaces

表征数组
Java arrays are objects, but their classes are created by the JVM at runtime. A new
class is created for each element type and dimension. Java array classes implement
both Cloneable and java.io.Serializable.
Class literals for arrays are specified like any other class literal. For instance, to
specify a parameter of a single-dimension Object array, use the class literal
Object[].class. A query of the Vector class for its copyInto method is written as
Method m = Vector.class.getMethod( "copyInto", new Class[]{Object[].class} );
Class objects that represent arrays can be identified using the isArray method of
Class. The component type for an array class can be obtained using getCompo-
nentType. Java treats multidimensional arrays like nested single-dimension arrays.
Therefore, the line
int[][].class.getComponentType()
evaluates to int[].class. Note the distinction between component type and ele-
ment type. For the array type int[][], the component type is int[] while the ele-
ment type is int.

关于方法对象Method
Method is the type of the result of all of the method queries
Each Method object provides information about a method including its name,
parameter types, return type, and exceptions. A Method object also provides the
ability to call the method that it represents

方法参考
Class getDeclaringClass() 
//Returns the Class object that declared the method represented by this Method object
Class[] getExceptionTypes() 
//Returns an array of Class objects representing the types of the exceptions declared to be thrown by the method represented by this Method object
int getModifiers()
//Returns the modifiers for the method represented by this Method object encoded as an int
String getName() 
//Returns the name of the method represented by this Method object
Class[] getParameterTypes() 
//Returns an array of Class objects representing the formal parameters in the order in which they were declared
Class getReturnType() 
//Returns the Class object representing the type returned by the method represented by this Method object
Object invoke(Object obj, Object[] args) 
//Invokes the method represented by this Method object on the specified object with the arguments specified in the Object array

方法的动态调用
静态方法特点
the first parameter is ignored because static
methods do not need invocation targets. For a static method, null can be sup-
plied as the first argument to invoke without causing an exception

第二个参数
For a method with no parameters, the second parameter may be either a zero-length array or null

动态调用中的基本类型
primitives need to be wrapped when passed into a dynamic invocation and unwrapped when received as a return value
书中的这一观点是有问题的，应该是版本太老的缘故，java的新规范中传参并不需要对基本类型进行包装，但是返回值是需要类型转换的。因为invoke方法返回的是Object，无法确认作者的意图。

避免调用时的缺陷
This is not the case. In Java, each method is identified by both its signature and its declaring class
常见错误
If the class calling
invoke does not have appropriate access privileges for the method, invoke throws
an IllegalAccessException. For example, this exception can occur when
attempting to invoke a private method from outside its declaring class

IllegalArgumentException can be thrown by invoke under several circum-
stances. Supplying an invocation target whose class does not support the method
being invoked causes an IllegalArgumentException. Supplying an args array of
incorrect length or with entries of the wrong type also causes an IllegalArgument-
Exception. If any exception is thrown by the method being invoked, that excep-
tion is wrapped in an InvocationTargetException and then thrown

探索继承层次
可以通过递归获取到继承层次上的所有方法，但是需要注意的是访问权限的问题，比如，子类没有权限访问父类的private方法。
Methods of Class that deal with inheritance
方法参考
Class[] getInterfaces() 
//Returns an array of Class objects that represent the direct superinterfaces of the target Class object
Class getSuperclass() 
//Returns the Class object representing the direct superclass of the target Class object or null if the target represents Object, an interface, a primitive type, or void
boolean isAssignableFrom( Class cls ) 
//Returns true if and only if the class or interface represented by the target Class object is either the same as or a superclass of or a superinterface of the specified Class parameter
boolean isInstance( Object obj )
//Returns true if and only if the specified Object is assignment-compatible with the object represented by the target Class object

The getInterfaces method returns class objects that represent interfaces. When
called on a class object that represents a class, getInterfaces returns class objects
for interfaces specified in the implements clause of that class’s declaration. When
called on a class object that represents an interface, getInterfaces returns class
objects specified in the extends clause of that interface’s declaration

获取所有方法必须要遍历，但是判断继承层次却提供了更简便的方法。
To get all of the methods of a class, a program must walk the inheritance hier-
archy. Luckily, this walk is not necessary to query whether a class object represents
a subtype of another class object. This query can be accomplished using the isAs-
signableFrom method

某些特点说明
Class is Java’s only metaclass
《Putting Metaclasses to Work》

所有的对象都有一个实例化它的类，所有的类都是Object的子类

The metaobject classes Class and Method represent the classes and methods
of running programs. Other metaobjects represent the other parts of the pro-
gram such as fields, the call stack, and the loader. Class has additional methods
to support these other metaobjects. Querying information from these metaob-
jects is called introspection

个人理解：
自省 + 字段修改和动态方法调用

字段

As we saw with method introspection, Class defines two kinds of introspection
for accessing fields. The getDeclaredField and getDeclaredFields methods
query from the set of fields declared by the class, irrespective of visibility. The get-
Field and getFields methods query from the set of public fields declared and
inherited by the class
方法参考：
Field getField( String name) 
//Returns a Field object that represents the specified public
                            member field of the class or interface represented by this
                           Class object
Field[] getFields() 
//Returns an array of Field objects that represents all the
                   accessible public fields of the class or interface represented
                  by this Class object
Field getDeclaredField( String name ) 
//Returns a Field object that represents the specified
                                     declared field of the class or interface represented by this
                                    Class object
Field[] getDeclaredFields() 
//Returns an array of Field objects that represents each
                           field declared by

Querying for fields can
be disabled in the Java security manager. If this feature is disabled, all of these
methods throw a SecurityException

A Field metaobject represents a particular field of a
class. Each Field metaobject provides metadata about the field’s name, declar-
ing class, and modifiers. Field also provides several methods for getting and set-
ting values


判断字段或者方法的限定符

关于Member
Both Method and Field implement the interface java.lang.reflect.Member

方法参考
Methods declared by the interface Member
Class getDeclaringClass() 
//Returns the Class object that declared the member
String getName() 
//Returns the name of the member
int getModifiers() 
//Returns the modifiers for the member encoded as an int

Syntactically, there are eleven modifiers in Java:
1.public
2.volatile
3.synchronized
4.final
5.static
6.protected
7.strictfp
8.transient
9.native
10.abstract
11.private

Modifier有12个静态方法来检测这些限定符，因为多了一个 boolean isInterface( int mod ) 
比如：Modifier.isFinal(testField.getModifiers())

Modifier的借口问题：
System.out.print( Modifier.toString( Member.class.getModifiers() ) );
打印结果是：
public abstract interface
This result may be surprising, but it is consistent with the Interface Modifiers section of the 《Java Language Specification》 which states, “Every
interface is implicitly abstract. This modifier is obsolete and should not be used in new programs.”

AccessibleObject是Method和Field的父类
The class java.lang.reflect.AccessibleObject is the parent class of both
Field and Method. AccessibleObject introduces a method called setAccessible
that suppresses or enables runtime access checking. For field of type Field,
field.setAccessible(true);
disables all runtime access checks on uses of the metaobject referred to by field.
This allows reflective access to its value from outside the scope of its visibility
A parameter of false reenables the runtime access checks
示例代码：

if (!Modifier.isPublic(field.getModifiers())) {
field.setAccessible(true);
}
Object value = field.get();

方法参考：
Methods defined by AccessibleObject
void setAccessible( boolean flag ) 
//Sets the accessible flag of the target object to the value of the argument
boolean isAccessible() 
//Returns true if and only if the value of the accessible flag of the target object is true
static void setAccessible( AccessibleObject[] array, boolean flag ) 
//Sets the accessible flags for each element of an array of accessible objects

关于数组字的问题
Primitive arrays cannot be cast to Object[]
Java provides
java.lang.reflect.Array as a convenience facility for performing reflective operations on all array objects



Loading classes at runtime
■ Instantiating objects using reflection
■ Enhancing delegation with reflection

动态载入类
Class cls = Class.forName(dbClassName);
The convenience method Class.forName returns a class object given a fully qualified class name

比如
Class cls = Class.forName("com.xesam.study.reflect.SuperClass");

Class.forName ensures that the class is loaded and returns a reference to the
class object. This is accomplished by using a class loader, typically the one associ-
ated with the class of the object that called forName (chapter 6 explains this in
much greater detail). The class loader may have already loaded the class. If so, the
class loader merely returns the class object that was loaded earlier.
If the class has not already been loaded, the system class loader typically
searches the classpath for the appropriate .class file. If a file is found, the byte-
codes are read and the loader constructs a class object. If the file is not found, the
loader throws a ClassNotFoundException.


Getting array classes
示例：载入一维数组
Class cls = Class.forName("[Ljava.lang.String;");

Primitives and forName
暂时无解
Class objects for primitives cannot be retrieved using forName. The line
Class.forName(char.class.getName());
produces a ClassNotFoundException. It is unclear why forName was implemented
this way. However, from the many postings on the newsgroups, this seems to be
very frustrating for developers. When you need forName to handle primitive
classes as well, our suggestion is to write a convenience method that calls forName
but checks for primitive types when catching a ClassNotFoundException.

载入类之后的构造方法

类载入完成之后，静态变量可以直接使用。
The newInstance method of Class creates a new instance of the class represented
by the class object. Calling this method is equivalent to calling the class’s construc-
tor with no arguments
If a failure occurs inside the constructor, newInstance
throws an InstantiationException. If the visibility of the no-argument construc-
tor makes it inaccessible from the calling context, newInstance throws an
IllegalAccessException.

使用构造方法

The getConstructor method allows code to query for a public constructor that
takes specific parameter types. For example, the command
cls.getConstructor( new Class[] {String.class, String.class} )
introspects for a constructor that takes two String parameters. 

方法参考
Constructor getConstructor(Class[ ] parameterTypes ) 
Constructor getDeclaredConstructor( Class[ ] parameterTypes ) 
Constructor[] getConstructors() 
Constructor[] getDeclaredConstructors() 

注意，构造方法也是方法，所以不存在NoSuchConstructorException异常，同样都是NoSuchMethodException
If there is no constructor declared for the parameter list specified, getCon-
structor and getDeclaredConstructor throw the NoSuchMethodException.
Although you might expect a NoSuchConstructorException, this exception does
not exist in Java. If this kind of introspection has bee

Constructor类具有的方法
Constructor is the class of metaobjects that represents Java constructors. The
interface to Constructor is very much like the interface to Method, except it sup-
ports a newInstance method instead of invoke

The newInstance method of Constructor responds the same way as the new-
Instance method of Class

Constructor，Method，Field的共同之处。

Constructor implements the Member interface similarly to both Method and
Field. Constructor is also a subclass of AccessibleObject. Although a call to
newInstance is subject to throwing IllegalAccessException, setAccessible can
be used to disable those checks. At this point, all of the metaobject classes imple-
menting Member have been covered

构造数组
Constructing arrays reflectively
One version of Array.newInstance allows you to specify a component type and
a length in one dimension. 
一维数组
The line
Array.newInstance(String.class, 5);
returns a String array of length 5 with all elements initialized to null

多维数组
第一种方式
If the component type is a scalar, as shown here, the call results in a one-dimensional array.
If the component type is an array class, the call results in an array with one more
dimension than the component type. For example,
Array.newInstance(String[].class, 5);
constructs an array of String arrays of length 5.
第二种方式
The other version of Array.newInstance takes an int array parameter that spec-
ifies length in several dimensions. The line
Array.newInstance(String.class, new int[] {2, 3});
constructs a two-dimensional String array. The top-level array is a length-two
array of String arrays with each component initialized to an array of String of
length 3. Each second-level array has its elements initialized to null. 

载入类的设计。

比较好的设计方法是，只使用默认的构造方法。用实例方法来进行相应的初始化。
A subtle design issue involving a choice of constructors arises in writing classes to
be dynamically loaded. A good design technique is to implement only the default
constructor and use instance methods for object initialization.

带参数构造方法的局限性
子类在继承的时候可能没有与反射相适应的构造方法。

使用接口方式的优势：
1.Defining initialize with the correct signature is enforced by the Java language. This enforcement eliminates some programming mistakes about constructor signatures allowed by the first alternative.
2.Subclasses of Parrot implementations inherit initialize. No override to initialize is necessary except where additional initialization is needed.
3.Subclasses of Parrot implementations automatically have a default constructor. No additional constructor code is necessary.

但是使用构造方法的形式可以保证对象被初始化，使用接口的方式需要检测对象的初始化。
Constructors with parameters
can ensure that instances are properly initialized. The second alternative allows
construction of objects that are not ready for use. The implementor may need to
write additional code to guard against the use of uninitialized objects. However,
experience shows that in most cases, the second alternative reduces overall com-
plexity for dynamically loaded classes

Implementing deserialization


java代理
java Proxy
关于Intercession

he Java reflection API contains a dynamic proxy-creation facility,
java.lang.reflect.Proxy. This class is part of Java reflection because Proxy is
Java’s only way of approximating method invocation intercession. Let’s dissect the
previous phrase. Intercession is any reflective ability that modifies the behavior of
a program by directly taking control of that behavior. Method invocation interces-
sion is the ability to intercept method calls. The intercepting code can determine
the behavior that results from the method call.

We say approximating because Java does not support reflective facilities for inter-
ceding on method calls. Therefore, we must use proxies as an approximation.

Exploring Proxy

Each class constructed by these factory methods is a public final subclass of Proxy,
referred to as a proxy class. We refer to an instance of one of these dynamically
constructed proxies as a proxy instance. We call the interfaces that the proxy class
implements in this way proxied interfaces. A proxy instance is assignment-
compatible with all of its proxied interfaces.
创建一个proxy实例：
Proxy cl = getProxyClass( SomeInterface.getClassLoader(), Class[]{SomeInterface.class} );
Constructor cons = cl.getConstructor( new Class[]{InvocationHandler.class} );
Object proxy = cons.newInstance( new Object[] { new SomeIH( obj ) } );
或者简化为一条语句：
Object proxy = Proxy.newProxyInstance( SomeInterface.getClassLoader(), Class[]{SomeInterface.class}, new SomeIH( obj ) );

Proxy allows programmers to accomplish the delegation task by providing the
InvocationHandler interface. Instances of InvocationHandler, also referred to as
invocation handlers, are objects that handle each method call for a proxy
instance. Invocation handlers are also responsible for holding any references to
targets of the proxy instance
InvocationHandler接口：
public interface InvocationHandler {
	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable;
}

Proxy的实例也是对象，这就引出了一个问题，从Object继承过来的方法要不要被代理：
A proxy instance is an object, and so it responds to the methods declared by
java.lang.Object. This raises the issue of whether or not these methods should
be handled by invoke. The issue is resolved as follows:
1. hashCode, equals, and toString are dispatched to the invoke method in the
same manner as any other proxied method.
2. If a proxied interface extends Cloneable, then the invocation handler does
   intercede on the invocations to clone. However, unless the proxied inter-
  face makes clone public, it remains a protected method.
3. If any proxied interface declares an override to finalize, then invocation
   handlers do intercede on calls to finalize.
4. Method intercession does not take place for the other methods declared by
   java.lang.Object. Consequently, these methods behave as expected for any
  instance of java.lang.Object. In other words, a call to wait on a proxy
 instance waits on the proxy instance’s lock, rather than being forwarded to
  an invocation handler.






































