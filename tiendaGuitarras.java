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
}
