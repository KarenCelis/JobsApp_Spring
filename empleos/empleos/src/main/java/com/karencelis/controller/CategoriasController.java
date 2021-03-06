package com.karencelis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

	@GetMapping("/index")
	public String mostarIndex(Model model) {
		return "categorias/listCategorias";
	}

	@GetMapping("/create")
	public String crear() {
		return "categorias/formCategoria";
	}

	@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre,@RequestParam("descripcion") String descripcion) {
		System.out.println("categoria: "+nombre);
		System.out.println("Descripcion: "+descripcion);
		return "categorias/listCategorias";
	}
}
