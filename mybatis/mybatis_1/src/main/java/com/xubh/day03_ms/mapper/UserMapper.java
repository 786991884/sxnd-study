package com.xubh.day03_ms.mapper;

import java.util.List;
/*
 * 约定
 */
import com.xubh.day03_ms.bean.User;

public interface UserMapper {

	void save(User user);

	void update(User user);

	void delete(int id);

	User findById(int id);

	List<User> findAll();

}
