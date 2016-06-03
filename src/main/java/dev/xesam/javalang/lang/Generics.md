##Subtyping and the Substitution Principle

We also say, trivially, that every type is a subtype of itself.

##Substitution Principle
Substitution Principle: a variable of a given type may be assigned a value of any subtype
of that type, and a method with a parameter of a given type may be invoked with an
argument of any subtype of that type.


In general, if a structure contains elements with a type of the form ? extends E , we can
get elements out of the structure, but we cannot put elements into the structure.

##2.4 The Get and Put Principle

The Get and Put Principle: use an extends wildcard when you only get values out of a
structure, use a super wildcard when you only put values into a structure, and don’t use
a wildcard when you both get and put.


#### 111

The exception proves the rule, and each of these rules has one exception. You cannot
put anything into a type declared with an extends wildcard—except for the value
null , which belongs to every reference type:

Similarly, you cannot get anything out from a type declared with a super wildcard—
except for a value of type Object , which is a supertype of every reference type:


#Detecting problems at compile time

Detecting problems at compile time rather than at run time brings two advantages, one
minor and one major. The minor advantage is that it is more efficient. The system does
not need to carry around a description of the element type at run time, and the system
does not need to check against this description every time an assignment into an array
is performed. The major advantage is that a common family of errors is detected by the
compiler. This improves every aspect of the program’s life cycle: coding, debugging,
testing, and maintenance are all made easier, quicker, and less expensive.


#泛型

1. 在编译器捕获更多的错误

#Generic Method Calls


#Multiple Bounds

public static <S extends Readable & Closeable,T extends Appendable & Closeable> void copy(S src, T trg, int size)















