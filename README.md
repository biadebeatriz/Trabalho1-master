# Trabalho Grupo Um
O objetivo desse trabalho é a implementação de um programa capaz de simular o diagnóstico da doença de um Paciente por um Doutor através de diversas perguntas feitas pelo mesmo de forma com que o diagnóstico seja feito rapidamente, ou seja, menos perguntas sejam necessárias. Além disso, também foram implementadas interfaces gráficas para melhor visualização da situação e dos resultados.

Para cumprir esse objetivo o trabalho foi dividido em componentes, cujo resumo de cada um está abaixo.

# Componente graphicCreator
Essa componente é responsável por gerar um gráfico que mostra a variação do número possivel de doenças ao longo da consulta.

Campo | Valor
----- | -----
Classe | graphicCreator.graphicCreator
Autores | Guilherme Correa
Objetivo | Gerar um gráfico que mostra a variação do número possivel de doenças conforme o médico faz perguntas ao paciente
Interface | IgraphicCreator
	
~~~

public interface IgraphicCreator extends ITableReceptacle {
   public void update(String askedQuestion);
	 public void createGraphic();
}

public interface ITableReceptacle {
	public void updateTable(String[][] instances);
	public void connect(ITableProducer producer);
}

~~~

## Detalhamento da Interface

### Interface IgraphicCreator
Interface provida para ser capaz de criar um grafico conforme Objetivo.

Método | Objetivo
-------| --------
`update` | Adiciona um "estado" a mais no gráfico das possiveis doenças a partir do estado atual da tabela fonte de dados.
`createGraphic` | Cria o gráfico final baseado nos estados que já foram adicionados pelo método update e o mostra na tela.

### Interface ITableReceptacle
Interface dos observers de attTable, cujo objetivo é atualizar a tabela desses componentes.

Método | Objetivo
-------| --------
`updateTable` | Atualiza a tabela com a passado por parâmetro.
`connect` | Conecta com uma fonte de dados inicial.


# Componente nextQuestion
Componente que faz uma busca na tabela dada para definir a ordem de perguntas que se elimina o maior número de doenças em potencial.

Campo | Valor
----- | -----
Classe | <Trabalho1.NextQuestion> 
Autores | Lucas André
Objetivo | Escolher a melhor próxima pergunta a se fazer
Interface | INextQuestion
~~~

public interface INextQuestion extends ITableProducer{
    public int nextQ();
}
~~~

## Detalhamento da Interface

### Interface INextQuestion
Interface provida capaz de analisar a tabela de doenças e à partir dela retornar a próxima melhor pergunta.
 
Método | Objetivo
-------| --------
`nextQ` | Analisa a tabela, coluna por coluna e vê qual delas tem a melhor distribuição de F e V para eliminar o maior caso de doenças possível na próxima pergunta. O objeto mantém atualizado quais perguntas já foram feitas para não mandar o médico fazer a mesma pergunta 2x.


# Componente attTable
Seguindo o pattern Observer, essa componente é responsável por diminuir a tabela a cada resposta obtida do paciente e notificar os observers, que no caso são as componentes nextQuestion e graphicCreator. Utiliza a componente RedutorPossibilidades do grupo OsMatitos.

Campo | Valor
----- | -----
Classe | attTable.attTable
Autores | Guilherme Correa
Objetivo | Atualizar a tabela de sintomas e notificar as componentes que a utilizam.
Interface | IattTable
	
~~~

public interface IattTable extends ITableProducerReceptacle{
	public void attach(ITableReceptacle tableReceptacle);
	public void notifyReceptacle();
	public void update(int pergunta, String resposta);
	public void connect(IRedutorPossibilidades redutor);
}


~~~

## Detalhamento da Interface

### Interface IattTable
Interface provida para ser capaz de atualizar a tabela e notificar as componentes que a utilizam, ela extende a interface ITableProducerReceptacle para obter uma tabela inicial.

Método | Objetivo
-------| --------
`attach` | Conecta uma componente observadora a ela, afim de a notificar quando a tabela é atualizada.
`notifyReceptacle` | Notifica as componentes que utilizam a tabela de que ela foi alterada.
`update` | Atualiza a tabela de acordo com a resposta de uma determinada pergunta feita ao paciente.
`connect` | Se conecta a componente RedutorPossibilidades


# Componentes Compradas

## Componente RedutorPossibilidades

Pertencente ao grupo OsMatitos, essa componente foi usada em conexo com o attTable para se atualizar as tabelas do graphicCreator e do nextQuestion

| Campo | Valor |
|---|---|
| Classe | *zumbi.Componentes.RedutorPossibilidades.RedutorPossibilidades* |
| Autores | Felipe |
| Objetivo | Remover da matriz os pacientes incompatíveis com a resposta |
| Interface | *zumbi.Interfaces.IRedutorPossibilidades.IRedutorPossibilidades* |

Método | Objetivo
-------| --------
`novaTabela` | Recebe o sintoma e remove da tabela os pacientes que não condizem com a resposta obtida, retornando uma tabela atualizada

## Componente UserInterface

Pertencente ao grupo Clube do Hardware, essa componente foi usada para deixar mais ilustrativo a consulta entre o Paciente e o Doutor.

| Campo | Valor |
|---|---|
| Classe | pt.clubedohardware.userinterface.UserInterface |
| Autores | Willian Ozako, Lucas, Douglas Yoshioka |
| Objetivo | Criar animação das interações entre o médico e o paciente |
| Interface | IAnimation |

Método | Objetivo
-------| --------
`story` | Recebe como parâmetro dois vetores, o primeiro que armazena as falas das personagens e o segundo registra quem fala na n-ésima fala. Exemplo: n-ésima posição do 1o vetor - "You have smallpox." - e na n-ésima posição do 2o vetor - "doctor" - logo fica: "Doctor: You have smallpox."IMPORTANTE: Para gerar destaque em uma expressão como o nome da doença ou o do sintoma, coloque a expressão entre asteriscos(*). EX: "You have *smallpox*." -> "You have smallpox."
`setWindowName` | Altera/adiciona título da janela da interface. Para isso ele recebe uma String name que armazena o nome desejado.
`setTempo`  | Recebe como parâmetro String v que deve ser igual em valor à slow,fast ou default. Ele configura a velocidade do texto "corrido"
`setPacientName`  | Recebe como parâmetro a String pacName que é o nome do paciente, guarda esse nome para ser impresso na interface gráfica.
`setDocName`  | Recebe como parâmetro a String docName que é o nome do doutor, guardando o nome para ser impresso na interface gráfica.
