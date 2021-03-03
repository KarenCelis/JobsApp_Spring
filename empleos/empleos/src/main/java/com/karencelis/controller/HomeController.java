
package com.karencelis.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.karencelis.model.Vacante;
import com.karencelis.service.IVacanteService;

@Controller
public class HomeController {

	@Autowired
	private IVacanteService serviceVacantes;
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Arquitecto");
		vacante.setDescripcion("Quiero un arq");
		vacante.setFecha(new Date());
		vacante.setSalario(123.00);

		model.addAttribute("vacante", vacante);
		return "detalle";

	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();

		lista.add("Ingeniero de sistemas");
		lista.add("Enfermeria");
		lista.add("Abogada");
		lista.add("Vendedor");

		model.addAttribute("empleos", lista);

		return "listado";

	}

	@GetMapping("/")
	public String mostrarHome(Model model) {

		/*
		 * model.addAttribute("mensaje", "HElloww"); model.addAttribute("fecha", new
		 * Date());
		 */

		String nombre = "Ingeniero de sistemas";
		Date fechaPub = new Date();
		double salario = 1500.0;
		boolean vigente = true;
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		return "home";
	}



}