package dao;

import java.util.List;
import java.util.Map;

import model.User;
import base.BaseDao;

public interface UserDao extends BaseDao<User> {

	List<User> findByPagination(int currentPage, int pageSize,
								Map<String, Object> m) throws Exception;

	int getTotal() throws Exception;

	List<User> searchByName(String q) throws Exception;
}
