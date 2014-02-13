package es.microforum.servicefrontendsoap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import es.microforum.serviceapi.EmpleadoService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SalaryKillerWebService implements ISalaryKillerWebService{
	
	private EmpleadoService variaSueldos;
	
	@WebMethod(exclude=true)
	public void setVariadorSueldo(EmpleadoService empleadoService) {
		this.variaSueldos = empleadoService;
	}
	
	@Override
	public void variarSueldoEmpleado(double porcentaje) {
		variaSueldos.variarSueldoEmpleado(porcentaje);
	}

}
