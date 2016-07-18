package com.pruebas.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebas.modelo.dao.CasoDao;
import com.pruebas.modelo.dto.CasoDTO;
import com.pruebas.service.CasoService;

public class CasoServiceImpl implements CasoService{

	@Autowired
	private CasoDao casoDao;
	
	@Override
	public List<CasoDTO> listaCasosHome(){
		return casoDao.getListaCasosHome();
	}
	
	@Override
	public void insertarCaso(CasoDTO caso){
		casoDao.insertarCaso(caso);
	}
	
	@Override
	public void actualizarCaso(CasoDTO caso){
		casoDao.actualizarCaso(caso);
	}
	
	@Override
	public Map<String, Map<String, String>> getStatusPicklist(){
		return casoDao.recuperarPickList();
	}
}
