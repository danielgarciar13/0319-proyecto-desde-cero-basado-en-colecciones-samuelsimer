
import java.util.ArrayList;
public class guitarra
{
    private int numeroCuerdas;
    private double precio;
    private String marca;
    private boolean esElectrica;

    /**
     * Constructor for objects of class guitarra
     */
    public guitarra(int numeroIdentificativo, int numCuerdas, double elPrecio, String laMarca, boolean electrica)
    {
        int identificador = numeroIdentificativo;
        numeroCuerdas = numCuerdas;
        precio = elPrecio;
        marca = laMarca;
        esElectrica = electrica;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double elPrecio) {
        precio = elPrecio;
    }

    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }

    public void setNumeroCuerdas(int numCuerdas) {
        numeroCuerdas = numCuerdas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String laMarca) {
        marca = laMarca;
    }

    public boolean getEsElectrica() {
        return esElectrica;
    }

    public void setEsElectrica(boolean electrica) {
        esElectrica = electrica;
    }

}
