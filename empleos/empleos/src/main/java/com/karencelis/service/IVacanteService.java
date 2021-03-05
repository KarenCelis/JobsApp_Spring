package com.karencelis.service;

import java.util.List;

import com.karencelis.model.Vacante;

public interface IVacanteService {
	
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer id);
	void guardar(Vacante vacante);

}
