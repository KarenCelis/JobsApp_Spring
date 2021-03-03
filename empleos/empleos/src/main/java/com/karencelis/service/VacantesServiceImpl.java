package com.karencelis.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.karencelis.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacanteService {
	private List<Vacante> lista = null;

	public VacantesServiceImpl() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Pintor");
			vacante1.setDescripcion("Solicitamos un pintor");
			vacante1.setFecha(sdf.parse("08-02-2020"));
			vacante1.setSalario(123.00);
			vacante1.setDestacado(1);
			vacante1.setImagen("painting.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Artista");
			vacante2.setDescripcion("Solicitamos un Artista");
			vacante2.setFecha(sdf.parse("09-02-2020"));
			vacante2.setSalario(140.00);
			vacante2.setDestacado(0);
			vacante2.setImagen("paint-palette.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Musico");
			vacante3.setDescripcion("Solicitamos un Musico");
			vacante3.setFecha(sdf.parse("10-02-2020"));
			vacante3.setSalario(133.00);
			vacante3.setDestacado(0);

			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Cantante");
			vacante4.setDescripcion("Solicitamos un cantante");
			vacante4.setFecha(sdf.parse("11-02-2020"));
			vacante4.setSalario(183.00);
			vacante4.setDestacado(1);
			vacante4.setImagen("microphone.png");

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
		} catch (Exception e) {

			System.out.println("Error " + e.getMessage());
			// TODO: handle exception
		}

	}

	public List<Vacante> buscarTodas() {

		return lista;

	}

	public Vacante buscarPorId(Integer id) {
		for (Vacante v : lista) {
			if (v.getId() == id) {
				return v;
			}
		}
		return null;
	}

}
