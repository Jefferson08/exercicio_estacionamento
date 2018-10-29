#Exercício Java

Um estacionamento possui vagas para um total de 64 veiculos, podendo ser alocados em cada vaga apenas 1 veiculo dos seguintes tipos:

* moto: R$ 4
* utilitário: R$ 8
* van: R$ 10

Cada veículo pode ser estacionado mediante um pagamento efetuado no 
momento da saida, este que varia de acordo com o tipo do veiculo estacionado.

O estabelecimento necessita de uma aplicação que permita visualizar quantos 
veiculos de cada tipo estao estacionados no local, bem como um mapa das vagas, 
a fim de permitir uma visao geral das vagas ainda disponíveis no estacionamento.

Além disso, o programa deve contar com um relatorio de caixa, exibindo o valor 
arrecadado com o cada categoria de veiculos, 
assim como o total de cada caixa.

##Funcionamento:

###No menu Principal temos as opções:

1 - Visualizar mapa de vagas
2 - Entrada de veículos
3 - Saída de veículos
4 - Relatório
5 - Sair

####Mapa de Vagas

A opção 1 mostra um mapa com todas as vagas disponíveis (64)

Cada vaga pode assumir o valor 0, 1, 2 ou 3, sendo 0 para vazio, e 1, 2 e 3 para o tipo do veículo, respectivamente, Moto, Carro e Van.

####Entrada de veículos

A opção 2 mostra o seguinte menu com os tipos de veículos e os valores:

1 - Moto R$ 4
2 - Carro R$ 8
3 - Van R$ 10

Após selecionar o tipo do veículo, informando o número, ele é alocado na primeira vaga disponível (se houver vagas disponíveis), em seguida o sistema exibe uma mensagem informando o número da vaga;

####Saída de veículos

A opção 3 exibe uma tela onde o usuario informa o número da vaga que o veículo a ser retirado está, se não houver veículo naquela vaga, exibe a mensagem "Não há veículo a ser retirado". Após a retirada, o sistema adiciona o valor do estacionamento do veículo ao caixa;

####Relatório

A opção 4 exibe uma tela com o relatório que mostra a quantidade de veículos no estacionamento por tipo, o total de vagas ocupadas, o total de vagas disponíveis, os ganhos por tipo de veículo e o total de ganhos no caixa;

####Sair

A opção 5 encerra o sistema.


