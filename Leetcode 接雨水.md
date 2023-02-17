##### Leetcode 接雨水

---

##### *描述*：

```text

```

==思路==：

```text
1、当前节点能接多少水取决于它左右两侧最大值中较小的那个

2、遍历数组找当前点的左侧最大值和右侧最大值并取较小的那个

3、第二步取得的值减当前节点的height就是本节点能容纳的雨水量

```

code:

```java
int getMaxNumTerrible(int[] array) {
        int rainNum = 0; //
        for (int current = 0; current <= array.length -1; current++) {
            int leftMax = 0; // 左侧最大
            int rightMax = 0; // 右侧最大
            // 找到左侧最大
            for (int j=current;j >= 0;j--) {

                leftMax = Math.max(leftMax,array[j]);
            }
            // 找到右侧最大
            for (int j=current;j <= array.length -1;j++) {

                rightMax = Math.max(rightMax,array[j]);
            }

            // 当左侧值大于当前切右侧值也大于当前时 才能接水
            if (leftMax > array[current] && rightMax > array[current]) {
                // 当前点可接多少水取决与左右两边的最小
                int result = Math.min(leftMax, rightMax);
                rainNum += result - array[current];
                System.out.println("当前点"+current + "可以容纳:" +  (result - array[current]));
            }
        }
        return rainNum;
    }

```







