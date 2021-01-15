package pojos;

public class LGCA implements POJO{
    private int idLGCA;
    private int clave;
    private String descripcion;
    private String idResponsable;

    public LGCA(int idLGCA, int clave, String descripcion, String idResponsable) {
        this.idLGCA = idLGCA;
        this.clave = clave;
        this.descripcion = descripcion;
        this.idResponsable = idResponsable;
    }

    public LGCA(int clave, String descripcion, String idResponsable) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.idResponsable = idResponsable;
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

    public String getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }

    @Override
    public String toString() {
        return "LGCA{" + "idLGCA=" + idLGCA + ", clave=" + clave + ", descripcion=" + descripcion + ", idResponsable=" + idResponsable + '}';
    }
    
}
