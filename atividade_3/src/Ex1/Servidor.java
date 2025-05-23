package Ex1;

public class Servidor {
    int carga;

    public Servidor(int carga) {
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    @Override
    public String toString() {
        return Integer.toString(carga);
    }

}
