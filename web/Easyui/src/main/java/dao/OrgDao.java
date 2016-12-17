package dao;

import java.util.List;

import model.Org;
import base.BaseDao;

public interface OrgDao extends BaseDao<Org> {

	List<Org> findList(String id) throws Exception;

	public List<Org> getChildren(int id) throws Exception;

}
