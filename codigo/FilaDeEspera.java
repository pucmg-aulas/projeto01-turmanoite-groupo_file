public class FilaDeEspera{
  //atributos
  
  private Cliente[] fila;

  // metodos
  public void addCliente(Cliente cliente){
    for(int i = 0; i < fila.length; i++){
      if(fila[i] == null){
        fila[i] = cliente;
        break;
      }
    }
  }
  public void removerCliente(Cliente cliente){
    for(int i = 0; i < fila.length; i++){
      if(fila[i] == cliente){
        fila[i] = null;
        break;
      }
    }
  }
}