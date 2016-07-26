package com.pruebas.modelo.dto;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salesforce.Case")
public class CasoDTO {


	@Id
	@Column(name = "id")	
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "CaseNumber")
	private String numeroCaso;

	@Column(name = "Status")
	private String estado;
	
	@Column(name = "Description")
	private String descripcion;
	
	@Column(name = "Origin")
	private String origen;
	
	@Column(name = "Numero_de_Inservice__c")
	private String numeroInservice;
	
	@Column(name = "Motivo_Empresa__C")
	private String subMotivo;
	
	@Column(name = "Sub_Estado__c")
	private String subEstado;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getNumeroInservice() {
		return numeroInservice;
	}

	public void setNumeroInservice(String numeroInservice) {
		this.numeroInservice = numeroInservice;
	}

	public String getSubMotivo() {
		return subMotivo;
	}

	public void setSubMotivo(String subMotivo) {
		this.subMotivo = subMotivo;
	}

	public String getSubEstado() {
		return subEstado;
	}

	public void setSubEstado(String subEstado) {
		this.subEstado = subEstado;
	}
}
