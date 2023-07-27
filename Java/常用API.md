## String类常用方法

### String.join()
> String.join()方法是JDK1.8之后新增的一个静态方法，使用方式如下所示：
> String result = String.join("-",“a”,“b”,“c”,“d”);
> 输出结果如下：a-b-c-d
> 也可使用如下方式：
> String[] arr = {“a”,“b”,“c”,“d”};
> String result = String.join("-",arr);
> 输出结果如下：a-b -c-d
> 参数列表：
> 　　1、表示连接的符号
> 　　2、表示被连接的数组（也可以是集合），或者是要连接的多个字符串

### String.replace()
> 字符串替换

## List 去重
```java
List<String> myList = list.stream().distinct().collect(Collectors.toList());
```