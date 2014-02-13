package es.microforum.servicefrontendsoap;

import javax.jws.WebMethod;
import javax.jws.WebService;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ISalaryKillerWebService {
	@WebMethod(operationName="variaSueldos")
	void variarSueldoEmpleado(double porcentaje);
}