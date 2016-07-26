package com.pruebas.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebas.modelo.dao.PickListDao;
import com.pruebas.service.PickListService;

public class PickListServiceImpl implements PickListService{

	@Autowired
	private PickListDao pickListDao;
	
	@Override
	public Map<String, Map<String, String>> getPickListPorObjeto(String objeto){
		return pickListDao.getPickListPorObjeto(objeto);
	}
	
	@Override
	public Map<String, String> getPickListPorCampo(String objeto, String campo){
		return pickListDao.getPickListPorCampo(objeto, campo);
	}

}
