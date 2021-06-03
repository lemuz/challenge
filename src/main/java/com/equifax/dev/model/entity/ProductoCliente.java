package com.equifax.dev.model.entity;

import java.io.Serializable;

public class ProductoCliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idProductoCliente;
	
	private Integer idCliente;
	
	private Integer idProducto;

	public ProductoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoCliente(Integer idProductoCliente, Integer idCliente, Integer idProducto) {
		super();
		this.idProductoCliente = idProductoCliente;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
	}

	public Integer getIdProductoCliente() {
		return idProductoCliente;
	}

	public void setIdProductoCliente(Integer idProductoCliente) {
		this.idProductoCliente = idProductoCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public String toString() {
		return "ProductoCliente [idProductoCliente=" + idProductoCliente + ", idCliente=" + idCliente + ", idProducto="
				+ idProducto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		ProductoCliente other = (ProductoCliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
}
