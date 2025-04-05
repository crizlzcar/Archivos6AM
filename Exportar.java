import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Exportar {

    public void exportarArchivo(Queue<FastFood> p) {

        try (FileWriter escriba = new FileWriter("reyesPedidos.txt")) {
            for (FastFood item : p) {
                escriba.write("NOmbreCliente: " + item.getNombreCliente() + "\n");
                escriba.write("TipoComida: " + item.getTipo() + "\n");
                escriba.write("Cantidad: " + item.getCantidad() + "\n");
                escriba.write("Precio: " + item.getPrecio() + "\n");
                escriba.write("---------------------------------------\n");

            }

            System.out.println("Archivo exportado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
