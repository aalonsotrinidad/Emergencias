package com.pruebas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pruebas.modelo.dto.CasoDTO;
import com.pruebas.service.CasoService;

@Controller
public class HomeCasosController {
	
	@Autowired
	private CasoService casoService;
	
	@RequestMapping(value = "/homeCasos", method = RequestMethod.GET)
	public ModelAndView listadoCasos() {
		System.out.println("Ejecutar consulta");
		ModelAndView model = new ModelAndView();
		model.addObject("casos", casoService.listaCasosHome());
		System.out.println("Intentamos recuperar los picklist");
		Map<String, Map<String, String>> mapaGeneralPickList = casoService.getStatusPicklist();
		if (mapaGeneralPickList != null && mapaGeneralPickList.containsKey("Status")){
			model.addObject("statusMap", mapaGeneralPickList.get("Status")); 
		}
		
		System.out.println("Picklist recuperados");
		return model;
	}
	
	@RequestMapping(value = "/listar", params = "insertar", method = RequestMethod.POST)
	public ModelAndView insertaCaso() {
		System.out.println("Intenta insertar");
		ModelAndView model = new ModelAndView();
		CasoDTO caso = new CasoDTO();
		caso.setId(11);
		caso.setSfid("5005B000000sYMlQAM");
		caso.setNumeroCaso("00105594");
		caso.setEstado("ESTA001");
		caso.setDescripcion("Probando Heroku");
		casoService.insertarCaso(caso);
		return new ModelAndView("redirect:/homeCasos");
	}
	
	@RequestMapping(value = "/listar", params = "actualizar", method = RequestMethod.POST)
	public ModelAndView actualizaCaso() {
		System.out.println("Intenta actualizar");
		ModelAndView model = new ModelAndView();
		CasoDTO caso = new CasoDTO();
		caso.setId(11);
		caso.setSfid("5005B000000sYMlQAM");
		caso.setNumeroCaso("00105594");
		caso.setEstado("ESTA000");
		caso.setDescripcion("Probando Heroku Actualización");
		casoService.actualizarCaso(caso);
		return new ModelAndView("redirect:/homeCasos");
	}
}