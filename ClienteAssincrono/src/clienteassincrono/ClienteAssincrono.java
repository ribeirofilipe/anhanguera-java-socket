
package clienteassincrono;

import java.net.*;

public class ClienteAssincrono 
          extends Thread {
  private static Output tec;
  private static Input mon;

  public static void main(String[] args){
    try{
      Socket umServ = 
          new Socket("127.0.0.1", 4445);
      System.out.println(
          "Conectado a:\n" + 
          umServ.getInetAddress() + "\n" + 
          umServ.getPort());
      tec = new Output(umServ);
      mon = new Input(umServ);
      tec.start();
      mon.start();
    }catch (Exception ex){
      System.out.println("Erro: " + ex);
    };
  }
}
