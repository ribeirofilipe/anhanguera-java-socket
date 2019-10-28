package servidorassincrono;

import java.net.*;

public class ServidorAssincrono 
          extends Thread {
    private static Output tec;
    private static Input mon;
    
  public static void main(String[] args){
    try{
      ServerSocket canal = new ServerSocket(4445);
      System.out.println("Aguardando...");
      Socket umCli = canal.accept();
      System.out.println(
          "Conectado a:\n" + 
          umCli.getInetAddress()+"\n"+ 
          umCli.getPort());
      tec = new Output(umCli);
      mon = new Input(umCli);
      mon.start();
      tec.start();     
    }catch (Exception ex){
      System.out.println("Erro: " + ex);
    };
  }
}
