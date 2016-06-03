#java8新特性

##lamda表达式


##接口提供默认实现

    interface DefaultInterface {
        default int getInt() {
            return 1;
        }
    }
    
java8的接口中为什么要有default？

##多次使用同一个Annotation

以前的方式：

    #code

现在的方式：

    #code
    
##新的DATE-TIME接口
    
获取当前日期，时间

    code
    
从字符串获取日期时间：
    
    code
    
日期时间的计算：
    
    code
    
    
##Stream API

遍历集合：
    
    code
    
##对js的支持

Nashorn


##String

    
##格式化数值


##lamda表达式


