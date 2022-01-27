package altaUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class TipoUsuario {

	private int id;

	private String descripcion;

	public TipoUsuario() {
		super();
	}

	public TipoUsuario(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
