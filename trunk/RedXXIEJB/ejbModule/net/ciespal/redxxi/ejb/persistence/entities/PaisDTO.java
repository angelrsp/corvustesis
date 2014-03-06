package net.ciespal.redxxi.ejb.persistence.entities;

public class PaisDTO {

	private int codigo;
	private int nombre;
	private int imagenNombre;
	private byte[] imagen;
	private int count;
	
	public PaisDTO() {
	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getImagenNombre() {
		return imagenNombre;
	}

	public void setImagenNombre(int imagenNombre) {
		this.imagenNombre = imagenNombre;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
