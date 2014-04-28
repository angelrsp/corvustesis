package net.ciespal.redxxi.ejb.negocio;

import java.util.List;

import javax.ejb.Local;

import net.ciespal.redxxi.ejb.persistence.entities.AteneaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.FacultadListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ObraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PaisDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.UniversidadListDTO;

import com.corvustec.commons.util.CorvustecException;

@Local
public interface AteneaService {

	List<CentroDTO> obtenerCentroPadre() throws CorvustecException;

	List<CentroDTO> obtenerCentroHijo(CentroDTO centro)
			throws CorvustecException;

	EntidadDTO createEntidad(EntidadDTO entidad) throws CorvustecException;

	List<ContactoListDTO> readContacto(EntidadDTO entidad)
			throws CorvustecException;

	List<MencionDTO> readMencion(CarreraDTO carrera) throws CorvustecException;

	List<ProyectoInvestigacionDTO> readProyectoInvestigacion(
			CarreraDTO carrera) throws CorvustecException;

	void updateEntidad(EntidadDTO entidad) throws CorvustecException;

	List<EventoDTO> readEvento(CarreraDTO carrera) throws CorvustecException;

	List<PublicacionDTO> readPublicacion(CarreraDTO carrera)
			throws CorvustecException;

	void deleteCentro(CentroDTO centro) throws CorvustecException;

	void updateCentro(CentroDTO centro) throws CorvustecException;

	List<CarreraDTO> readCarrera(CentroDTO centro, Object tipo)
			throws CorvustecException;

	List<ContactoListDTO> readContacto(CarreraDTO carrera)
			throws CorvustecException;

	List<OrganizacionDTO> readOrganizacion(Object ubicacion)
			throws CorvustecException;

	List<ContactoListDTO> readContacto(OrganizacionDTO organizacion)
			throws CorvustecException;

	ContactoDTO createOrUpdateContacto(ContactoDTO contactoDTO)
			throws CorvustecException;

	void deleteContacto(ContactoDTO contactoDTO) throws CorvustecException;

	MencionDTO createOrUpdateMencion(MencionDTO mencion)
			throws CorvustecException;

	void deleteMencion(MencionDTO mencion) throws CorvustecException;

	ProyectoInvestigacionDTO createOrUpdateProyectoInvestigacion(
			ProyectoInvestigacionDTO proyecto) throws CorvustecException;

	void deleteProyectoInvestigacion(ProyectoInvestigacionDTO proyecto)
			throws CorvustecException;

	void deletePublicacion(PublicacionDTO publicacion)
			throws CorvustecException;

	EventoDTO createOrUpdateEvento(EventoDTO evento) throws CorvustecException;

	void deleteEvento(EventoDTO evento) throws CorvustecException;

	List<EventoDTO> readEvento(OrganizacionDTO org) throws CorvustecException;

	List<ProyectoInvestigacionDTO> readProyectoInvestigacion(OrganizacionDTO org)
			throws CorvustecException;

	List<DoctorDTO> readDoctor(Object ubicacion) throws CorvustecException;

	List<ContactoListDTO> readContacto(DoctorDTO doctor)
			throws CorvustecException;

	List<PublicacionDTO> readPublicacion(Object ubicacion)
			throws CorvustecException;

	List<NoticiaDTO> readNoticia() throws CorvustecException;

	NoticiaDTO createOrUpdateNoticia(NoticiaDTO noticia)
			throws CorvustecException;

	void deleteNoticia(NoticiaDTO noticia) throws CorvustecException;

	List<NoticiaDTO> readNoticiaPublic() throws CorvustecException;

	List<PublicacionDTO> readPublicacion() throws CorvustecException;

	List<CentroDTO> obtenerCentroPadre(Object ubicacion)
			throws CorvustecException;

	DoctorDTO createOrUpdateDoctor(DoctorDTO doctor) throws CorvustecException;

	OrganizacionDTO createOrUpdateOrganizacion(OrganizacionDTO organizacion)
			throws CorvustecException;

	CentroDTO createOrUpdateCentro(CentroDTO centro) throws CorvustecException;

	CarreraDTO createOrUpdateCarrera(CarreraDTO carrera)
			throws CorvustecException;

	List<ModalidadDTO> readModalidad(CarreraDTO carrera)
			throws CorvustecException;

	List<CentroDTO> readCentroByType(Object type) throws CorvustecException;

	List<CarreraDTO> readCarrera(Object type) throws CorvustecException;

	List<PublicacionDTO> readPublicacionByType(Object type)
			throws CorvustecException;

	List<EventoDTO> readEvento() throws CorvustecException;

	List<ProyectoInvestigacionDTO> readProyectoInvestigacion()
			throws CorvustecException;

	List<OrganizacionDTO> readOrganizacion() throws CorvustecException;

	List<DoctorDTO> readDoctor() throws CorvustecException;

	List<UniversidadListDTO> readUniversidad() throws CorvustecException;

	List<FacultadListDTO> readFacultad() throws CorvustecException;

	List<AteneaDTO> readAtenea(Object pais) throws CorvustecException;

	List<PaisDTO> readPais(Object type) throws CorvustecException;

	CentroDTO readCentro(Object id) throws CorvustecException;

	String visor(AteneaDTO atenea) throws CorvustecException;

	String visor(PaisDTO pais) throws CorvustecException;

	String infoPais(PaisDTO pais);


	void deleteCarreraPregrado(CarreraDTO carrera) throws CorvustecException;


	PublicacionDTO createOrUpdatePublicacion(PublicacionDTO publicacion,
			Boolean entidad) throws CorvustecException;

	List<PublicacionDTO> readPublicacionNoEntity(Object ubicacion)
			throws CorvustecException;

	void deleteCarreraPosgrado(CarreraDTO carrera) throws CorvustecException;

	List<PublicacionDTO> readPublicacion(DoctorDTO doctor)
			throws CorvustecException;

	EntidadDTO readEntidad(DoctorDTO doctor) throws CorvustecException;

	ObraDTO createOrUpdateObra(ObraDTO obra) throws CorvustecException;

	void deleteObra(ObraDTO obra) throws CorvustecException;

	List<ObraDTO> readObra(DoctorDTO doctor) throws CorvustecException;

	EntidadDTO readEntidad(ObraDTO obra) throws CorvustecException;

	void deleteOrganizacion(OrganizacionDTO organizacion)
			throws CorvustecException;

	DoctorDTO getRandomDoctor() throws CorvustecException;

	List<PublicacionDTO> readPublicacion(OrganizacionDTO organizacion)
			throws CorvustecException;

	NoticiaDTO readNoticia(NoticiaDTO noticia) throws CorvustecException;

	List<DoctorListDTO> readDoctorList(Object codigo) throws CorvustecException;


}
