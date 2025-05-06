package fabrica;

import entidades.Pedido;
import estados.EstadoPedido;
import java.lang.reflect.Method;

public class PedidoFactory {
    private static final PedidoFactory instancia = new PedidoFactory();

    private PedidoFactory() {}

    public static PedidoFactory getInstancia() {
        return instancia;
    }

    public Pedido criarPedido(String nomeEstadoInicial) throws Exception {
        Class<?> classeEstado = Class.forName("estados." + nomeEstadoInicial);
        Method metodo = classeEstado.getMethod("getInstancia");
        EstadoPedido estado = (EstadoPedido) metodo.invoke(null);
        return new Pedido(estado);
    }
}
