package Clases_POJO;

public class Empleado {
	private int id;
	private int tlf;
	private int n_ss;
	private String direccion;
	private String apellido;
	private String seccion;
	private String nombre;
	private String puesto;
	private String dni;
	private String email;
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Empleado(int id, int tlf, int n_ss, String direccion, String apellido, String seccion, String nombre,
			String puesto, String dni, String email) {
		super();
		this.id = id;
		this.tlf = tlf;
		this.n_ss = n_ss;
		this.direccion = direccion;
		this.apellido = apellido;
		this.seccion = seccion;
		this.nombre = nombre;
		this.puesto = puesto;
		this.dni = dni;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", tlf=" + tlf + ", n_ss=" + n_ss + ", direccion=" + direccion + ", apellido="
				+ apellido + ", seccion=" + seccion + ", nombre=" + nombre + ", puesto=" + puesto + ", dni=" + dni
				+ ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public int getN_ss() {
		return n_ss;
	}
	public void setN_ss(int n_ss) {
		this.n_ss = n_ss;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
