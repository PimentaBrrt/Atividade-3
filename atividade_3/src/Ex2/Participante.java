package Ex2;

public class Participante {
    int numero;

    public Participante(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Participante " + numero;
    }    

}
