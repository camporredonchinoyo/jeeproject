package es.microforum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import es.microforum.model.Empleado;
import es.microforum.repository.EmpleadoRepository;
import es.microforum.serviceapi.EmpleadoService;


@Service("springJpaEmpleadoService")
@Repository
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Page<Empleado> findAll(Pageable pageable) {
		return empleadoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findByDni(String dni) {
		return  empleadoRepository.findOne(dni);
	}

	@Override
	public Empleado save(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void delete(Empleado empleado) {
		//empleadoRepository.delete(id);
		empleadoRepository.delete(empleado);
		
	}

//	@Override
//	@Transactional(readOnly=true)
//	public Page<Empleado> findAll(Pageable pageable) {
//	return empleadoRepository.findAll(pageable);
//	}

	@Override
	@Transactional(readOnly=true)
	public Page<Empleado> findByNombre(String nombre, Pageable pageable) {
		return empleadoRepository.findByNombre(nombre, pageable);
	}

	@Override
	public void deleteById(String id) {
		empleadoRepository.delete(id);
	}

}
