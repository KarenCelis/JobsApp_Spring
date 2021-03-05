package com.karencelis.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karencelis.model.Vacante;
import com.karencelis.service.IVacanteService;

@Controller
@RequestMapping("/vacantes")

public class VacantesController {

	@Autowired
	private IVacanteService serviceVacantes;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		
		return "vacantes/listVacantes";
	}
	
	
	
	@GetMapping("/create")
	public String crear() {
		return "vacantes/formVacante";

	}

	@GetMapping("/delete")
	public String eliminiar(@RequestParam("id") int idVacante, Model model) {

		System.out.println("borrando vacante con id " + idVacante);

		model.addAttribute("id", idVacante);

		return "mensaje";

	}

	@PostMapping("/save")
	public String guardar(Vacante vacante) {
		serviceVacantes.guardar(vacante);
		System.out.println(vacante);
		return "vacantes/listVacantes";

	}

	/*
	 * @PostMapping("/save") public String guardar(@RequestParam("nombre") String
	 * nombre, @RequestParam("descripcion") String descripcion,
	 * 
	 * @RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha,
	 * 
	 * @RequestParam("destacado") int destacado, @RequestParam("salario") double
	 * salario,
	 * 
	 * @RequestParam("detalles") String detalles) {
	 * 
	 * System.out.println("nom "+nombre); System.out.println("nom "+descripcion);
	 * System.out.println("nom "+estatus); System.out.println("nom "+fecha);
	 * System.out.println("nom "+destacado); System.out.println("nom "+salario);
	 * System.out.println("nom "+detalles); return "vacantes/listVacantes";
	 * 
	 * }
	 */
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		System.out.println("Vacante " + vacante);
		model.addAttribute("vacante", vacante);

		return "detalle";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}
}
