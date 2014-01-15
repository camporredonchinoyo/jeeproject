package es.microforum.serviceapi;

import java.util.List;

import es.microforum.model.Empresa;

public interface EmpresaService {
	// Find all Empresa
	public List<Empresa> findAll();
	
	// Find all Empresa by nif
	public Empresa findByNif(String nif);
	
	// Insert or update a Empresa	
	public Empresa save(Empresa empresa);
	
	// Delete a Empresa	
	public void delete(Empresa empresa);


}
