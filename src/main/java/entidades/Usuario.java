package entidades;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String ultimaMensagemRecebida;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaMensagemRecebida() {
        return ultimaMensagemRecebida;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.ultimaMensagemRecebida = (String) arg;
    }
}