package biz;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface NoticeServcice {

	// 得到所有公告
	public List getNotice() throws UnsupportedEncodingException;
}
