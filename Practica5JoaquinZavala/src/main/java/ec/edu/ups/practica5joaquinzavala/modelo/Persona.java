package ec.edu.ups.practica5joaquinzavala.modelo;

public abstract class Persona {
    
    //atributos de la clase
    private int codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private double salario;
    private String nacionalidad;
    
    //constructores nescesarios
    public Persona() {
    }

    public Persona(int codigo) {
        this.codigo = codigo;
    }
    
    public Persona(int codigo, String nombre, String apellido, int edad, double salario, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
        this.nacionalidad = nacionalidad;
    }
    
    //get and set de la clase
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    //metodo abstract
    public abstract double calularSalario();
    
    //hashCode y equals del atributo codigo
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return this.codigo == other.codigo;
    }
    
    //toString
    @Override
    public String toString() {
        return "{codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", salario=" + salario + ", nacionalidad=" + nacionalidad + '}';
    }
}
