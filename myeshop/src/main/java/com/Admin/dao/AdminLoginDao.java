package com.Admin.dao;

import com.Admin.vo.Admin;

public interface AdminLoginDao {

	boolean login(Admin admin);

	boolean updatePassword(Admin admin);

}
