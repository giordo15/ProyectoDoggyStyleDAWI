package org.doggystyle.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="producto")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private double precio; 
	private int cantidad;
	private String imagen;
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;
	
	@ManyToOne
	private Usuario usuario;
	
	
	public Producto() {
	
	}

	public Producto(int id, String nombre, double precio, int cantidad, String imagen, Categoria categoria,
			Estado estado, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.imagen = imagen;
		this.categoria = categoria;
		this.estado = estado;
		this.usuario = usuario;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", imagen=" + imagen + ", categoria=" + categoria + ", estado=" + estado + "]";
	}
	
	
	

}
