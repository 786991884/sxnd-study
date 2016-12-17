package dao;

import java.util.List;

import model.Resource;
import base.BaseDao;
import dto.TreeDTO;

public interface ResourceDao extends BaseDao<Resource> {

	List<TreeDTO> getChildrenByParentId(String id) throws Exception;

	public List<Resource> getChildren(int pid) throws Exception;
}
