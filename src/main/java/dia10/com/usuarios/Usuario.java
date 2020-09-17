package dia10.com.usuarios;

public class Usuario {

    private int id;
    private String name;
    private String lastName;
    private String department;
    private String city;

    public Usuario(int id, String name, String lastName, String department, String city){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.city = city;
    }

    //GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
