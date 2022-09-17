### 排序、去重

    sorted
    distinct

### 截断

    skip
    limit
    


对于整个管道来说，窒息感模式只在终止操作开始执行时才确定下来，因此对其的控制并不属于作为管道创建的你。

## 终止管道

对流调用其中任何一个方法都会开始硫元素的计算。

### 搜索操作

匹配操作：

    anyMatch : 找到任意一个满足的就返回 true
    allMatch : 找到任意一个不满足的就返回 false
    noneMatch: 找到任意一个满足的就返回 false

*注意：在空的流上调用 allMatch 总是返回true*

find 操作：

    findFirst
    findAny  

对于无序流来说，这两个方法之间没有本质的差别。

### 汇聚

数字原生流（IntStream, LongStream, DoubleStream）：

    sum
    min
    max
    count
    average
    summaryStatistics
    
*如果你想对数据做一次遍历后得到多个结果，就可以使用 summaryStatistics 了*

引用流：

    min(Comparator<T>)
    max(Comparator<T>)
    count

收集流元素：

    collect(Collector<T, A, R>)

T 表示被收集的类型。
A 表示
R 表示结果容器的类型。

Collectors 的工厂方法：

    toSet
    toList
    toMap(Function<T,K>, Function<T, U>)
    toMap(Function<T,K>, Function<T, U>, BinaryOperator<U>)

*toMap：从 T 到 K 的键抽取函数，从 T 到 U 的值抽取函数*

如果存在键重复的情况，就使用 toMap 的第二个重载版本，来决定如何拼接这些重复键所对应的值。

所返回的 Set,List,Map 的具体实现，由框架决定。

### 副作用操作

    forEach(Consumer<T>) : 不保留顺序，也不保证操作的同步。
    forEachOrdered(Consumer<T>) : 保留顺序，线程安全。
    
    
## 终止流

广义上说，**汇聚**值的是返回单个值的操作，它以某种方式总结了流元素的值。

收集：可变汇聚。

收集器——提供器、聚积器、组合器。


### 收集器 

Collectors 提供的方法为两类：

1. 独立收集器。
2. 与其他收集器组合使用的收集器。

#### 独立收集器

1. 聚积到框架提供的容器中。
2. 聚积到自定义的集合中。
3. 将与那苏聚积到分类 Map 中。

相较于使用值抽取函数的 toMap 方法，groupingBy 放到 Map 中的值是元素本身。 

    groupingBy(Function<T, K>)

一个变种方法：

    partitioningBy(Predicate<T>)

相当于一个二分类方法。

#### 组合收集器

通过组合，我们可以将多个收集器或其他操作的结果组合起来创建新的收集器。

一种最为重要的形式是将 groupingBy 与 第 2 个“下游”收集器组合起来，默认的下游收集器是 Collectors.toList .

| 终止操作   | Collectors 工厂方法 |
| -------- | ---- | 
| count | counting | 
| reduce | reducing | 
| min | minBy | 
| max | maxBy | 
| sum | summingInt,summingLong,summingDouble | 
| average | averagingInt,averagingLong,averagingDouble | 
| summaryStatistics | summarizingInt,summarizingLong,summarizingDouble | 

Collectors.mapping 类比与流的 map 操作：

    mapping(Function<T, U>, Collector<U, A, R>)

TODO：链接管道的性能问题？

#### 收集器的构成

1. 创建新容器的函数。
2. 向已有容器添加单个元素的函数。
3. 将现有的多个容器组合起来的函数。


#### 并发收集

并行流处理中的性能瓶颈很有可能是上文的第 3 步，框架提供了一种选择：并发收集器。

    具备 Concurrent 特性的收集器。
    可以从多个线程中对相同的结果容器调用积聚器函数。
    这可以改进并发性能，代价则是丧失了流元素的顺序。
    
#### 自定义收集器

动机：

1. 将值积聚到并未实现 Collection 的容器中。
2. 积聚的过程需要在被手机的值之间共享状态。


#### 完成器

之所以需要完成函数，有下面几个原因：

1. 中间容器所返回的类型不正确。
2. 有些处理需要推迟到多有元素都可用时才行。
3. 结果要以规范形式返回。
4. 结果再返回前需要以某种形式“封装”起来。

#### 收集器的规则

框架可以确保的：

1. 新值只能作为积聚器的第 2 个参数，其他所有制都是之前从提供器、积聚器或组合器所返回的结果。
2. 来自提供器、积聚器与组合器的结果可以返回给 collect 的调用者，否则，他们将只能用作及崛起、组合器或完成其的参数。
3. 传递给组合器或完成器的没有返回的值永远不会再使用。他们的内容已经得到了处理，不应该再被使用。


收集器必须遵循的约束：

1. 除非具有特性 CONCURRENT ，否则收集器必须要确保从提供器、积聚器或组合器函数所返回的任何结果都是特定与某个线程的。
这样，收集器框架就可以进行并行处理而无需考虑外部线程的干扰。
2. 如果具有特性 CONCURRENT，那么积聚器必须时线程安全的，使用相同的并发可修改的结果容器，因为框架可能会从多个线程中并发调用它。
如果需要排序，那么就不能使用并发收集器。
3. 同一性约束。再合并元素时，空的结果容器应该保证不会改变其他元素。
4. 结合性约束。在不同位置分割计算应该会得到相同的结果。
5. 兼容性约束。以不同的方式再及崛起与组合器间进行分割计算应该会得到相同的的结果。

```java
    // 同一性约束
    s == combiner.apply(s, supplier.get())
    s == combiner.apply(supplier.get(), s)

    // 结合性约束
    combiner.apply(combiner.apply(q, r), s) 
    == 
    combiner.apply(q, combiner.apply(r, s))
```

### 汇聚











