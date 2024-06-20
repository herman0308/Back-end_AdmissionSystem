package TFG.AdmisionProject.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiantes")
public class estudiantes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	@Column(name = "Nombre", length = 60, nullable = false)
	private String nombre;
	@Column(name = "Apellidos", length = 60, nullable = false)
	private String apellidos;
	@Column(name = "Fecha de nacimiento", length = 60, nullable = false)
	private Date fechanacimiento;
	@Column(name = "Direccion", length = 60, nullable = false)
	private String direccion;
	@Column(name = "Telefono", length = 60, nullable = false)
	private long telefono;
	@Column(name = "Correo", length = 60, nullable = false, unique = true)
	private String correo;

	public estudiantes() {

	}

	public estudiantes(long id, String nombre, String apellidos, Date fechanacimiento, String direccion, long telefono,
			String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
