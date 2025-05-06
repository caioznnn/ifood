package estados;

import entidades.Pedido;

public abstract class EstadoPedido {
    protected Pedido pedido;

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void avancarPara(String nomeEstadoDestino) throws Exception;

    public abstract String getNome();
}
