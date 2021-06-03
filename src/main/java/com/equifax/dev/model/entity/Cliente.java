package com.equifax.dev.model.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="cliente")
@Table(name="CLIENTES")
public class Cliente {

	@Id
	@Column(name="IdCliente")
	private Long idCliente;
	
	@Column(name="NombreCliente")
	private String nombreCliente;
	
	@Column(name="FechaCreacion")
	private Date fechaCreacion;
	
	@Column(name="Estado")
	private Boolean estado;
	
	@ManyToMany
    @JoinTable( 
        name = "PRODUCTOS_CLIENTES", 
        joinColumns = @JoinColumn(
          name = "IdClientes", referencedColumnName = "IdCliente"), 
        inverseJoinColumns = @JoinColumn(
          name = "IdProductos", referencedColumnName = "IdProducto")) 
    private Set<Producto> productosCliente;

	public Cliente() {
	}

	public Cliente(Long idCliente, String nombreCliente, Date fechaCreacion, Boolean estado,
			Set<Producto> productosCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.productosCliente = productosCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Set<Producto> getProductosCliente() {
		return productosCliente;
	}

	public void setProductosCliente(Set<Producto> productosCliente) {
		this.productosCliente = productosCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", fechaCreacion="
				+ fechaCreacion + ", estado=" + estado + ", productosCliente=" + productosCliente + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}

}
