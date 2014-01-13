package es.microforum.model;

// Generated 13-ene-2014 19:50:05 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Empleado generated by hbm2java
 */
@Entity
@Table(name = "empleado", catalog = "jee")
public class Empleado implements java.io.Serializable {

	private String dni;
	private Integer version;
	private Empresa empresa;
	private String nombre;
	private String direccion;
	private String tipoEmpleado;
	private String empleadocol;
	private Double salarioAnual;
	private Double valorHora;
	private Double cantidadHoras;
	private byte[] imagen;

	public Empleado() {
	}

	public Empleado(String dni) {
		this.dni = dni;
	}

	public Empleado(String dni, Empresa empresa, String nombre,
			String direccion, String tipoEmpleado, String empleadocol,
			Double salarioAnual, Double valorHora, Double cantidadHoras,
			byte[] imagen) {
		this.dni = dni;
		this.empresa = empresa;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipoEmpleado = tipoEmpleado;
		this.empleadocol = empleadocol;
		this.salarioAnual = salarioAnual;
		this.valorHora = valorHora;
		this.cantidadHoras = cantidadHoras;
		this.imagen = imagen;
	}

	@Id
	@Column(name = "dni", unique = true, nullable = false, length = 45)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nif")
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "direccion", length = 45)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "tipo-empleado", length = 45)
	public String getTipoEmpleado() {
		return this.tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	@Column(name = "empleadocol", length = 45)
	public String getEmpleadocol() {
		return this.empleadocol;
	}

	public void setEmpleadocol(String empleadocol) {
		this.empleadocol = empleadocol;
	}

	@Column(name = "salario-anual", precision = 22, scale = 0)
	public Double getSalarioAnual() {
		return this.salarioAnual;
	}

	public void setSalarioAnual(Double salarioAnual) {
		this.salarioAnual = salarioAnual;
	}

	@Column(name = "valor-hora", precision = 22, scale = 0)
	public Double getValorHora() {
		return this.valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	@Column(name = "cantidad-horas", precision = 22, scale = 0)
	public Double getCantidadHoras() {
		return this.cantidadHoras;
	}

	public void setCantidadHoras(Double cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	@Column(name = "imagen")
	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

}
