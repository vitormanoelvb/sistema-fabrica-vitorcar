/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fabrica;

/**
 *
 * @author Vitor
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.Desktop;
import java.net.URI;

public class Fabrica {

    public static void main(String[] args) throws InterruptedException {
        limparTela();
        System.out.println("===============================================================");
        System.out.println("=               ATENCAO - ANTES DE CONTINUAR...               =");
        System.out.println("===============================================================");
        System.out.println("= Para melhor visualizacao do sistema, recomendo:             =");
        System.out.println("= -> Aumentar o tamanho da tela do terminal da IDE            =");
        System.out.println("= -> (Ex: Eclipse, IntelliJ, NetBeans, VS Code, etc.)         =");
        System.out.println("= -> Usar o terminal em tela cheia, se possivel               =");
        System.out.println("=                                                             =");
        System.out.println("= Isso garantira uma melhor leitura dos menus e relatorios.   =");
        System.out.println("===============================================================");
        System.out.print("\nPressione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
        limparTela();
        
        System.out.println("=====================================");
        System.out.println("==  DESENVOLVIDO POR VITOR MANOEL  ==");
        System.out.println("=====================================");
        Thread.sleep(1500);
        limparTela();

        System.out.println("==================================");
        System.out.println("==          VM SYSTEMS          ==");
        System.out.println("==================================");
        Thread.sleep(1500);
        limparTela();
        
        System.out.println("=================================");
        System.out.println("== VM ENGINE DEVELOPMENT V:1.5 ==");
        System.out.println("=================================");
        Thread.sleep(1500);
        limparTela();

        System.out.println("================================");
        System.out.println("== SISTEMA - FABRICA VITORCAR ==");
        System.out.println("================================");
        Thread.sleep(1500);
        limparTela();

        // ========================
        // EXEMPLO DE ERRO PROPOSITAL
        // ========================
        
        // Este exemplo abaixo causaria erro de compilação
        // pois tenta acessar diretamente o atributo 'nome' da classe Pessoa.
        // Como o atributo é privado, só pode ser acessado via get/set:
        
        // Pessoa exemplo = new Pessoa("Teste", 20, "00000000000");
        // exemplo.nome = "Outro nome"; // ← Erro proposital: 'nome' tem acesso privado

        exibirMenuPrincipal();
    }

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void exibirMenuPrincipal() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dadosResponsaveis = new HashMap<>();
        HashMap<String, ArrayList<String>> historicoManutencao = new HashMap<>();
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<String> menoresComTermoAssinado = new ArrayList<>();
        ArrayList<String> placasRegistradas = new ArrayList<>();
        int opcao;
        do {
            System.out.println("==========================================");
            System.out.println("==      SISTEMA - FABRICA VITORCAR      ==");
            System.out.println("==========================================");
            System.out.println("=|--------------------------------------|=");
            System.out.println("=|  1 - Cadastrar Pessoa                |=");
            System.out.println("=|  2 - Cadastrar Carro                 |=");
            System.out.println("=|  3 - Visualizar Dados                |=");
            System.out.println("=|  4 - Area Administrativa             |=");
            System.out.println("=|  5 - Creditos                        |=");
            System.out.println("=|  6 - Sobre o Sistema                 |=");
            System.out.println("=|  7 - Sair                            |=");
            System.out.println("=|--------------------------------------|=");
            System.out.println("==========================================");
            System.out.print("Selecione uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                
                case 1:
                    boolean cancelado = false;
                    limparTela();
                    System.out.println("======================");
                    System.out.println("= CADASTRO DE PESSOA =");
                    System.out.println("======================");

                    String cpf;
                    while (true) {
                        System.out.print("CPF (ou digite 0 para cancelar): ");
                        cpf = sc.nextLine().replaceAll("[^0-9]", "").trim();

                        if (cpf.equals("0")) {
                            System.out.print("Tem certeza que deseja cancelar o cadastro? (S/N): ");
                            String confirma = sc.nextLine().trim().toUpperCase();
                            if (confirma.equals("S")) {
                                System.out.println("\nCadastro cancelado. Retornando ao menu...");
                                Thread.sleep(1500);
                                limparTela();
                                cancelado = true;
                                break;
                            } else {
                                System.out.println("\nContinuando cadastro...");
                                continue;
                            }
                        }

                        if (cpf.matches("\\d{11}")) {
                            cpf = cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                            break;
                        } else {
                            System.out.println("CPF invalido! Digite 11 numeros.");
                        }
                    }

                    if (cancelado) break;

                    boolean cpfExiste = false;
                    for (Pessoa p : pessoas) {
                        if (p.getCpf().equals(cpf)) {
                            cpfExiste = true;
                            break;
                        }
                    }

                    if (cpfExiste) {
                        System.out.println("\nCPF ja cadastrado. Cada pessoa deve ter um CPF unico.");
                        Thread.sleep(1500);
                        limparTela();
                        break;
                    }

                    String nome;
                    while (true) {
                        System.out.print("Nome (ou digite 0 para cancelar): ");
                        nome = sc.nextLine().trim();

                        if (nome.equals("0")) {
                            System.out.print("Tem certeza que deseja cancelar o cadastro? (S/N): ");
                            String confirma = sc.nextLine().trim().toUpperCase();
                            if (confirma.equals("S")) {
                                System.out.println("\nCadastro cancelado. Retornando ao menu...");
                                Thread.sleep(1500);
                                limparTela();
                                cancelado = true;
                                break;
                            } else {
                                System.out.println("\nContinuando cadastro...");
                                continue;
                            }
                        }

                        if (nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                            break;
                        } else {
                            System.out.println("Nome invalido! Use apenas letras e espacos.");
                        }
                    }

                    if (cancelado) break;

                    int idade = 0;
                    while (true) {
                        System.out.print("Idade (ou digite 0 para cancelar): ");
                        String entradaIdade = sc.nextLine().trim();

                        if (entradaIdade.equals("0")) {
                            System.out.print("Tem certeza que deseja cancelar o cadastro? (S/N): ");
                            String confirma = sc.nextLine().trim().toUpperCase();
                            if (confirma.equals("S")) {
                                System.out.println("\nCadastro cancelado. Retornando ao menu...");
                                Thread.sleep(1500);
                                limparTela();
                                cancelado = true;
                                break;
                            } else {
                                System.out.println("\nContinuando cadastro...");
                                continue;
                            }
                        }

                        if (entradaIdade.matches("\\d{1,3}")) {
                            idade = Integer.parseInt(entradaIdade);
                            if (idade > 0 && idade <= 120) {
                                break;
                            } else {
                                System.out.println("Idade invalida! Digite um valor entre 1 e 120.");
                            }
                        } else {
                            System.out.println("Entrada invalida! Digite apenas numeros.");
                        }
                    }
                    
                    if (cancelado) break;
                       
                    pessoas.add(new Pessoa(nome, idade, cpf));
                    System.out.println("\nPessoa cadastrada com sucesso!");
                    Thread.sleep(1500);
                    limparTela();
                    break;
        
               case 2:
               boolean cancelarCarro = false;
               limparTela();
               System.out.println("=====================");
               System.out.println("= CADASTRO DE CARRO =");
               System.out.println("=====================");
               System.out.print("CPF do dono do carro (ou digite 0 para cancelar): ");
               String cpfBusca = sc.nextLine().trim();

               if (cpfBusca.equals("0")) {
                   System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                   String confirma = sc.nextLine().trim().toUpperCase();
                   if (confirma.equals("S")) {
                       System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                       Thread.sleep(1500);
                       limparTela();
                       break;
                   } else {
                       System.out.println("\nContinuando cadastro de carro...");
                   }
               }
               
               Pessoa pessoaEncontrada = null;
               for (Pessoa p : pessoas) {
                   if (p.getCpf().equals(cpfBusca)) {
                       pessoaEncontrada = p;
                       break;
                   }
               }
               
               if (pessoaEncontrada != null) {
                   boolean menorComTermoAutorizado = false;
                   
                   if (pessoaEncontrada.getIdade() < 18) {
                       if (menoresComTermoAssinado.contains(pessoaEncontrada.getCpf())) {
                           menorComTermoAutorizado = true;
                       } else {
                           System.out.println("\nMenor de idade detectado (Idade: " + pessoaEncontrada.getIdade() + " anos)");

                           String nomeResponsavel;
                           while (true) {
                               System.out.print("Nome do responsavel legal (ou 0 para cancelar): ");
                               nomeResponsavel = sc.nextLine().trim();

                               if (nomeResponsavel.equals("0")) {
                                   System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                                   String confirma = sc.nextLine().trim().toUpperCase();
                                   if (confirma.equals("S")) {
                                       System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                                       Thread.sleep(1500);
                                       limparTela();
                                       break;
                                   } else {
                                       System.out.println("\nContinuando cadastro de carro...");
                                       continue;
                                   }
                               }
                               
                               if (nomeResponsavel.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                                   break;
                               } else {
                                   System.out.println("Nome invalido! Use apenas letras e espacos.");
                               }
                           }

                           if (nomeResponsavel.equals("0")) {
                               System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                               String confirma = sc.nextLine().trim().toUpperCase();
                               if (confirma.equals("S")) {
                                   System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                                   Thread.sleep(1500);
                                   limparTela();
                                   break;
                               } else {
                                   System.out.println("\nContinuando cadastro de carro...");
                               }
                           }
                           
                           String cpfResponsavel;
                           while (true) {
                               System.out.print("CPF do responsavel (ou 0 para cancelar): ");
                               cpfResponsavel = sc.nextLine().replaceAll("[^0-9]", "").trim();
                               
                               if (cpfResponsavel.equals("0")) {
                                   System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                                   String confirma = sc.nextLine().trim().toUpperCase();
                                   if (confirma.equals("S")) {
                                       System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                                       Thread.sleep(1500);
                                       limparTela();
                                       break;
                                   } else {
                                       System.out.println("\nContinuando cadastro de carro...");
                                       continue;
                                   }
                                }

                                if (cpfResponsavel.matches("\\d{11}")) {
                                    cpfResponsavel = cpfResponsavel.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                                    break;
                                } else {
                                    System.out.println("CPF invalido! Digite exatamente 11 numeros.");
                                }
                           }
           
                           if (cpfResponsavel.equals("0")) {
                               System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                               String confirma = sc.nextLine().trim().toUpperCase();
                               if (confirma.equals("S")) {
                                   System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                                   Thread.sleep(1500);
                                   limparTela();
                                   break;
                               } else {
                                   System.out.println("\nContinuando cadastro de carro...");
                               }
                           }

                String data;
                while (true) {
                    System.out.print("Data de autorizacao (DD/MM/AAAA) (ou 0 para cancelar): ");
                    data = sc.nextLine().trim();

                    if (data.equals("0")) {
                    System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                    String confirma = sc.nextLine().trim().toUpperCase();
                    if (confirma.equals("S")) {
                        System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                        Thread.sleep(1500);
                        limparTela();
                        break;
                    } else {
                        System.out.println("\nContinuando cadastro de carro...");
                        continue;
                    }
                }

                try {
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataDigitada = LocalDate.parse(data, formato);
                    LocalDate hoje = LocalDate.now();

                    if (dataDigitada.isAfter(hoje)) {
                        System.out.println("Data invalida! Nao pode ser uma data futura.");
                    } else {
                        break; 
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Formato invalido! Use DD/MM/AAAA.");
                }
            }

                if (data.equals("0")) {
                    System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                    String confirma = sc.nextLine().trim().toUpperCase();
                    if (confirma.equals("S")) {
                        System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                        Thread.sleep(1500);
                        limparTela();
                        break;
                    } else {
                        System.out.println("\nContinuando cadastro de carro...");
                    }
                }

                limparTela();
                System.out.println("================================================================");
                System.out.println("|     TERMO DE AUTORIZACAO PARA CADASTRO DE MENOR DE IDADE     |");
                System.out.println("================================================================");
                System.out.println("Eu, " + nomeResponsavel + ", portador(a) do CPF N. " + cpfResponsavel + ",");
                System.out.println("na qualidade de responsavel legal pelo menor abaixo identificado:\n");
                System.out.println("Nome do Menor: " + pessoaEncontrada.getNome());
                System.out.println("Idade: " + pessoaEncontrada.getIdade());
                System.out.println("CPF do Menor: " + pessoaEncontrada.getCpf());
                System.out.println();
                System.out.println("AUTORIZO o cadastro do(a) menor acima mencionado(a) no sistema da");
                System.out.println("SISTEMA FABRICA VITORCAR, para fins de vinculacao ao veiculo a ser");
                System.out.println("cadastrado no nome do(a) mesmo(a), sob minha total responsabilidade.\n");
                System.out.println("Declaro estar ciente de que este procedimento e de minha livre vontade");
                System.out.println("e que assumo total responsabilidade pelas informacoes fornecidas, bem como");
                System.out.println("por qualquer compromisso assumido em nome do menor.\n");
                System.out.println("OBS.: Este termo so podera ser assinado uma unica vez. Apos a autorizacao, o");
                System.out.println("menor estara permanentemente habilitado para cadastro de veiculos no sistema.");
                System.out.println();
                System.out.println("Data: " + data);
                System.out.println("Assinatura do Responsavel: " + nomeResponsavel.toUpperCase());
                System.out.println("================================================================");
                System.out.print("\nPressione ENTER para continuar o cadastro...");
                sc.nextLine();

                menoresComTermoAssinado.add(pessoaEncontrada.getCpf());
                dadosResponsaveis.put(pessoaEncontrada.getCpf(), nomeResponsavel + " (CPF: " + cpfResponsavel + ")");
                menorComTermoAutorizado = true;
            }
        }

        if (pessoaEncontrada.getIdade() >= 18 || menorComTermoAutorizado) {
            limparTela();
            System.out.println("=====================");
            System.out.println("= CADASTRO DE CARRO =");
            System.out.println("=====================");

            System.out.print("Modelo (ou 0 para cancelar): ");
            String modelo = sc.nextLine();
            if (modelo.equals("0")) {
                System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                String confirma = sc.nextLine().trim().toUpperCase();
                if (confirma.equals("S")) {
                    System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                    Thread.sleep(1500);
                    limparTela();
                    break;
                } else {
                    System.out.println("\nContinuando cadastro de carro...");
                }
            }

            String placa;
            while (true) {
                System.out.print("Placa (ou 0 para cancelar): ");
                placa = sc.nextLine().toUpperCase().trim();

                if (placa.equals("0")) {
                    System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                    String confirma = sc.nextLine().trim().toUpperCase();
                    if (confirma.equals("S")) {
                        System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                        Thread.sleep(1500);
                        limparTela();
                        cancelarCarro = true;
                        break;
                    } else {
                        System.out.println("\nContinuando cadastro de carro...");
                        continue;
                    }
                }
                
                if (!placa.matches("^[A-Z]{3}\\d{4}$") && !placa.matches("^[A-Z]{3}\\d[A-Z]\\d{2}$")) {
                    System.out.println("Placa invalida! Use o formato ABC1234 ou BRA1A23.");
                    continue;
                }

                if (placasRegistradas.contains(placa)) {
                    System.out.println("\nPlaca ja cadastrada! Cada carro deve ter uma placa unica.");
                } else {
                    break;
                }
            }

            if (cancelarCarro) break;

            int anoAtual = java.time.Year.now().getValue();
            int ano = 0;
            while (true) {
                System.out.print("Ano de Fabricacao (ou 0 para cancelar): ");
                String entradaAno = sc.nextLine();
                if (entradaAno.equals("0")) {
                    System.out.print("Deseja realmente cancelar o cadastro do carro? (S/N): ");
                    String confirma = sc.nextLine().trim().toUpperCase();
                    if (confirma.equals("S")) {
                        System.out.println("\nCadastro de carro cancelado. Retornando ao menu...");
                        Thread.sleep(1500);
                        limparTela();
                        cancelarCarro = true;
                        break;
                    } else {
                        System.out.println("\nContinuando cadastro de carro...");
                        continue;
                    }
                }

                if (entradaAno.matches("\\d{4}")) {
                    ano = Integer.parseInt(entradaAno);
                    if (ano >= 1886 && ano <= anoAtual) {
                        break;
                    } else {
                        System.out.println("Ano invalido! Digite um valor entre 1886 e " + anoAtual + ".");
                    }
                } else {
                    System.out.println("Entrada invalida! Digite apenas numeros com 4 digitos.");
                }
            }

            if (cancelarCarro) break;

            Carro novoCarro = new Carro(modelo, placa, ano);
            pessoaEncontrada.adicionarCarro(novoCarro);
            placasRegistradas.add(placa);

            System.out.println("\nCarro cadastrado com sucesso para " + pessoaEncontrada.getNome() + "!");
            Thread.sleep(1500);
            limparTela();
        }
    } else {
        System.out.println("CPF nao encontrado. Cadastre a pessoa primeiro.");
        Thread.sleep(1500);
        limparTela();
    }
    break;

                case 3:
                    limparTela();
                    System.out.println("==========================");
                    System.out.println("=== RELATORIO DE DADOS ===");
                    System.out.println("==========================");

                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        for (Pessoa p : pessoas) {
                            System.out.println("\nPessoa:");
                            System.out.println("- Nome: " + p.getNome());
                            System.out.println("- Idade: " + p.getIdade());
                            System.out.println("- CPF: " + p.getCpf());

                            if (p.getIdade() < 18 && dadosResponsaveis.containsKey(p.getCpf())) {
                                System.out.println("  Menor de idade. Responsavel legal:");
                                System.out.println("  -> " + dadosResponsaveis.get(p.getCpf()));
                            }

                            if (!p.getCarros().isEmpty()) {
                                System.out.println("  Carros:");
                                for (Carro c : p.getCarros()) {
                                    System.out.println("    -> Modelo: " + c.getModelo() + ", Placa: " + c.getPlaca() + ", Ano: " + c.getAnoFabricacao());
                                    
                                    if (historicoManutencao.containsKey(c.getPlaca())) {
                                        System.out.println("      Historico de manutencao:");
                                        for (String m : historicoManutencao.get(c.getPlaca())) {
                                            System.out.println("        - " + m);
                                        }
                                    }
                                }
                            } else {
                                System.out.println("  Nenhum carro cadastrado.");
                            }
                        }
                    }            

                    System.out.print("\nPressione ENTER para voltar ao menu...");
                    sc.nextLine();
                    limparTela();
                    break;

                    case 4:
                        limparTela();
                        System.out.println("=========================================");
                        System.out.println("=|        ACESSO RESTRITO - ADM        |=");
                        System.out.println("=========================================");
                        System.out.println("= Somente funcionarios autorizados.     =");
                        System.out.println("-----------------------------------------");
                        System.out.print("Usuario: ");
                        String usuario = sc.nextLine();
                        System.out.print("Senha: ");
                        String senha = sc.nextLine();
                        
                        if (usuario.equals("admin") && senha.equals("1234")) {
                            boolean sairADM = false;
                            do {
                                limparTela();
                                System.out.println("==================================================");
                                System.out.println("==           SISTEMA - FABRICA VITORCAR         ==");
                                System.out.println("==             AREA ADMINISTRATIVA              ==");
                                System.out.println("==================================================");
                                System.out.println("|                                                |");
                                System.out.println("|  1 - Estatisticas do Sistema                   |");
                                System.out.println("|  2 - Simulacao de Manutencao                   |");
                                System.out.println("|  3 - Listar Todos os Carros Cadastrados        |");
                                System.out.println("|  4 - Listar Todas as Pessoas Cadastradas       |");
                                System.out.println("|  5 - Listar Somente Menores de Idade           |");
                                System.out.println("|  6 - Remover Dados (Pessoa e Carro)            |");
                                System.out.println("|  7 - Voltar ao Menu Principal                  |");
                                System.out.println("|                                                |");
                                System.out.println("==================================================");
                                System.out.print("Selecione uma opcao: ");
                                String subOpcao = sc.nextLine();

                                switch (subOpcao) {
                case "1":
                    limparTela();
                    exibirEstatisticas(pessoas);
                    break;

                case "2":
                    limparTela();
                    simularManutencao(pessoas, historicoManutencao, sc);
                    break;

                case "3":
                    limparTela();
                    System.out.println("=== LISTA DE CARROS CADASTRADOS ===");
                    for (Pessoa p : pessoas) {
                        for (Carro c : p.getCarros()) {
                            System.out.println("Dono: " + p.getNome() + " | Modelo: " + c.getModelo() + " | Placa: " + c.getPlaca());
                        }
                    }
                    System.out.print("\nPressione ENTER para continuar...");
                    sc.nextLine();
                    break;

                case "4":
                    limparTela();
                    System.out.println("=== LISTA DE PESSOAS CADASTRADAS ===");
                    for (Pessoa p : pessoas) {
                        System.out.println("Nome: " + p.getNome() + " | CPF: " + p.getCpf() + " | Idade: " + p.getIdade());
                    }
                    System.out.print("\nPressione ENTER para continuar...");
                    sc.nextLine();
                    break;

                case "5":
                    limparTela();
                    System.out.println("=== MENORES DE IDADE CADASTRADOS ===");
                    for (Pessoa p : pessoas) {
                        if (p.getIdade() < 18) {
                            System.out.println("Nome: " + p.getNome() + " | Idade: " + p.getIdade() + " | CPF: " + p.getCpf());
                        }
                    }
                    System.out.print("\nPressione ENTER para continuar...");
                    sc.nextLine();
                    break;

                case "6":
                    limparTela();
                    System.out.print("Digite o CPF da pessoa que deseja excluir: ");
                    String cpfExcluir = sc.nextLine().trim();
                    
                    Pessoa pessoaRemover = null;
                    for (Pessoa p : pessoas) {
                        if (p.getCpf().equals(cpfExcluir)) {
                            pessoaRemover = p;
                            break;
                        }
                    }
                    
                    if (pessoaRemover != null) {
                        // Remove do banco de dados usando PessoaDAO
                        if (PessoaDAO.excluirPessoaPorCpf(cpfExcluir)) {
                            pessoas.remove(pessoaRemover); // Remove da lista local
                            System.out.println("Pessoa e carros removidos com sucesso do sistema!");
                        } else {
                            System.out.println("Erro ao excluir do banco de dados.");
                        }
                    } else {
                        System.out.println("CPF nao encontrado.");
                    }

                    Thread.sleep(1500);
                    limparTela();
                    break;

                case "7":
                    System.out.print("Deseja voltar ao menu principal? (S/N): ");
                    String confirmar = sc.nextLine().trim().toUpperCase();
                    if (confirmar.equals("S")) {
                        System.out.println("Retornando...");
                        Thread.sleep(1000);
                        limparTela();
                        sairADM = true;
                    } else {
                        System.out.println("Permanecendo na area administrativa...");
                        Thread.sleep(1000);
                    }
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    Thread.sleep(1000);
            }
        } while (!sairADM);
    } else {
        System.out.println("\nNao e funcionario autorizado.");
        System.out.print("Deseja voltar ao menu principal? (S/N): ");
        String voltar = sc.nextLine().toUpperCase();
        if (voltar.equals("S")) {
            System.out.println("Retornando...");
            Thread.sleep(1000);
            limparTela();
        } else {
            System.out.println("Acesso negado.");
            Thread.sleep(1500);
            limparTela();
        }
    }
    break;

      
                case 5:
                    limparTela();
                    System.out.println("============================================");
                    System.out.println("=   CREDITOS: SISTEMA - FABRICA VITORCAR   =");
                    System.out.println("============================================");
                    System.out.println("= Sistema - Fabrica VitorCar               =");
                    System.out.println("= Desenvolvido em Java com POO             =");
                    System.out.println("= Utilizando as classes:                   =");
                    System.out.println("= -> Fabrica (Main)                        =");
                    System.out.println("= -> Pessoa                                =");
                    System.out.println("= -> Carro                                 =");
                    System.out.println("=------------------------------------------=");
                    System.out.println("= Autor: Vitor Manoel Vidal Braz           =");
                    System.out.println("= Orientacao: Vitor Silva Ribeiro          =");
                    System.out.println("= Univale - 3o periodo de SI               =");
                    System.out.println("= Disciplina de POO                        =");
                    System.out.println("=------------------------------------------=");
                    System.out.println("= Desenvolvimento curto com o motor        =");
                    System.out.println("= grafico de console VM ENGINE DEVELOPMENT =");
                    System.out.println("= Versao 1.5                                =");
                    System.out.println("============================================");
                    System.out.print("\nPressione ENTER para voltar ao menu...");
                    sc.nextLine();
                    limparTela();
                    break;

                case 6:
                    limparTela();
                    sobreOSistema();
                    break;
                    
                case 7:
                    String confirmarSaida;
                    while (true) {
                        System.out.print("\nDeseja realmente sair? (S/N): ");
                        confirmarSaida = sc.nextLine().trim().toUpperCase();
                    
                        if (confirmarSaida.equals("S") || confirmarSaida.equals("N")) {
                            break;
                        } else {
                            System.out.println("Entrada invalida! Digite apenas 'S' para Sim ou 'N' para Nao.");
                        }
                    }

                   if (confirmarSaida.equals("S")) {
                       limparTela();
                       System.out.println("============================");
                       System.out.println("= Finalizando o sistema... =");
                       System.out.println("============================");
                       Thread.sleep(1500);
                       limparTela();
                       System.out.println("=============================================");
                       System.out.println("= Obrigado por utilizar o SISTEMA VITORCAR! =");
                       System.out.println("=============================================");
                       Thread.sleep(2000);
                       opcao = 7;
                   } else {
                       System.out.println("\nRetornando ao menu principal...");
                       Thread.sleep(1000);
                       limparTela();
                       opcao = -1; 
                   }
                   break;
            }

        } while (opcao != 7);

        sc.close();
    }

public static void sobreOSistema() {
    Scanner sc = new Scanner(System.in);

    System.out.println();
    System.out.println(" __      __ __  __     _____  __     _______ _______ __  __ ");
    System.out.println(" \\ \\    / /|  \\/  |   / ____| \\ \\   / / ____|__   __|  \\/  |");
    System.out.println("  \\ \\  / / | \\  / |  | (___    \\ \\_/ / (___    | |  | \\  / |");
    System.out.println("   \\ \\/ /  | |\\/| |   \\___ \\    \\   / \\___ \\   | |  | |\\/| |");
    System.out.println("    \\  /   | |  | |   ____) |    | |  ____) |  | |  | |  | |");
    System.out.println("     \\/    |_|  |_|  |_____/     |_| |_____/   |_|  |_|  |_|");
    System.out.println("                        V M   S Y S T E M S                  ");
    System.out.println();
    System.out.println("Sistema desenvolvido com a engine: VM ENGINE DEVELOPMENT v1.5");
    System.out.println("Desenvolvedor: Vitor Manoel Vidal Braz");
    System.out.println("GitHub: https://github.com/vitormanoelvb");
    System.out.println("Pagina do Codigo no GitHub: https://github.com/vitormanoelvb/sistema-fabrica-vitorcar");
    System.out.println();

    System.out.print("Deseja abrir o perfil do GitHub? (s/n): ");
    String opcaoPerfil = sc.nextLine().trim().toLowerCase();
    if (opcaoPerfil.equals("s")) {
        abrirLink("https://github.com/vitormanoelvb");
    }

    System.out.print("Deseja abrir a pagina do codigo no GitHub? (s/n): ");
    String opcaoCodigo = sc.nextLine().trim().toLowerCase();
    if (opcaoCodigo.equals("s")) {
        abrirLink("https://github.com/vitormanoelvb/sistema-fabrica-vitorcar");
    }

    System.out.println();
    System.out.println("Pressione ENTER para voltar ao menu principal...");
    sc.nextLine(); 
    limparTela();
}

public static void abrirLink(String url) {
    try {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(url));
            System.out.println("Link aberto no navegador.");
        } else {
            System.out.println("Desktop nao suportado neste ambiente.");
        }
    } catch (Exception e) {
        System.out.println("Erro ao tentar abrir o link: " + e.getMessage());
    }
}

                public static void simularManutencao(ArrayList<Pessoa> pessoas, HashMap<String, ArrayList<String>> historicoManutencao, Scanner sc) throws InterruptedException {
                    limparTela();
                    System.out.println("======================================");
                    System.out.println("=        SIMULACAO DE MANUTENCAO     =");
                    System.out.println("======================================");
                    System.out.print("Informe o CPF do dono do carro (ou 0 para cancelar): ");
                    String cpf = sc.nextLine().trim();

                    if (cpf.equals("0")) {
                        System.out.println("Operacao cancelada.");
                        Thread.sleep(1000);
                        limparTela();
                        return;
                    }

                    Pessoa pessoa = null;
                    for (Pessoa p : pessoas) {
                        if (p.getCpf().equals(cpf)) {
                            pessoa = p;
                            break;
                        }
                    }

                    if (pessoa == null) {
                        System.out.println("CPF nao encontrado.");
                        Thread.sleep(1500);
                        limparTela();
                        return;
                    }

                    if (pessoa.getCarros().isEmpty()) {
                        System.out.println("Essa pessoa nao possui carros cadastrados.");
                        Thread.sleep(1500);
                        limparTela();
                        return;
                    }

                    System.out.println("\nCarros do(a) " + pessoa.getNome() + ":");
                    for (int i = 0; i < pessoa.getCarros().size(); i++) {
                        Carro c = pessoa.getCarros().get(i);
                        System.out.println((i + 1) + " - Modelo: " + c.getModelo() + " | Placa: " + c.getPlaca());
                    }

                    System.out.print("Selecione o carro pelo numero (ou 0 para cancelar): ");
                    String entrada = sc.nextLine().trim();
                    if (entrada.equals("0")) {
                        System.out.println("Operacao cancelada.");
                        Thread.sleep(1000);
                        limparTela();
                        return;
                    }

                    int escolha;
                    try {
                        escolha = Integer.parseInt(entrada) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada invalida!");
                        Thread.sleep(1000);
                        limparTela();
                        return;
                    }

                    if (escolha < 0 || escolha >= pessoa.getCarros().size()) {
                        System.out.println("Escolha invalida.");
                        Thread.sleep(1500);
                        limparTela();
                        return;
                    }

                    Carro carroEscolhido = pessoa.getCarros().get(escolha);
                    String placa = carroEscolhido.getPlaca();

                    System.out.println("\n=== Historico de manutencao da placa " + placa + " ===");
                    if (historicoManutencao.containsKey(placa)) {
                        for (String item : historicoManutencao.get(placa)) {
                             System.out.println("- " + item);
                        }
                    } else {
                        System.out.println("Nenhuma manutencao registrada ainda.");
                    }

                    System.out.println("\nTipos de manutencao disponiveis:");
                    System.out.println("1 - Revisao");
                    System.out.println("2 - Troca de oleo");
                    System.out.println("3 - Troca de pneu");
                    System.out.print("Escolha o tipo (ou 0 para cancelar): ");
                    String tipo = sc.nextLine().trim();

                    if (tipo.equals("0")) {
                        System.out.println("Operacao cancelada.");
                        Thread.sleep(1000);
                        limparTela();
                        return;
                    }

                    String manutencao = switch (tipo) {
                        case "1" -> "Revisao em " + LocalDate.now();
                        case "2" -> "Troca de oleo em " + LocalDate.now();
                        case "3" -> "Troca de pneu em " + LocalDate.now();
                        default -> null;
                    };

                    if (manutencao == null) {
                        System.out.println("Tipo de manutencao invalido.");
                        Thread.sleep(1500);
                        limparTela();
                        return;
                    }

                    System.out.print("\nConfirmar registro da manutencao \"" + manutencao + "\"? (S/N): ");
                    String confirmacao = sc.nextLine().trim().toUpperCase();

                    if (!confirmacao.equals("S")) {
                        System.out.println("Operacao cancelada.");
                        Thread.sleep(1000);
                        limparTela();
                        return;
                    }

                    historicoManutencao.putIfAbsent(placa, new ArrayList<>());
                    historicoManutencao.get(placa).add(manutencao);

                    System.out.println("Manutencao registrada com sucesso!");
                    Thread.sleep(1500);
                    limparTela();
                }
    
    public static void exibirEstatisticas(ArrayList<Pessoa> pessoas) {
        System.out.println("=========================================");
        System.out.println("=        ESTATISTICAS DA FABRICA        =");
        System.out.println("=========================================");

        int totalPessoas = pessoas.size();
        int totalCarros = 0;
        int somaIdades = 0;
        int anoMaisAntigo = Integer.MAX_VALUE;
        ArrayList<Carro> carrosMaisAntigos = new ArrayList<>();

        for (Pessoa p : pessoas) {
            somaIdades += p.getIdade();
            for (Carro c : p.getCarros()) {
                totalCarros++;
                if (c.getAnoFabricacao() < anoMaisAntigo) {
                    anoMaisAntigo = c.getAnoFabricacao();
                    carrosMaisAntigos.clear();
                    carrosMaisAntigos.add(c);
                } else if (c.getAnoFabricacao() == anoMaisAntigo) {
                    carrosMaisAntigos.add(c);
                }
            }
        }

        System.out.println("Total de pessoas cadastradas: " + totalPessoas);
        System.out.println("Total de carros cadastrados: " + totalCarros);

        if (totalPessoas > 0) {
            double mediaIdade = (double) somaIdades / totalPessoas;
            System.out.printf("Media de idade das pessoas: %.2f anos\n", mediaIdade);
        } else {
            System.out.println("Media de idade: N/A");
        }

        if (totalCarros > 0) {
            System.out.println("Carro(s) mais antigo(s) (Ano " + anoMaisAntigo + "):");
            for (Carro c : carrosMaisAntigos) {
                System.out.println("- Modelo: " + c.getModelo() + " | Placa: " + c.getPlaca());
            }
        } else {
            System.out.println("Nenhum carro cadastrado.");
        }

        System.out.println("=========================================");
        System.out.print("\nPressione ENTER para voltar ao menu...");
        new Scanner(System.in).nextLine();
        limparTela();
    }
}


