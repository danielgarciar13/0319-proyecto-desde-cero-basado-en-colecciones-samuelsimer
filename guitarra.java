public class Guitarra
{
    private int numeroCuerdas;
    private double precio;
    private String marca;
    private boolean esElectrica;

    /**
     * Constructor for objects of class guitarra
     */
    public Guitarra( int numCuerdas, double elPrecio, String laMarca, boolean electrica)
    {  
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
    
    public String caracteristicas() {
        String tareasADevolver = "";
        String tipoGuitarra = "electrica";
        if (esElectrica == false){
                tipoGuitarra = "noElectrica";
            }
        tareasADevolver += marca + ", " + precio + ", " + numeroCuerdas + ", " + tipoGuitarra;
        return tareasADevolver;
    }    
    
}
