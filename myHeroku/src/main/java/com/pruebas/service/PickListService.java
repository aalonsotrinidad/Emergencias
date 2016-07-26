package com.pruebas.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface PickListService {

	Map<String, Map<String, String>> getPickListPorObjeto(String objeto);
	
	Map<String, String> getPickListPorCampo(String objeto, String campo);
}
