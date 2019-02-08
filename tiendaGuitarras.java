import java.util.ArrayList;
public class tiendaGuitarras
{
    private ArrayList<Guitarra> guitarras;
    int identificador = 0;

    public tiendaGuitarras() {
        guitarras = new ArrayList<Guitarra>(); 

    } 

    public void agregarGuitarra(String textoGuitarra, int cuerdas, double euros, boolean electrica ) {
        Guitarra nuevaGuitarra = new Guitarra(cuerdas, euros, textoGuitarra, electrica);
        guitarras.add(nuevaGuitarra);
        identificador ++;
    }

    public String getTareas() {
        String tareasADevolver = "";
        String tipoGuitarra = "electrica";
        for (Guitarra guitarra : guitarras){
            if (guitarra.getEsElectrica() == false){
                tipoGuitarra = "noElectrica";
            }
            tareasADevolver += guitarra.getMarca() + ", " + guitarra.getPrecio() + "€" + guitarra.getNumeroCuerdas() + ", " + tipoGuitarra + "\n";
        }
        return tareasADevolver;
    } 
    
    public String getGuitarrasPorPrecio() {
        String textoADevolver = "";

        ArrayList<Guitarra> guitarrasOrdenadas = new ArrayList<Guitarra>();
        for (Guitarra guitarra : guitarras) {
            guitarrasOrdenadas.add(guitarra);
        }

        //Ahora ordeno el ArrayList tareasOrdenadas siguiendo el algoritmo
        //de seleccion que se explica en el video
        int posicionAMirar = 0;
        while (posicionAMirar < guitarrasOrdenadas.size() - 1) {
            int posicionMenor = posicionAMirar;
            double valorMaxPrecioHastaAhora = guitarrasOrdenadas.get(posicionMenor).getPrecio();

            int posicionPosibleMenor = posicionAMirar + 1; 
            while (posicionPosibleMenor < guitarrasOrdenadas.size()) {
                if (guitarrasOrdenadas.get(posicionPosibleMenor).getPrecio() 
                < valorMaxPrecioHastaAhora) {
                    posicionMenor = posicionPosibleMenor;
                    valorMaxPrecioHastaAhora = guitarrasOrdenadas.get(posicionPosibleMenor).getPrecio();
                }
                posicionPosibleMenor++;
            }

            Guitarra tareaTemporal = guitarrasOrdenadas.get(posicionAMirar);
            guitarrasOrdenadas.set(posicionAMirar, guitarrasOrdenadas.get(posicionMenor));;
            guitarrasOrdenadas.set(posicionMenor, tareaTemporal);

            posicionAMirar++;
        }

        for (Guitarra guitarra : guitarrasOrdenadas) {
            textoADevolver += guitarra.getMarca() + " ";
            textoADevolver += guitarra.getPrecio() + "\n";
        }

        return textoADevolver;
    }     

}
