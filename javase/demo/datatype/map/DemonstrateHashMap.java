package javase.demo.datatype.map;

import java.util.HashMap;
import java.util.Map;

/** Description: 演示HashMap的用法
 * @author created by Meiyu Chen at 2021-5-26 9:42, v1.0
 *      <br>modified by [TODO-修改者] at [TODO-修改时间], [TODO-版本], 修改内容概述如下:
 *      <br>    [TODO-修改内容概述]
 */
public class DemonstrateHashMap {
    public int numIdenticalPairs(int[] nums) {
        int rst = 0;
        // 统计数组中每个数字出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历map
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            rst += count*(count-1)/2;
        }
        return rst;
    }

}
