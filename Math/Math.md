## Math

- Math.sqrt()开根号，但是貌似参数一旦传大了就返回NaN了

- Math.abs()取绝对值

  ```Java
  public static int abs(int a) {
          return a < 0 ? -a : a;
      }
  ```

- StringBuilder.reverse()可以直接reverse字符串很好用，这个reverse是通过在字符数组中将对称元素交换得到的

  ，而整数的交换则是通过7 reverse integer那样实现的