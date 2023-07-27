# 常用API

> 用来记录 js 中常用的一些方法

## array 数组

数组插入

```javascript
let array = [];
array.push(item1, item2, ..., itemX); // 尾插
array.unshift(item1,item2, ..., itemX); // 头插
array.reverse(); // 数组反转
array.filter(item => {
    return item === 2;
}) // 仅仅返回 item 为 2 的数据
array.includes(2); // 是否包含2
```
