/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento;

/**
 *
 * @author Jefferson Carvalho
 */
public class EstacionamentoVO {
    
    //atributos:
    private int vagasDisponiveis, vagasOcupadas;
    private int atual[] = new int[3];
    private int total[] = new int[3];
    private float precos[] = {4, 8, 10};

    private int mapa[] = new int[64];

    private String tipos[] = {"Moto", "Carro", "Van"};

    private float totalCaixa;

    //metodo construtor define o estado inicial de cada atributo:
    public EstacionamentoVO() {

        this.vagasDisponiveis = 64;
        this.vagasOcupadas = 0;
        this.totalCaixa = 0;

        //zerando vetor: esvaziando vagas:
        for (int i = 0; i < mapa.length; i++) {
            this.mapa[i] = 0;
        }//fechando for 

        //zerando vetores das vagas e atuais:
        for (int i = 0; i < 3; i++) {
            atual[i] = 0;
            total[i] = 0;
        }//fechando for²

    }//fechando construtor

    //metodos funcionais:
    public int adicionarVeiculo(int tmpTipo) {
        int vagaDisp = -1;
        boolean achou = false;

        //algoritmo de busca da vaga disponivel:
        for (int i = 0; i < this.mapa.length; i++) {
            if (mapa[i] == 0) {
                achou = true;//vaga encontrada
                vagaDisp = i;//armazenando numero da vaga
                this.mapa[vagaDisp] = tmpTipo;//estacionando veiculo
                this.vagasDisponiveis--;
                this.vagasOcupadas++;
                this.atual[tmpTipo - 1]++;
                break;//encerrando a varredura 
            }//fechando if
        }//fechando algoritmo
        if (achou == false) {
            return -1;
        } else {
            return vagaDisp;
        }
    }//fechando retorno da vaga;

    public boolean retirarVeiculo(int tmpVaga) {
        int tipo;

        if (this.mapa[tmpVaga - 1] == 0) {
            return false;
        } else {
            //retirar veiculo
            
            this.vagasDisponiveis++;
            this.vagasOcupadas--;
            tipo = this.mapa[tmpVaga -1];
            this.atual[tipo-1]--;
            this.total[tipo-1]++;

            this.totalCaixa += precos[tipo-1];
            this.mapa[tmpVaga -1] = 0;//tirando veiculo da vaga
            
           
            return true;
        }
    }

    public String visualizarMapa() {
        String msgMapa = "";

        for (int i = 0; i < this.mapa.length; i++) {
            msgMapa += this.mapa[i] + " | ";
            if (((i + 1) % 8 == 0) && (i != 0)) {
                msgMapa += "\n";
            }//fechando if 
        }//fechando for
        return msgMapa;
    }//fechando visualizarMapa

    public String[] getTipo() {
        return tipos;
    }

    public String exibirRelatorio() {
        String rel = "Veículos no estacionamento: \n";
        for (int i = 0; i < atual.length; i++) {
            rel += tipos[i] + ": " + atual[i] + "\n";
        }
        rel += "\nVagas Ocupadas: " + vagasOcupadas + "\n";
        rel += "\nVagas Disponíveis: " + vagasDisponiveis + "\n";
        rel += "Ganho por categoria: \n\n";

        for (int i = 0; i < atual.length; i++) {
            rel+=tipos[i] + " R$: " + (total[i]*precos[i]) + "\n";
        }
        rel += "\nTotal em caixa R$: " + totalCaixa + "\n";
        
        return rel;
    }
}//fechando classe

