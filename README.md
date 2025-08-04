# Avaliação III – Padrões de Projeto

Este projeto implementa o módulo de registro e apuração de desempenho em corridas de orientação.

## Estrutura de Diretórios

	src/ 

	br/edu/ifba/avaliacaoIII/

	main: Main
    model: BoletimProva, Prisma, TempoPassagem, ResultadoApuracao
    state: ProvaState, PreProvaState, MomentoLargadaState, PistaState, PosProvaState
    strategy: RegraApuracao, Apurador, RegraTempoMaximo, RegraOrdemPrismas, RegraPenalidadeAtraso   

## Padrões de Projeto Aplicados

### 1. State

* **Objetivo**: controlar operações permitidas em cada fase da prova (Pré-Prova, Largada, Pista, Pós-Prova) sem condicionais espalhadas.
* **Contexto**: [BoletimProva] delega chamadas de registro ao estado atual.
* **Interface**: [ProvaState] define métodos [registrarAtraso], [registrarLargada], [registrarPassagem], [registrarChegada].
* **Estados Concretos**:

  * [PreProvaState]: bloqueia todos os registros.
  * [MomentoLargadaState]: permite atraso e largada, transita para Pista.
  * [PistaState]: permite passagens e chegada, transita para Pós-Prova.
  * [PosProvaState]: permite apenas atraso, bloqueia demais.

### 2. Strategy

* **Objetivo**: tornar o processo de apuração configurável e extensível por regras independentes.
* **Contexto**: [Apurador] recebe uma lista de [RegraApuracao] e as executa em sequência.
* **Interface**: [RegraApuracao] define o método [aplicar(BoletimProva, ResultadoApuracao)].
* **Estratégias Concretas**:

  * [RegraTempoMaximo]: verifica se o tempo de prova ultrapassa o máximo.
  * [RegraOrdemPrismas]: garante ordem crescente dos tempos de passagem.
  * [RegraPenalidadeAtraso]: adiciona penalidade de atraso ao tempo final.

## Principais Classes

* **Main** ([main/Main.java]): ponto de entrada, simula eventos e exibe resultados.
* **BoletimProva** ([model/BoletimProva.java]): contexto do estado da prova, gerencia dados e delega a [ProvaState].
* **Prisma**, **TempoPassagem**, **ResultadoApuracao**: entidades de domínio.
* **ProvaState** e estados em [state]: encapsulam permissões e transições de fases.
* **Apurador** e regras em [strategy]: aplicam políticas de apuração.


## Executar os Testes

	1.Descomente o cenário desejado na classe Main
	2.Comente os demais cenários para isolar o teste
	3.Execute a aplicação
