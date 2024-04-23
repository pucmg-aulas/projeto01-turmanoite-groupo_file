public class FIlaDeEspera {
    private Cliente[] fila;


    public FIlaDeEspera(Cliente cliente){

        for(int i = 0; i < this.fila.length; i++){
            if(this.fila[i] == null){
                this.fila[i] = cliente;
                break;
            }
        }
    }
    public void removerCliente(Cliente cliente){
        for(int i = 0; i < this.fila.length; i++){
            if(this.fila[i] == cliente){
                this.fila[i] = null;
                break;
            }
        }
    }

}

