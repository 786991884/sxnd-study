package com.xubh02.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试Map的遍历方式
 */
public class Test02 {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("aa", "aaaa");
        map.put("bb", "bbbb");

        //遍历Map的第一种方式
        Set keys = map.keySet();
        for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
            String keyStr = (String) iter.next();
            System.out.println(keyStr + "---" + map.get(keyStr));
        }

        //遍历Map的第二种方式
        Set<Entry> set2 = map.entrySet();
        for (Iterator iter = set2.iterator(); iter.hasNext(); ) {
            Entry e = (Entry) iter.next();
            System.out.println(e.getKey() + "---" + e.getValue());

        }

        //方法一 在for-each循环中使用entries来遍历
        //这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用。
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        //方法二 在for-each循环中遍历keys或values。
        //如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet
        //该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        //遍历map中的键
        for (Integer key : map2.keySet()) {
            System.out.println("Key = " + key);
        }

        //遍历map中的值
        for (Integer value : map2.values()) {
            System.out.println("Value = " + value);
        }

        //方法三使用Iterator遍历
        //使用泛型：
        Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();
        Iterator<Map.Entry<Integer, Integer>> entries = map3.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        //不使用泛型：
        Map map4 = new HashMap();
        Iterator entries4 = map.entrySet().iterator();
        while (entries4.hasNext()) {
            Map.Entry entry = (Map.Entry) entries4.next();
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
        }//从性能方面看，该方法类同于for-each遍历（即方法二）的性能
        //方法四、通过键找值遍历（效率低）
        Map<Integer, Integer> map5 = new HashMap<Integer, Integer>();
        for (Integer key : map5.keySet()) {
            Integer value = map5.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }
        //作为方法一的替代，这个代码看上去更加干净；但实际上它相当慢且无效率。
        // 因为从键取值是耗时的操作（与方法一相比，在不同的Map实现中该方法慢了20%~200%）。
        // 如果你安装了FindBugs，它会做出检查并警告你关于哪些是低效率的遍历。所以尽量避免使用。

        //如果仅需要键(keys)或值(values)使用方法二。
        // 如果你使用的语言版本低于java 5，或是打算在遍历时删除entries，必须使用方法三。
        // 否则使用方法一(键值都要)。
    }

}
