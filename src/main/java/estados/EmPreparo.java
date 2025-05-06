package estados;

import java.util.Arrays;
import java.util.List;

public class EmPreparo extends EstadoPedido {
    private static final EmPreparo instancia = new EmPreparo();

    private EmPreparo() {}

    public static EmPreparo getInstancia() {
        return instancia;
    }

    @Override
    public void avancarPara(String nomeEstadoDestino) throws Exception {
        List<String> permitidos = Arrays.asList("SaiuParaEntrega", "Cancelado");
        if (permitidos.contains(nomeEstadoDestino)) {
            EstadoPedido novoEstado = (EstadoPedido) Class.forName("estados." + nomeEstadoDestino).getMethod("getInstancia").invoke(null);
            pedido.setEstado(novoEstado);
        } else {
            throw new IllegalStateException("Transição não permitida de EmPreparo para " + nomeEstadoDestino);
        }
    }

    @Override
    public String getNome() {
        return "Em Preparo";
    }
}
