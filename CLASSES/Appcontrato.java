package CLASSES;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Appcontrato {

    public static void main(String[] args) {
        
        String contratante, contratado, nContrato, desc, cpf, celebracao, inicio, termino;
        Double valcontrato;
        int opcao, ID=0;
        boolean fim1 = false; //variavel para declarar fim a opção 1 e inicio a outras opções 
        Scanner ler = new Scanner (System.in);
        ArrayList<contrato> meuContrato = new ArrayList<>();
        
        
        
        
        
        
        do {
        System.out.println("");
        System.out.println("Opções para operações: ");
        System.out.println("1. Criar novo registro ");
        System.out.println("2. Listar todos os registros ");
        System.out.println("3. Buscar registros (por identificador) ");
        System.out.println("4. Editar registro ");
        System.out.println("5. Excluir registro ");
        System.out.println("6. Sair ");
        opcao = ler.nextInt();
        ler.nextLine();
        System.out.println("");
        
        
        
        
        
        
        if (opcao == 1){
            fim1 = true;
            ID++; //ID auto incrementavel
        System.out.println("Digite o nome do contratante: ");
        contratante = ler.nextLine();
             
        System.out.println("Digite o nome do contratado: ");
        contratado = ler.nextLine();
        System.out.println("Digite o numero do contrato: ");
        nContrato = ler.nextLine();
        System.out.println("Digite a descricao do contrato: ");
        desc = ler.nextLine();
        System.out.println("Digite o CPF do contratante: ");
        cpf = ler.nextLine();
        System.out.println("Digite a data de celebracao do contrato: ");
        celebracao = ler.nextLine();
        System.out.println("Digite a data de inicio do contrato: ");
        inicio = ler.nextLine();
        System.out.println("Digite a data de termino do contrato: ");
        termino = ler.next();
        System.out.println("Digite o valor do contrato: ");
        valcontrato = ler.nextDouble();
        ler.nextLine();
        
        contrato cont = new contrato(ID, contratante, contratado, nContrato, desc, valcontrato, celebracao, inicio, termino, cpf);
     
        //se o CPF for invalido, conforme classe, retornara para o app e solicitara um valido
        while (!ValidaCPF.validarCPF(cpf)){
        System.out.println("CPF invalido!");
        System.out.println("Digite o CPF do contratante: ");
        cpf = ler.next(); 
        }
        //se as datas forem invalidas
        while (cont.validaCelebrar() && cont.validarInicio() && cont.validarTermino()){
            
            
            System.out.println("Digite a data de celebracao do contrato: ");
            celebracao = ler.next();
            System.out.println("Digite a data de inicio do contrato: ");
            inicio = ler.next();
            System.out.println("Digite a data de termino do contrato: ");
            termino = ler.next();
            
        }
        
            //adiciona os dados e cria um arquivo .txt        
        contrato.class.getDeclaredMethods();
        meuContrato.add (new contrato(ID, contratante, contratado, nContrato, desc, valcontrato, celebracao, inicio, termino, cpf));
        
        
        
        
        try{
            try (FileWriter escritor = new FileWriter("contrato.txt")) {
                for (contrato c : meuContrato) {
                    escritor.write(c.toString() +"\n");
                }
            }
        System.out.println("Registro criado com sucesso!");
        } catch (IOException e){
            System.out.println("Erro ao criar registro!");
        }
        
        
        //opção 2, caso exista um arquivo txt
        } else if (fim1 ==true && opcao == 2) {
            try{            
                try (FileReader leitor = new FileReader("contrato.txt"); 
                BufferedReader buffer = new BufferedReader(leitor)) {
                    
                    String linha;
                    
                    while ((linha = buffer.readLine()) !=null){
                        System.out.println("Frase lida: " +linha);
                    }
                }
            } catch(IOException e){
                System.out.println("Erro ao ler o arquivo!");
            }
            
        }
        
        //opção 2, caso não exista um arquivo txt
        else if (opcao == 2 && fim1 == false){
        try{            
                try (FileReader leitor = new FileReader("contrato.txt"); 
                BufferedReader buffer = new BufferedReader(leitor)) {
                    
                    String linha;
                    
                    while ((linha = buffer.readLine()) !=null){
                        System.out.println("Frase lida: " +linha);
                    }
                }
            } catch(IOException e){
                System.out.println("Erro ao ler o arquivo!");
            }
            
        
        }else if (opcao == 3){
            
            
        }
        
        //finaliza o processo
        } while(opcao !=6);
        System.out.println("kbo");
        
       
        
        
    }

    
}
