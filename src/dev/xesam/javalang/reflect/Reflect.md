
##反射
本质就是动态方法调用：
多态与反射的区别
多态的核心是“你是什么”
反射的核心是“你有什么”


##java反射的组成结构


##什么是反射？
  为什么要用反射？


##方法调用的过程
方法调用的过程
obj.fn()
相当于obj对象找到自己的fn方法，然后调用这个方法。（或者换用发送消息的说法也行）

这是源码级别的实现，在编译阶段会进行合法性检查。
换一种写法：
obj.invoke("fn");
继续
obj.find("fn").invoke()
使用java的形式就是
Method fn = obj.getClass().getDeclareMethod("fn");
fn.invoke(obj);

本质就是动态方法查找与调用。


##怎样找到一个方法？
1.java中的方法是什么样子的？
2.怎样找到一个方法？
3.怎样执行这个方法？





##乱七八糟
内省：学术化字眼

表征一个程序自身信息的数据 metadata，在面向对象中，叫做metaobjects.


怎样修改一个类的方法行为
1.动态修改类
2.元数据
3.intercession,


什么是metaobjects.
是不是就是语言构件

Class ，包含所有的信息

怎样查找一个方法？

obj.getClass() 与 Object.class
Class字面量(Class literals)是java中获取ClassObject的语法

null 表示没有参数，作用于空数据相同

一个方法的参数有几种：
1，基本类型 //怎么表示
2，对象
3，数组 //怎么表示
？，纯粹的接口 //怎么表示

The isPrimitive method returns true for void.class
void.class适用于返回值

怎么表示数组参数
getComponentType 只对数组有用，表示数组组件类型
Note the distinction between component type and ele-
ment type. For the array type int[][], the component type is int[] while the ele-
ment type is int
数组的组件是int[]，元素类型是int（这个是声明的类型）

数组也是对象？


##获取一个Class的类型

方法：
static方法的第一个参数可以忽略，传人null即可
For a method with no parameters, the second parameter may be either a zero-length array or null
返回值也是一个对象

遍历类层次：
获取接口（直接接口）
获取超类（直接超类）

obj.getClass()与Obj.class区别
obj可能是Obj的子类

怎么访问和修改字段？

类加载器
loadClass,findLoadedClass,findClass,definedClass


















