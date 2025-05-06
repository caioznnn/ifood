package testes;

import entidades.Pedido;
import entidades.Usuario;
import fabrica.PedidoFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteTransicoesPedido {

    @Test
    public void testTransicaoRecebidoParaEmPreparo() throws Exception {
        Pedido pedido = PedidoFactory.getInstancia().criarPedido("Recebido");
        Usuario usuario = new Usuario("João");
        pedido.addObserver(usuario);
        pedido.avancarPara("EmPreparo");
        assertEquals("Pedido está agora em estado: Em Preparo", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testTransicaoEmPreparoParaSaiuParaEntrega() throws Exception {
        Pedido pedido = PedidoFactory.getInstancia().criarPedido("EmPreparo");
        Usuario usuario = new Usuario("Maria");
        pedido.addObserver(usuario);
        pedido.avancarPara("SaiuParaEntrega");
        assertEquals("Pedido está agora em estado: Saiu para Entrega", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testTransicaoSaiuParaEntregaParaEntregue() throws Exception {
        Pedido pedido = PedidoFactory.getInstancia().criarPedido("SaiuParaEntrega");
        Usuario usuario = new Usuario("Carlos");
        pedido.addObserver(usuario);
        pedido.avancarPara("Entregue");
        assertEquals("Pedido está agora em estado: Entregue", usuario.getUltimaMensagemRecebida());
    }

    @Test
    public void testTransicaoRecebidoParaCancelado() throws Exception {
        Pedido pedido = PedidoFactory.getInstancia().criarPedido("Recebido");
        Usuario usuario = new Usuario("Fernanda");
        pedido.addObserver(usuario);
        pedido.avancarPara("Cancelado");
        assertEquals("Pedido está agora em estado: Cancelado", usuario.getUltimaMensagemRecebida());
    }
}
