package com.animal.service;

import java.util.ArrayList;

import com.animal.dao.MapDAO;
import com.animal.vo.MapVO;

public class MapService {
	private final MapDAO mapDao;
	private static final MapService mapService;
	
	static {
		mapService = new MapService();
	}
	
	private MapService() {
		mapDao = MapDAO.getInstance();
	}
	
	public static MapService getInstance() {
		return mapService;
	}
	
	public ArrayList<MapVO> ShowAll(){
		return mapDao.mapSelectAll();
	}
}
