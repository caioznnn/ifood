package entidades;

import estados.EstadoPedido;
import java.util.Observable;

public class Pedido extends Observable {
    private EstadoPedido estado;

    public Pedido(EstadoPedido estadoInicial) {
        this.estado = estadoInicial;
        this.estado.setPedido(this);
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        this.estado.setPedido(this);
        setChanged();
        notifyObservers("Pedido está agora em estado: " + estado.getNome());
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void avancarPara(String nomeEstadoDestino) throws Exception {
        estado.avancarPara(nomeEstadoDestino);
    }
}