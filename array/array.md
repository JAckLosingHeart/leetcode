- 当算法本身只能暴力算法的时候，便可以考虑从数据结构上下手提高效率，比如改用hashmap提高查询效率。
- 几乎任何类型的数组都可以用Arrays.sort()来直接排序，它会帮你按照你定义的大小关系从小到大重新排列这个数组。第一个参数传入你的数组，第二个参数可以直接传入一个lamda表达式（匿名内部类）：(a, b) -> 你要return的东西。重要的是记住a < b的时候return一个负数，这算是默认大家遵守的规范？
- Arrays.asList(a, b, c)可以直接返回一个由a, b, c构成的list
- 380 Insert Delete GetRandom O(1) 确是道好题，通过把ArrayList和Hashmap结合得到了最终解决方案。Hashmap帮助ArrayList解决了remove时搜索和移位都是O(n)的问题，而ArrayList则帮助Hashmap解决了getRandom需要index的问题
- Random类可以用nextInt(n)取随机数, The method call returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and n (exclusive).
- 我才知道的非常重要的一件事：list remove函数传入立即数或者int型变量，会按照传入值是index删除，传如Object的子类才会按照值删除，而且只会删除第一个出现的值
- map remove当然remove的是key