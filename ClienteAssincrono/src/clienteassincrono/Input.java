package  clienteassincrono;

import java.net.*;
import java.io.*;

public class Input extends Thread{
  private Socket dispositivo;
  BufferedReader entra;

 public Input(Socket s) throws Exception{
    dispositivo = s;
    entra = new BufferedReader(
      new InputStreamReader(
        dispositivo.getInputStream()));
  }

  public void run(){
    try{
      String msg;
      while ((msg=entra.readLine())!=null){
        System.out.println("Erick: " + msg);
      }
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }
}