import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Importar {
    public Queue<FastFood> leerArchivo() {
        String rutaArchivo = "reyesPedidos.txt";
        Queue<FastFood> p = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            FastFood pedido = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("NOmbreCliente: ")) {
                    if (pedido != null) {
                        p.add(pedido);
                    }
                    pedido = new FastFood();
                    pedido.setNombreCliente(line.substring(15)); // Remover "Nombre: "
                } else if (line.startsWith("TipoComida: ")) {
                    if (pedido != null) {
                        pedido.setTipo(line.substring(12)); // Remover ": "
                    }
                } else if (line.startsWith("Cantidad: ")) {
                    if (pedido != null) {
                        pedido.setCantidad(Integer.parseInt(line.substring(10)));

                    }
                } else if (line.startsWith("Precio: ")) {
                    if (pedido != null) {
                        pedido.setPrecio(Double.parseDouble(line.substring(8))); // Remover "Cantidad: "
                        p.add(pedido); // Añadir el producto al final del archivo
                        pedido = null; // Reiniciar para el siguiente producto
                    }
                }
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p;

    }
}
