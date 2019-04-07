
import Controlador.Main;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ALEX
 */
public class pruebas {
    
    Main main;
    
    @Before
    public void setUp(){
        main = new Main();
    }
    
    //Esta prueba se encarga de probar el método con un archivo que no existe
    @Test
    public void testLeerArchivo() throws FileNotFoundException{
        boolean resultadoObtenido = main.leerTexto("nada.txt");
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    //Esta prueba usa el método en condiciones apropiadas
    @Test
    public void testAgregarTexto() throws IOException{
        boolean resultadoObtenido = main.agregarTexto("The first man who stepped on the moon.","src\\main\\java\\Archivos\\comp.txt");
        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
    //Se busca probar el método en un texto que aunque exista no puede ser escrito
    @Test
    public void testAgregarTexto2() throws IOException{
        boolean resultadoObtenido = main.agregarTexto("The first man who stepped on the moon.","src\\main\\java\\Archivos\\prohibido.txt");
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}
