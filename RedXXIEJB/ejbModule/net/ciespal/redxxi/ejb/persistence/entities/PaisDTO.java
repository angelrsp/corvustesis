package net.ciespal.redxxi.ejb.persistence.entities;

public class PaisDTO {

	private int codigo;
	private String nombre;
	private String imagenNombre;
	private String imagenPath;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagenNombre() {
		return imagenNombre;
	}

	public void setImagenNombre(String imagenNombre) {
		this.imagenNombre = imagenNombre;
	}

	public String getImagenPath() {
		return imagenPath;
	}

	public void setImagenPath(String imagenPath) {
		this.imagenPath = imagenPath;
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
