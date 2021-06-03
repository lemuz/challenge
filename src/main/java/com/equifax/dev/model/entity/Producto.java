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

@Entity(name="producto")
@Table(name="PRODUCTOS",schema="SYSTEM")
public class Producto {
	
	@Id
	@Column(name="IdProducto")
	private Long idProducto;
	
	@Column(name="NombreProducto")
	private String nombreProducto;
	
	@Column(name="FechaCreacion")
	private Date fechaCreacion;
	
	@Column(name="Estado")
	private Boolean estado;
	
	@ManyToMany
    @JoinTable( 
        name = "SYSTEM.PRODUCTOS_CLIENTES", 
        joinColumns = @JoinColumn(
          name = "IdProductos", referencedColumnName = "IdProducto"), 
        inverseJoinColumns = @JoinColumn(
          name = "IdClientes", referencedColumnName = "IdCliente")) 
    private Set<Cliente> clientesProducto;

	public Producto() {
	}

public Producto(Long idProducto, String nombreProducto, Date fechaCreacion, Boolean estado,
			Set<Cliente> clientesProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.clientesProducto = clientesProducto;
	}

	
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
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
public Set<Cliente> getClientesProducto() {
		return clientesProducto;
	}

	public void setClientesProducto(Set<Cliente> clientesProducto) {
		this.clientesProducto = clientesProducto;
	}

	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", fechaCreacion="
				+ fechaCreacion + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}

}
