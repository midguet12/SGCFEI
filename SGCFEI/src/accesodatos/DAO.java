package accesodatos;

import pojos.POJO;

public interface DAO {
    public void insertar(POJO pojo);
    public POJO obtener(int id);
    public void actualizar(POJO pojo);
    public void eliminar(int id);
}
