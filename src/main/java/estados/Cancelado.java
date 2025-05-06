package estados;

public class Cancelado extends EstadoPedido {
    private static final Cancelado instancia = new Cancelado();

    private Cancelado() {}

    public static Cancelado getInstancia() {
        return instancia;
    }

    @Override
    public void avancarPara(String nomeEstadoDestino) {
        throw new IllegalStateException("Pedido foi cancelado. Não é possível alterar estado.");
    }

    @Override
    public String getNome() {
        return "Cancelado";
    }
}