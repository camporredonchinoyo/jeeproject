package es.microforum.serviceapi;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.microforum.model.Empleado;
import es.microforum.model.Empresa;

public interface EmpresaService {
	
	// Find all Empresa
	public List<Empresa> findAllEmpresas();
	
	// Find all Empresa
	public Page<Empresa> findAll(Pageable pageable);
	
	// Find all Empresa by nif
	public Empresa findByNif(String nif);
	
	// Insert or update a Empresa	
	public Empresa save(Empresa empresa);
	
	// Delete a Empresa	
	public void delete(Empresa empresa);
	
	// Delete a Empresa	
	public void deleteById(String Id);
	
	//buscar una empresa por nombre
	public Page<Empresa> findByNombre(String nombre, Pageable pageable);


}
