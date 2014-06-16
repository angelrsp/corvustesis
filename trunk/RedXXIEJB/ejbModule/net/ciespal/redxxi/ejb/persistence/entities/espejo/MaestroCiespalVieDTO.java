package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the esp_maestro_ciespal_vie database table.
 * 
 */
@Entity
@Table(name="esp_maestro_ciespal_vie")
@NamedQuery(name="MaestroCiespalVieDTO.findAll", query="SELECT m FROM MaestroCiespalVieDTO m")
public class MaestroCiespalVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="mci_apellido")
	private String mciApellido;

	@Column(name="mci_campo_conocimiento")
	private String mciCampoConocimiento;

	@Column(name="mci_ciudad")
	private Integer mciCiudad;

	@Id
	@Column(name="mci_codigo")
	private Integer mciCodigo;

	@Column(name="mci_entidad")
	private Integer mciEntidad;

	@Column(name="mci_fecha_nacimiento")
	private Timestamp mciFechaNacimiento;

	@Column(name="mci_foto")
	private byte[] mciFoto;

	@Column(name="mci_foto_nombre")
	private String mciFotoNombre;

	@Column(name="mci_nombre")
	private String mciNombre;

	@Column(name="mci_pais")
	private Integer mciPais;

	@Column(name="mci_perfil_biografico")
	private String mciPerfilBiografico;

	@Column(name="mci_provincia")
	private Integer mciProvincia;

	public MaestroCiespalVieDTO() {
	}

	public String getCatCiudad() {
		return this.catCiudad;
	}

	public void setCatCiudad(String catCiudad) {
		this.catCiudad = catCiudad;
	}

	public String getCatPais() {
		return this.catPais;
	}

	public void setCatPais(String catPais) {
		this.catPais = catPais;
	}

	public String getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(String catProvincia) {
		this.catProvincia = catProvincia;
	}

	public String getMciApellido() {
		return this.mciApellido;
	}

	public void setMciApellido(String mciApellido) {
		this.mciApellido = mciApellido;
	}

	public String getMciCampoConocimiento() {
		return this.mciCampoConocimiento;
	}

	public void setMciCampoConocimiento(String mciCampoConocimiento) {
		this.mciCampoConocimiento = mciCampoConocimiento;
	}

	public Integer getMciCiudad() {
		return this.mciCiudad;
	}

	public void setMciCiudad(Integer mciCiudad) {
		this.mciCiudad = mciCiudad;
	}

	public Integer getMciCodigo() {
		return this.mciCodigo;
	}

	public void setMciCodigo(Integer mciCodigo) {
		this.mciCodigo = mciCodigo;
	}

	public Integer getMciEntidad() {
		return this.mciEntidad;
	}

	public void setMciEntidad(Integer mciEntidad) {
		this.mciEntidad = mciEntidad;
	}

	public Timestamp getMciFechaNacimiento() {
		return this.mciFechaNacimiento;
	}

	public void setMciFechaNacimiento(Timestamp mciFechaNacimiento) {
		this.mciFechaNacimiento = mciFechaNacimiento;
	}

	public byte[] getMciFoto() {
		return this.mciFoto;
	}

	public void setMciFoto(byte[] mciFoto) {
		this.mciFoto = mciFoto;
	}

	public String getMciFotoNombre() {
		return this.mciFotoNombre;
	}

	public void setMciFotoNombre(String mciFotoNombre) {
		this.mciFotoNombre = mciFotoNombre;
	}

	public String getMciNombre() {
		return this.mciNombre;
	}

	public void setMciNombre(String mciNombre) {
		this.mciNombre = mciNombre;
	}

	public Integer getMciPais() {
		return this.mciPais;
	}

	public void setMciPais(Integer mciPais) {
		this.mciPais = mciPais;
	}

	public String getMciPerfilBiografico() {
		return this.mciPerfilBiografico;
	}

	public void setMciPerfilBiografico(String mciPerfilBiografico) {
		this.mciPerfilBiografico = mciPerfilBiografico;
	}

	public Integer getMciProvincia() {
		return this.mciProvincia;
	}

	public void setMciProvincia(Integer mciProvincia) {
		this.mciProvincia = mciProvincia;
	}

}