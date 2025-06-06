package estados;

import java.util.Arrays;
import java.util.List;

public class SaiuParaEntrega extends EstadoPedido {
    private static final SaiuParaEntrega instancia = new SaiuParaEntrega();

    private SaiuParaEntrega() {}

    public static SaiuParaEntrega getInstancia() {
        return instancia;
    }

    @Override
    public void avancarPara(String nomeEstadoDestino) throws Exception {
        List<String> permitidos = Arrays.asList("Entregue", "Cancelado");
        if (permitidos.contains(nomeEstadoDestino)) {
            EstadoPedido novoEstado = (EstadoPedido) Class.forName("estados." + nomeEstadoDestino).getMethod("getInstancia").invoke(null);
            pedido.setEstado(novoEstado);
        } else {
            throw new IllegalStateException("Transição não permitida de SaiuParaEntrega para " + nomeEstadoDestino);
        }
    }

    @Override
    public String getNome() {
        return "Saiu para Entrega";
    }
}
