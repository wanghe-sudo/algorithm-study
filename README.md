# algorithm-study

# 时间复杂度
数据量大到一种数量，瓶颈在高阶位置，因此O表示法只取最高项，放弃低阶项。

若都是O(N)，就需要拼常数项了，但是这个没有办法肉眼看出来，只能实践跑，看哪个算法更优。

# 空间复杂度

# 线性表
逻辑上是连续的

## 数组：顺序存储的线性表，所有元素的地址是连续的
数组的致命缺点，不法动态修改容量，一般都是自己写一个动态数组


### 栈
栈的物理结构，可以是连续的存储空间，只不过是先进的后出
因此可以使用arraylist来实现

使用组合的方式
```java
class Stack{
    private ArrayList arrayList; 
    public void add(){
        
    }
    public void pop(){
        
    }
}
```

