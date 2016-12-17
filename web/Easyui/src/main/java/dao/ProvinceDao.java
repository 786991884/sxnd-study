package dao;

import java.util.List;

import model.City;
import model.Province;
import base.BaseDao;

public interface ProvinceDao extends BaseDao<Province> {

	List<City> findCitiesByProId(int parseInt) throws Exception;

}
