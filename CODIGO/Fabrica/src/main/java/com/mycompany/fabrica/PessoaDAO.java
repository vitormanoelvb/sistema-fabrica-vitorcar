/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fabrica;

/**
 *
 * @author Vitor
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    public static boolean excluirPessoaPorCpf(String cpf) {
        String buscarMenorSQL = "SELECT cpf_menor FROM termo_autorizacao WHERE cpf_responsavel = ?";
        String buscarResponsavelSQL = "SELECT cpf_responsavel FROM termo_autorizacao WHERE cpf_menor = ?";
        String excluirCarrosSQL = "DELETE FROM carro WHERE id_pessoa = (SELECT id FROM pessoa WHERE cpf = ?)";
        String excluirTermoSQL = "DELETE FROM termo_autorizacao WHERE cpf_menor = ?";
        String excluirPessoaSQL = "DELETE FROM pessoa WHERE cpf = ?";

        try (Connection conn = ConexaoBD.conectar()) {
            if (conn == null) return false;

            // 🔍 1. Verifica se CPF pertence a um responsável
            String cpfMenor = null;
            try (PreparedStatement buscarMenor = conn.prepareStatement(buscarMenorSQL)) {
                buscarMenor.setString(1, cpf);
                ResultSet rs = buscarMenor.executeQuery();
                if (rs.next()) {
                    cpfMenor = rs.getString("cpf_menor");
                }
            }

            // 🔍 2. Verifica se CPF pertence a um menor
            String cpfResponsavel = null;
            try (PreparedStatement buscarResp = conn.prepareStatement(buscarResponsavelSQL)) {
                buscarResp.setString(1, cpf);
                ResultSet rs = buscarResp.executeQuery();
                if (rs.next()) {
                    cpfResponsavel = rs.getString("cpf_responsavel");
                }
            }

            // 🧽 3. Se for responsável → exclui menor + termo
            if (cpfMenor != null) {
                try (PreparedStatement stmt1 = conn.prepareStatement(excluirCarrosSQL)) {
                    stmt1.setString(1, cpfMenor);
                    stmt1.executeUpdate();
                }
                try (PreparedStatement stmt2 = conn.prepareStatement(excluirPessoaSQL)) {
                    stmt2.setString(1, cpfMenor);
                    stmt2.executeUpdate();
                }
                try (PreparedStatement stmt3 = conn.prepareStatement(excluirTermoSQL)) {
                    stmt3.setString(1, cpfMenor);
                    stmt3.executeUpdate();
                }
            }

            // 🧽 4. Se for menor → exclui termo + responsável (se estiver cadastrado)
            if (cpfResponsavel != null) {
                try (PreparedStatement stmt1 = conn.prepareStatement(excluirCarrosSQL)) {
                    stmt1.setString(1, cpfResponsavel);
                    stmt1.executeUpdate();
                }
                try (PreparedStatement stmt2 = conn.prepareStatement(excluirPessoaSQL)) {
                    stmt2.setString(1, cpfResponsavel);
                    stmt2.executeUpdate();
                }
                try (PreparedStatement stmt3 = conn.prepareStatement(excluirTermoSQL)) {
                    stmt3.setString(1, cpf);
                    stmt3.executeUpdate();
                }
            }

            // 🧽 5. Exclui os carros da pessoa principal (se ainda não foi)
            try (PreparedStatement stmtCarros = conn.prepareStatement(excluirCarrosSQL)) {
                stmtCarros.setString(1, cpf);
                stmtCarros.executeUpdate();
            }

            // 🧽 6. Exclui a pessoa principal (responsável ou menor)
            try (PreparedStatement stmtPessoa = conn.prepareStatement(excluirPessoaSQL)) {
                stmtPessoa.setString(1, cpf);
                int linhasAfetadas = stmtPessoa.executeUpdate();
                return linhasAfetadas > 0;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao excluir pessoa, responsavel ou menor: " + e.getMessage());
            return false;
        }
    }
}