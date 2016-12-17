package biz.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import biz.NoticeServcice;
import dao.NoticeDao;
import dao.impl.NoticeDaoImpl;

public class NoticeServiceImpl implements NoticeServcice {
	/**
	 * 得到所有公告
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public List getNotice() throws UnsupportedEncodingException {
		List noticeList = new ArrayList();
		NoticeDao prodDao = new NoticeDaoImpl();
		noticeList = prodDao.getNotice();
		return noticeList;
	}

}
