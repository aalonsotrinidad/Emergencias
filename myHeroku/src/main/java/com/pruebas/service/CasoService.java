package com.pruebas.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pruebas.modelo.dto.CasoDTO;

@Service
public interface CasoService {

	List<CasoDTO> listaCasosHome();
	
	void insertarCaso(CasoDTO caso);
	
	void actualizarCaso(CasoDTO caso);
}
