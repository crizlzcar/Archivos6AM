import java.util.Queue;
import java.util.Scanner;

public class Method {
    Scanner sc = new Scanner(System.in);

    public Queue<FastFood> IngresarPedido(Queue<FastFood> p, int opt) {
        FastFood o = new FastFood();
        switch (opt) {
            case 1:
                o.setTipo("Perro");
                break;
            case 2:
                o.setTipo("burger");
                break;
            case 3:
                o.setTipo("Corizo");
                break;

            default:
                o.setTipo("French Fries");
                break;
        }
        System.out.println("Ingrese el Nombre del cliente");
        o.setNombreCliente(sc.next());
        System.out.println("Ingrese la cantidad");
        o.setCantidad(sc.nextInt());
        System.out.println("Ingrese el precio");
        o.setPrecio(sc.nextDouble());
        p.offer(o);

        return p;
    }

    public void MostrarTurno(Queue<FastFood> p) {
        if (p.isEmpty()) {
            System.out.println("No hay Turnos acabaste de entrar a trabajar");

        } else {
            for (FastFood o : p) {
                System.out.println(o.getNombreCliente());

            }
        }

    }

    public Queue<FastFood> Despachar(Queue<FastFood> p) {
        if (p.isEmpty()) {
            System.out.println("No hay pedidos");

        } else {
            for (FastFood fastFood : p) {
                p.remove(fastFood);
            }

        }
        return p;

    }
}
