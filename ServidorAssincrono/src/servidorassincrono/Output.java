package servidorassincrono;

import java.net.*;
import java.io.*;

public class Output extends Thread{
  private Socket dispositivo;
  PrintStream saida;
  BufferedReader teclado;
  public Output(Socket s) throws Exception{
    dispositivo = s;
    saida = new PrintStream(
      dispositivo.getOutputStream());
    teclado = new BufferedReader(
      new InputStreamReader(System.in));
  }
  public void run(){
    try{
      String msg;
      while((msg=teclado.readLine())!=null){
        System.out.println("Ericik: " + msg);
        saida.println(msg);
      }
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }
}