package es.microforum.serviceapi;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




import es.microforum.model.Empleado;

public interface EmpleadoService {
	// Find all Empleado
	public Page<Empleado> findAll(Pageable pageable);
	
	// Find all Empleado
	public List<Empleado> findAllEmpleados();
	
	// Find all Empleado by nif
	public Empleado findByDni(String dni);
	
	// Insert or update a Empleado	
	public Empleado save(Empleado Empleado);
	
	// Delete a Empleado	
	public void delete(Empleado Empleado);
	
	// Delete a Empleado	
	public void deleteById(String Id);
	
	//buscar un empleado por nombre
	public Page<Empleado> findByNombre(String nombre, Pageable pageable);
	
	//modifica sueldos todos los empleados
	public abstract void variarSueldoEmpleado(double porcentaje);
}
