package com.xubh02.list;

import java.util.*;

/**
 * 引用类型的排序  可以自己编写冒泡排序
 * 1、实体类实现接口 java.lang.Comparable 重写CompareTo
 * List +Collections即可
 * 2、提供额外排序业务类 实现java.util.Comparator 重写compare方法
 * 1)一个业务一个排序规则
 * 2)源代码不能修改
 * 3)业务与实现分离
 */
public class ListDemo02 {

    public static void main(String[] args) {
        System.out.println("abc".compareTo(new String("中abc")));
        System.out.println("dabc".compareTo("defg")); //从头开始的非子串，返回第一个不同的unicode码之差
        System.out.println("abc".compareTo("abcddasf")); //长度之差 从头开始的子串
        System.out.println("abc".compareTo("abc")); //长度之差 从头开始的子串


        List<NewsItem> news = new ArrayList<NewsItem>();
        news.add(new NewsItem(" 习近平航天员天地通话 新闻|我核工厂深藏兰州山间", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000), 800));
        news.add(new NewsItem(" 斯诺登抵俄 欲避难厄瓜多尔", new Date(), 200));
        //按点击量升序
        NewsItemClickCom clickComp = new NewsItemClickCom();
        Collections.sort(news, clickComp);
        for (NewsItem temp : news) {
            System.out.println(temp);
        }

        Collections.sort(news, new NewsItemTitleCom());
        for (NewsItem temp : news) {
            System.out.println(temp);
        }


    }

    public static void sort1() {
        List<NewsItem> news = new LinkedList<NewsItem>();
        news.add(new NewsItem(" 习近平航天员天地通话 新闻|我核工厂深藏兰州山间", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000), 100));
        news.add(new NewsItem(" 斯诺登抵俄 欲避难厄瓜多尔", new Date(), 200));

        //按时间倒叙
        //思路一：存放到数组中
        NewsItem[] newsArray = news.toArray(new NewsItem[0]);
        System.out.println("排序前" + Arrays.toString(newsArray));

        //冒泡排序
        boolean sorted = true;
        for (int i = 0; i < newsArray.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < newsArray.length - 1 - i; j++) {
                if (newsArray[j].compareTo(newsArray[j + 1]) > 0) {
                    NewsItem temp = newsArray[j];
                    newsArray[j] = newsArray[j + 1];
                    newsArray[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        System.out.println("排序后" + Arrays.toString(newsArray));


        news = new ArrayList<NewsItem>();
        news.add(new NewsItem(" 习近平航天员天地通话 新闻|我核工厂深藏兰州山间", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000), 100));
        news.add(new NewsItem(" 斯诺登抵俄 欲避难厄瓜多尔", new Date(), 200));
        //使用 Arrays.sort();
        newsArray = news.toArray(new NewsItem[0]);
        System.out.println("排序前" + Arrays.toString(newsArray));
        Arrays.sort(newsArray);
        System.out.println("排序后" + Arrays.toString(newsArray));


        //Collections
        news = new ArrayList<NewsItem>();
        news.add(new NewsItem(" 习近平航天员天地通话 新闻|我核工厂深藏兰州山间", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000), 100));
        news.add(new NewsItem(" 斯诺登抵俄 欲避难厄瓜多尔", new Date(), 200));

        Collections.sort(news);
        System.out.println("==============");
        for (NewsItem temp : news) {
            System.out.println(temp);
        }
    }
}
