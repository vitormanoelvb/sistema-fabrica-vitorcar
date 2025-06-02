/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fabrica;

/**
 *
 * @author Vitor
 */
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private ArrayList<Carro> carros; // <- Aqui

    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.carros = new ArrayList<>(); // <- Inicializa lista
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }
}