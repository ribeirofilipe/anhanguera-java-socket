package servidorudp;

import java.io.*;
import java.net.*;

public class ServidorUDP{
  public static void main(String[] args){
    try {
      System.out.println("Serv. Ativo\n");
      DatagramSocket cliente =
         new DatagramSocket(4545);

      DatagramPacket pacoteIn = 
         new DatagramPacket(new byte[512],512);
      cliente.receive(pacoteIn);
      System.out.println("Pacote recebido");
      System.out.println(
         new String(pacoteIn.getData()));
      System.out.println(
         "Bytes: " + pacoteIn.getData()
         + "\nTamanho: " + pacoteIn.getLength()
         + "\nIP: " + pacoteIn.getAddress()
         + "\nPorta: " + pacoteIn.getPort());
      String info = "Pacote UDP recebido!";
      byte[] buffer = info.getBytes();
      DatagramPacket pacoteOut = 
           new DatagramPacket(buffer, 
                buffer.length,
                pacoteIn.getAddress(),
                pacoteIn.getPort());
      cliente.send(pacoteOut);
      cliente.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }
}