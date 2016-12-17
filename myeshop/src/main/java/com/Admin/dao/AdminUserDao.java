package com.Admin.dao;

import com.Admin.vo.MerchantPager;
import com.Admin.vo.UserPager;

public interface AdminUserDao {
	

	UserPager getUserPager(int offset, int pageSize);

	MerchantPager getMerchentPager(int offset, int pageSize);

}

