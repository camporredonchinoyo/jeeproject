package es.microforum.serviceapi;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.microforum.model.Empleado;

public interface EmpleadoService {
	// Find all Empleado
	public List<Empleado> findAll();
	
	// Find all Empleado by nif
	public Empleado findByDni(String dni);
	
	// Insert or update a Empleado	
	public Empleado save(Empleado Empleado);
	
	// Delete a Empleado	
	public void delete(Empleado Empleado);
	
	//buscar un empleado por nombre
	public Page<Empleado> findByNombre(Pageable pageable, String nombre);
}
