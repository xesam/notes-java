##Member

According to The 《Java Language Specification, Java SE 7 Edition》, the members of a class are the inherited components of the class body including fields, methods, nested classes, interfaces, and enumerated types.
Since constructors are not inherited, they are not members.
This differs from the implementing classes of java.lang.reflect.Member.

###与java语言规范不同，java语言规范定义
class的member包含继承而来的：
1. fields
2. methods
3. nested classes
4. interfaces
5. enumerated types

*但是由于constructors不可继承，因此constructors不属于member*

但是在反射定义中，member包含

1. Constructor
2. Executable
3. Field
4. Method

