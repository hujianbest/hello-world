
#流
+ 创建
+ 转换
+ 终止

## 流-创建
```
Collection.stream()
Stream.of()
```
## 流-转换
```
filter()
map()
flatMap()
抽取子流：limit();skip()
连接流：concat()
distinct()
sorted()
peek()
```
## 流-终止
```
count()
max()
min()
findFirst()
findAny()
anyMatch()
allMatch()
noneMacth()

toArray()
collect(Collectors.toList())
collect(Collectors.toSet())
collect(Collectors.toCollection(TreeSet::new))
collect(Collectors.jioning())
collect(Collectors.summarizingInt())

collect(Collectors.toMap())

collect(Collectors.groupBy())
collect(Collectors.partitionBy())
collect(Collectors.groupingBy())

reduce()

```

## Optional<T>

## 基本类型流
```
IntStream
LongStream
DoubleStream
```

## 并行流
并行流需要遵守一些规则
+ 数据应该在内存中，等待数据到达是非常低效的
+ 流应该可以被高效的分成若干个部分
+ 流操作的工作量应该具有较大的规模
+ 流操作不应该被阻塞

只要在终结方法执行时，流处于并行模式，那么所有的中间流操作都将被并行化   
目标是与顺序执行时返回的结果相同
```
Collection.parallelStream()
parallel()
```



