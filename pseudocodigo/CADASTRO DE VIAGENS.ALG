Algoritmo "Cadastro de viagem"

Var
cont, qtd: inteiro
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
      escreval("|Lista de cadastros|")
      escreval()
   para indice <- 1 ate cont faca
      escreval("Passageiro: ", nomes[indice])
      escreval("Destino: ", destinos[indice])
      escreval("--------------------")
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
   consultar_viagem()

FimAlgoritmo