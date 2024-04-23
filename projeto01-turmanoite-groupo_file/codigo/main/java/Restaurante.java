public class Restaurante {
    private Mesa[] mesas;

    public Restaurante(int quantidadeMesas) {
        this.mesas = new Mesa[quantidadeMesas];
        for (int i = 0; i < quantidadeMesas; i++) {
            if (i < 4) {
                mesas[i] = new Mesa( i,4);
            } else if (i < 8) {
                mesas[i] = new Mesa( i,6);
            } else {
                mesas[i] = new Mesa( i,8);
            }
        }
    }

    public Mesa[] getMesas() {
        return mesas;
    }

    public void setMesas(Mesa[] mesas) {
        this.mesas = mesas;
    }

    public void finalizarRequisicao(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa) {
                mesa.setOcupada(false);
                break;
            }
        }
    }
}