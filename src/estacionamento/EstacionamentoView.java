
package estacionamento;

import javax.swing.*;

/**
 *
 * @author Jefferson Carvalho
 */
public class EstacionamentoView {
    public static EstacionamentoVO objDados = new EstacionamentoVO();
    
    public EstacionamentoView(){
        
        int opcao;
        String msgMenu = "";
        msgMenu += "Entre com a opção desejada: \n";
        msgMenu +="1 - Visualizar mapa de vagas\n"; 
        msgMenu +="2 - Entrada de veículos\n";
        msgMenu +="3 - Saída de veículos\n";
        msgMenu +="4 - Relatório\n";
        msgMenu +="5 - Sair\n";
       
        do{
        
        opcao = Integer.parseInt(JOptionPane.showInputDialog(msgMenu));
        
        switch(opcao){
            case 1:
                //visualizar mapa
                JOptionPane.showMessageDialog(null,objDados.visualizarMapa(),"CIC Park",JOptionPane.QUESTION_MESSAGE);
                break;
            case 2:
                //registrarVeiculo();
                registrarVeiculo();
                break;
            case 3:
                //liberarVaga
                liberarVaga();
                break;
            case 4:
                //exibirRelatorio
                JOptionPane.showMessageDialog(null, objDados.exibirRelatorio());
                break;
            case 5:
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida!","Estacionamento",JOptionPane.WARNING_MESSAGE); 
        }//fechando switch
        
        }while(opcao!=5);
    }  
    public static void registrarVeiculo(){
        int tmpTipo, numVaga;//numVaga armazena a vaga em que o veiculo está, armazena o retorno
        tmpTipo = Integer.parseInt(JOptionPane.showInputDialog("Entre com o tipo do veículo:\n1 - Moto R$ 4\n2 - Carro R$ 8\n3 - Van R$ 10\n"));
        
        numVaga = objDados.adicionarVeiculo(tmpTipo);
        
        if(numVaga == -1){
            JOptionPane.showMessageDialog(null, "Estacionamento lotado.","CIC Park",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Seu(sua)" + objDados.getTipo()[tmpTipo -1] + " foi estacionado(a) na vaga: " + (numVaga + 1));
        }
    }
    
    public static void liberarVaga(){
        boolean status;
        int numVaga = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número da vaga do cliente: "));

        
        status = objDados.retirarVeiculo(numVaga);
        
        if(status){ //mesma coisa que: if(status == true)
            JOptionPane.showMessageDialog(null, "O veículo foi retirado da vaga: " + numVaga,"CIC Park",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Não há veículo a ser retirado","CIC Park",JOptionPane.ERROR_MESSAGE);
        }
    }
}
