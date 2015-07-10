package ec.edu.uce.encuesta.web.controller;

public class Alumno {

	private String nombres;
	private String apellidos;
	private String notaTrabajo;
	private String notaPrueba;
	private String notaExamen;
	private String notaPromedio;
	private String text;
	
	Alumno(String nombres,
	 String apellidos,
	 String notaTrabajo,
	 String notaPrueba,
	 String notaExamen,
	 String notaPromedio){
	
		this.nombres=nombres;
		this.apellidos=nombres;
		this.notaTrabajo=notaTrabajo;
		this.notaPrueba=notaPrueba;
		this.notaExamen=notaExamen;
		this.notaPromedio= notaPromedio;
	}
	
	Alumno(){
			}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNotaTrabajo() {
		return notaTrabajo;
	}
	public void setNotaTrabajo(String notaTrabajo) {
		this.notaTrabajo = notaTrabajo;
	}
	public String getNotaPrueba() {
		return notaPrueba;
	}
	public void setNotaPrueba(String notaPrueba) {
		this.notaPrueba = notaPrueba;
	}
	public String getNotaExamen() {
		return notaExamen;
	}
	public void setNotaExamen(String notaExamen) {
		this.notaExamen = notaExamen;
	}
	public String getNotaPromedio() {
		return notaPromedio;
	}
	public void setNotaPromedio(String notaPromedio) {
		this.notaPromedio = notaPromedio;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
