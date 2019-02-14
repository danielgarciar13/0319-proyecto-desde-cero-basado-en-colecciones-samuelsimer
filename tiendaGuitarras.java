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

        //Ahora ordeno el ArrayList guitarrasOrdenadas para quedevuelva las guitarras ordenadas por precio
        int p, j = 0;
        Guitarra aux;
        for (p = 1; p < guitarrasOrdenadas.size(); p++) {
            aux = guitarrasOrdenadas.get(p);
            j = p - 1;
            while ((j >= 0) && (aux.getPrecio() < guitarrasOrdenadas.get(j).getPrecio())) {
                guitarrasOrdenadas.set((j + 1),guitarrasOrdenadas.get(j));
                j--;
            }
            guitarrasOrdenadas.set((j + 1), aux);
        }

        for (Guitarra guitarra : guitarrasOrdenadas) {
            textoADevolver += guitarra.getMarca() + " ";
            textoADevolver += guitarra.getPrecio() + "\n";
        }

        return textoADevolver;
    }

    public String getGuitarrasPorPrecioSiSonelectricas() {
        String textoADevolver = "";

        ArrayList<Guitarra> guitarrasOrdenadas = new ArrayList<Guitarra>();
        for (Guitarra guitarra : guitarras) {
            if(guitarra.getEsElectrica() == true){
                guitarrasOrdenadas.add(guitarra);
            }   
        }

        //Ahora ordeno el ArrayList guitarrasOrdenadas para que solo aparezcan
        //las guitarras electricas ordenadas por precio
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

    public void setModificarprecio(double nuevoPrecio, int numeroId){

        guitarras.get(numeroId - 1).setPrecio(nuevoPrecio);

    } 
}
