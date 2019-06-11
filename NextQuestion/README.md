# Trabalho Grupo Um

# Componente NextQuestion

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

### Interface INextQuestion`
Interface provida capaz de analisar a tabela de doenças e à partir dela retornar a próxima melhor pergunta.
 
Método | Objetivo
-------| --------
`nextQ` | Analisa a tabela, coluna por coluna e vê qual delas tem a melhor distribuição de F e V para eliminar o maior caso de doenças possível na próxima pergunta. O objeto mantem atualizado quais perguntas já foram feitas para não mandar o médico fazer a mesma pergunta 2x.
