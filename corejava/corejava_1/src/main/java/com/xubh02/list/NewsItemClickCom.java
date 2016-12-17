package com.xubh02.list;

/**
 * 额外的排序业务类
 */
public class NewsItemClickCom implements java.util.Comparator<NewsItem> {
    //按点击量排序
    @Override
    public int compare(NewsItem o1, NewsItem o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            if (null != o2) {
                return -1;
            } else {
                return 0;
            }
        } else {
            if (null == o2) {
                return 1;
            } else {
                //比较点击量
                return -(o1.getClick() - o2.getClick());
            }
        }

    }

}
