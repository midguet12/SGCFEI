package pojos;

public class LGCA implements POJO{
    private int idLGCA;
    private int clave;
    private String descripcion;

    public LGCA(int idLGCA, int clave, String descripcion) {
        this.idLGCA = idLGCA;
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public LGCA(int clave, String descripcion) {
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public int getIdLGCA() {
        return idLGCA;
    }

    public void setIdLGCA(int idLGCA) {
        this.idLGCA = idLGCA;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "LGCA{" + "idLGCA=" + idLGCA + ", clave=" + clave + ", descripcion=" + descripcion + '}';
    }
    
}
