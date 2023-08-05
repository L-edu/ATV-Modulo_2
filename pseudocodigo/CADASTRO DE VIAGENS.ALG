Algoritmo "Cadastro de viagem"

Var
opcao, cont, qtd: inteiro
nomes: vetor[1..10] de caractere
destinos: vetor[1..10] de caractere
cliente, destino: caractere

Procedimento cadastrar_viagem(Var nome, local: caractere)
Inicio
   cont <- cont + 1
   nomes[cont] <- nome
   destinos[cont] <- local
FimProcedimento

Procedimento consultar_viagem()
var
   indice: inteiro
Inicio
      Escreval("|Lista de cadastros|")
      Escreval()
   para indice <- 1 ate cont faca
      Escreval("Passageiro: ", nomes[indice])
      Escreval("Destino: ", destinos[indice])
      Escreval("--------------------")
   FimPara
FimProcedimento

Inicio
   cont <- 0
   Escreval("-------|MENU|-------")

   Escreval("Quantos cadastros deseja realizar? ")
   Leia(qtd)

   Enquanto cont < qtd faca
      Escreval("Informe o nome que deseja cadastrar: ")
      Leia(cliente)
      Escreval("Informe o destino que deseja cadastrar: ")
      Leia(destino)
      cadastrar_viagem(cliente, destino)
   FimEnquanto
   Escreval("--------------------")
   
   Escreval("Digite 1 para consultar as viagens")
   Escreval("Digite 2 para encerrar o atendimento")
   Leia(opcao)
   
   Se opcao = 1 Entao
      consultar_viagem()
   Senao
      Se opcao = 2 Entao
         Escreval("Atendimento encerrado!")
      FimSe
   FimSe
FimAlgoritmo

