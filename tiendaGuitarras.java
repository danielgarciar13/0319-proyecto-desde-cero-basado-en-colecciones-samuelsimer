import java.util.ArrayList;
import java.util.HashMap;
public class TiendaGuitarras
{
    private ArrayList<Guitarra> guitarras;
    int identificador = 0;
    public TiendaGuitarras() {
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
        int contador, contador2 = 0;
        Guitarra aux;
        for (contador = 1; contador < guitarrasOrdenadas.size(); contador++) {
            aux = guitarrasOrdenadas.get(contador);
            contador2 = contador - 1;
            while ((contador2 >= 0) && (aux.getPrecio() < guitarrasOrdenadas.get(contador2).getPrecio())) {
                guitarrasOrdenadas.set((contador2 + 1),guitarrasOrdenadas.get(contador2));
                contador2--;
            }
            guitarrasOrdenadas.set((contador2 + 1), aux);
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
    
    public String getGuitarrasPorAgrupacionesDePrecio(){
        String ADevolver = "";
        HashMap<String, ArrayList<Guitarra>> mapaGuitarras = new HashMap<String, ArrayList<Guitarra>>();
        ArrayList<Guitarra> muyBaratas = new ArrayList<Guitarra>();
        ArrayList<Guitarra> baratas = new ArrayList<Guitarra>();
        ArrayList<Guitarra> caras = new ArrayList<Guitarra>();
        ArrayList<Guitarra> muyCaras = new ArrayList<Guitarra>();
        for(int c = 0; c < guitarras.size(); c ++){
            if(guitarras.get(c).getPrecio() < 301){
                muyBaratas.add(guitarras.get(c));
            }
            if(guitarras.get(c).getPrecio() > 300 && guitarras.get(c).getPrecio() < 601){
                baratas.add(guitarras.get(c));
            }
            if(guitarras.get(c).getPrecio() > 600 && guitarras.get(c).getPrecio() < 1201){
                caras.add(guitarras.get(c));
            }
            if(guitarras.get(c).getPrecio() > 1201){
                muyCaras.add(guitarras.get(c));
            }
        }
        mapaGuitarras.put("Muy baratas", muyBaratas);
        mapaGuitarras.put("Baratas", baratas);
        mapaGuitarras.put("Caras", caras);
        mapaGuitarras.put("Muy caras", muyCaras);
        for(String guitarra : mapaGuitarras.keySet()){
            ADevolver += guitarra + ":" + "\n";
            for(int c = 0; c < mapaGuitarras.get(guitarra).size(); c ++){
                ADevolver += mapaGuitarras.get(guitarra).get(c).caracteristicas() + "\n";
            }
            ADevolver += "\n";
        }
        System.out.print(ADevolver);
        return ADevolver;
    }
}
