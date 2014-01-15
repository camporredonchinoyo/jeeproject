package es.microforum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Empleado> findAll() {
		return Lists.newArrayList(empleadoRepository.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findByDni(String dni) {
		return  empleadoRepository.findOne(dni);
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado save(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	@Transactional(readOnly=true)
	public void delete(Empleado empleado) {
		empleadoRepository.delete(empleado);
		
	}

}
