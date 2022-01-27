package altaUsuario;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter

// Esto es el bean

public class Usuario {
	private String nombre;

	private String apellido;

	private String nif;

	private String correo;

	private TipoUsuario tipoUsuario;

	private Date fechaNacimiento;

	private String sexo;

	private String pais;

	private String provincia;

	private String municipio;

	private String calle;

	private String telefono;

	private String observaciones;

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String nif, TipoUsuario tipoUsuario, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nif = nif;
		this.tipoUsuario = tipoUsuario;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getFechaNacForm() {
		return UtilidadesFechas.transformarACadena(this.getFechaNacimiento());
	}

	public void grabar() {
		try {
			ValidadorUsuario validador = new ValidadorUsuario(this);
			validador.validar();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El usuario se ha grabado correctamente"));
		} catch (ValidatorException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void eliminar() {
		try {
			ValidadorEliminacionUsuarios validadorEliminar = new ValidadorEliminacionUsuarios(this);
			validadorEliminar.validar();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Delete", "Usuario Borrado"));
		} catch (ValidatorException ex) {
			System.out.println(ex.getMessage());
		}

	}

}