package clienteudp;

import java.net.*;
import java.io.*;

public class ClienteUDP {
  private static DatagramSocket servidor;
  public static void main(String[] args) {
    try {
      servidor = new DatagramSocket();
      InetAddress addr = 
         InetAddress.getByName("localhost");
      String info = "Pacote via UDP!";
      byte[] buffer = info.getBytes();
      DatagramPacket pacoteOut = 
         new DatagramPacket(buffer,
            buffer.length, addr, 4545);
      servidor.send(pacoteOut);
      DatagramPacket pacoteIn = 
         new DatagramPacket(new byte[512],512);
      servidor.receive(pacoteIn);
      System.out.println(
         new String(pacoteIn.getData()));
      System.out.println(
         "Bytes: " + pacoteIn.getData() 
         + "\nTamanho: " + pacoteIn.getLength()
         + "\nIP: " + pacoteIn.getAddress()
         + "\nPorta: " + pacoteIn.getPort());
      servidor.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }
}