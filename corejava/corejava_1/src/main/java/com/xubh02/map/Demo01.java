package com.xubh02.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * this is a cat and that is a mice and where is the food?
 * 统计每个单词出现的次数
 * <p>
 * 存储到Map中
 * key :String
 * value:自定义类型
 * <p>
 * "分拣" 思路
 * 1、为所有key创建容器
 * 之后容器中存放对应value
 * 2、第一次创建容器，并存放值value
 * 第二次之后，直接使用容器存放值
 */
public class Demo01 {

    public static void main(String[] args) {
        String str = "this is a cat and that is a mice and where is the food";
        //分割字符串
        String[] strArray = str.split(" ");
        //存储到Map中
        Map<String, Letter> letters = new HashMap<String, Letter>();
        for (String temp : strArray) {
            /*
			 //1、为所有key创建容器
			if(!letters.containsKey(temp)){
				Letter col = new Letter();
				col.setCount(1); //第一次值存放容器中
				letters.put(temp, col);
			}else{
				//2、	 第二次之后，直接使用容器存放值
				Letter col =letters.get(temp); //直接使用容器
				col.setCount(col.getCount()+1);
			}*/
            Letter col = null;
            if (null == (col = letters.get(temp))) {
                col = new Letter();
                col.setCount(1); //第一次值存放容器中
                letters.put(temp, col);
            } else {
                //2、	 第二次之后，直接使用容器存放值
                col.setCount(col.getCount() + 1);
            }
        }
        //输出Map的值
        Set<String> keys = letters.keySet();
        for (String key : keys) {
            Letter col = letters.get(key);
            System.out.println("字母:" + key + ",次数" + col.getCount());
        }


    }

    public static void test1() {
        String str = "this is a cat and that is a mice and where is the food";
        //分割字符串
        String[] strArray = str.split(" ");
        //存储到Map中
        Map<String, Letter> letters = new HashMap<String, Letter>();
		/*
		for(String temp:strArray){

			 //1、为所有key创建容器
			 	 之后容器中存放对应value

			if(!letters.containsKey(temp)){
				letters.put(temp, new Letter());
			}
		}
		for(String temp:strArray){

			//  容器中存放对应value

			Letter col =letters.get(temp); //直接使用容器
			col.setCount(col.getCount()+1);
		}

		*/
        for (String temp : strArray) {

            //1、为所有key创建容器
            if (!letters.containsKey(temp)) {
                letters.put(temp, new Letter());
            }
            //2、	 之后容器中存放对应value
            Letter col = letters.get(temp); //直接使用容器
            col.setCount(col.getCount() + 1);
        }

        //输出Map的值
        Set<String> keys = letters.keySet();
        for (String key : keys) {
            Letter col = letters.get(key);
            System.out.println("字母:" + key + ",次数" + col.getCount());
        }
    }
}
