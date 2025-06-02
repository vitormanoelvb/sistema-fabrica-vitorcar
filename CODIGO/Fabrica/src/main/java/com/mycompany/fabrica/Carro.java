/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fabrica;

/**
 *
 * @author Vitor
 */
public class Carro {
   private String modelo;
   private String placa;
   private int anoFabricacao; // atributo numerico
   
   public Carro(String modelo, String placa, int anoFabricacao) {
       this.modelo = modelo;
       this.placa = placa;
       this.anoFabricacao = anoFabricacao;
   }
   
   public String getModelo() { return modelo; }
   public void setModelo(String modelo) { this.modelo = modelo; }
   
   public String getPlaca() { return placa; }
   public void setPlaca(String placa) { this.placa = placa; }
   
   public int getAnoFabricacao() { return anoFabricacao; }
   public void setAnoFabricacao(int anoFabricacao) { this.anoFabricacao = anoFabricacao; }
}
