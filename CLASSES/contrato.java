package CLASSES;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class contrato {
    private int ID;
    private String contratante;
    private String contratado;
    private String ncontrato;
    private String desccontrato;
    private Double valcontrato;
    private LocalDate celebracao;
    private LocalDate inicio;
    private LocalDate termino;
    private String CPF;
    private String valcontratoBR;
    
    
        
    //classe responsavel especificar um padrão diferente do formato ISO
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    //metodo responsavel para formatar uma data recebida para o "formato"
    private LocalDate validarData(String dataString){
        return LocalDate.parse(dataString, formato);
    }
    
    //objeto criado para padronizar o formato da moeda para pt-BR
    Locale localBrasil = new Locale("pt", "BR");
    
    
    //construtor
    public contrato (int ID, String contratante, String contratado, String ncontrato, String desccontrato, Double valcontrato, String celebracao, String inicio, String termino, String CPF){
        this.celebracao = validarData(celebracao);
        this.inicio = LocalDate.parse(inicio, formato);
        this.termino = LocalDate.parse(termino, formato);
        this.contratado = contratado;
        this.contratante = contratante;
        this.desccontrato = desccontrato;
        this.ncontrato = ncontrato;
        this.valcontratoBR = NumberFormat.getCurrencyInstance(localBrasil).format(valcontrato);
        this.CPF = ValidaCPF.imprimeCPF(CPF) ; //padronizar cpf
        this.ID = ID;
    }
    
     

    
    //metodo para validar se a data é maior ou menor que outra data
    
    
    
     public boolean validaCelebrar(){
         if (celebracao.isAfter(termino)){
             System.out.println("Data de celebracao não pode ser posterior a data de termino!");
             return true;
         }else {
        return false; 
         }
        }
     
     public boolean validarInicio (){
         if (inicio.isAfter(termino)){
             System.out.println("Data de inicio não pode ser posterior a data de termino!");
         return true;
         }else {
        return false; 
         }
        }
     
     public boolean validarTermino (){
         if (termino.isBefore(celebracao) && termino.isBefore(inicio)){
             System.out.println("Data de termino não pode ser anterior a data de celebracao e inicio!");
         return true;
         }else {
        return false; 
         }
        }
    //metodo getters para acessar atributos privados
    
    public String getCelebracaoFormato(){
        return celebracao.format(formato);
    }
    
    public String getInicio(){
        return formato.format(inicio);
    }
    
    public String getTermino(){
        return formato.format(termino);
    }
    
    public String getContratante(){
        return contratante;
    }
    
    public String getContratado(){
        return contratado;
    }
    
    public String getNcontrato(){
        return ncontrato;
    }
    
    public String getDesccontrato(){
        return desccontrato;
    }
    
    public String getValcontratoBR(){
        return valcontratoBR;
    }
    
    public String getCPF(){
        return CPF;
    }
    public int getID(){
        return ID;
    }
    
    public String toString(){
    return ID +"|" +contratante + " | " + contratado + " | " + CPF + " | " + ncontrato + " | " + valcontratoBR + " | " + celebracao.format(formato) + 
            " | " + formato.format(inicio) + " | " + formato.format(termino) + " | " + desccontrato;
    }
}
