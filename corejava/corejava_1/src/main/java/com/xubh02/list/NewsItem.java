package com.xubh02.list;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 按业务规则排序
 */
public class NewsItem implements java.lang.Comparable<NewsItem> {
    private String title;
    private Date publishDate;
    private int click;

    public NewsItem() {
    }

    public NewsItem(String title, Date publishDate, int click) {
        super();
        this.title = title;
        this.publishDate = publishDate;
        this.click = click;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }


    //编写排序规则  日期降序

    /**
     * 正数 >
     * 零  ==
     * 负数 <
     */
    public int compareTo(NewsItem o) {
        if (null == o) {
            return -5;
        }
        //默认升序
        int sorted = this.publishDate.compareTo(o.publishDate);
        return -sorted;
    }


    @Override
    public String toString() {
        return "(" + title + "\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.publishDate) + "\t" + this.click + ")";
    }


}
