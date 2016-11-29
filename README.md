Trens
================ 

Os serviços locais da estrada de ferro do viajante de bilhete mensal um número de cidades em Kiwiland. Devido à
Preocupações, todas as faixas são "one-way". Ou seja, uma rota de Kaitaia para Invercargill não
Implicam a existência de uma rota de Invercargill a Kaitaia. De fato, mesmo se ambas as rotas
Acontecer de existir, eles são distintos e não são necessariamente a mesma distância!

O objetivo deste problema é ajudar a ferrovia a fornecer aos seus clientes informações
Sobre as rotas. Em particular, você calculará a distância ao longo de uma determinada
Número de rotas diferentes entre duas cidades, eo caminho mais curto entre duas cidades.

Entrada: Um gráfico direcionado onde um nó representa uma cidade e uma borda representa uma rota
Entre duas cidades. A ponderação da aresta representa a distância entre os dois
cidades. Uma determinada rota nunca aparecerá mais de uma vez, e para uma determinada rota, o
E terminando a cidade não será a mesma cidade.

Saída: Para a entrada de teste de 1 a 5, se não existir tal rota, a saída 'NENHUMA ROTA'.
Caso contrário, siga o percurso conforme indicado; Não faça nenhuma paragem extra! Por exemplo, o primeiro
Problema significa começar na cidade A, em seguida, viajar diretamente para a cidade B (uma distância de 5), então diretamente
Para a cidade C (uma distância de 4).

1. A distância da rota A-B-C.
2. A distância da rota A-D.
3. A distância da rota A-D-C.
4. A distância da rota A-E-B-C-D.
5. A distância da rota A-E-D.
6. O número de viagens começando em C e terminando em C com um máximo de 3 paradas. No
Dados de amostra abaixo, há duas dessas viagens: C-D-C (2 paradas). E C-E-B-C (3 paragens).
7. O número de viagens começando em A e terminando em C com exatamente 4 pontos. Na amostra
Dados abaixo, há três tais viagens: A a C (via B, C, D); A a C (via D, C, D); e um
A C (via D, E, B).
8. O comprimento do percurso mais curto (em termos de distância percorrida) de A a C.
9. O comprimento da rota mais curta (em termos de distância percorrida) de B para B.
10. O número de rotas diferentes de C para C com uma distância inferior a 30. No
Amostra, as viagens são: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC,
CEBCEBCEBC.


Entrada de teste:
Para a entrada de teste, as cidades são nomeadas usando as primeiras letras do alfabeto de A a D.
Uma rota entre duas cidades (A a B) com uma distância de 5 é representada como AB5.
Gráfico: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7

Resultado esperado:

Saída => 9
Saída => 5
Saída => 13
Saída => 22
Saída => Nenhuma rota
Saída => 2
Saída => 3
Saída => 9
Saída => 9
Saída => 7

IDE's
================

O projeto foi desenvolvido no [Eclipse](https://eclipse.org) mas roda em qualquer IDE como [Netbeans](https://netbeans.org/) ou [IntelliJ IDEA](https://www.jetbrains.com/idea/) pois foi construído com o framework [Maven](https://maven.apache.org/). 

Como Baixar Este Projeto
================

Você pode executar o comando abaixo no terminal ou caso preferir apenas [baixar o arquivo zip aqui](https://github.com/cleitonferreira/Materialized/archive/master.zip) e importar na sua IDE favorita.

```sh
git clone https://github.com/cleitonferreira/Materialized.git
```

Como configurar o projeto no Eclipse
================

Ao usar o Eclipse, eu recomendo simplesmente importar o projeto através do
1. Abrir eclipse
2. Clique File > Import
3. Digite Maven na caixa de pesquisa sob Select an import wizard:
4. Selecione  Existing Maven Projects
5. Clique Next
6. Clique Browse e selecione a pasta que é a raiz do projeto Maven (provavelmente contém o arquivo pom.xml)
7. Clique OK
8. Sob Projects: clique na caixa de seleção ao lado do arquivo pom.xml
9. Clique Finish


File-> Import-> Existing Maven Projects. 
Selecione o diretório
correspondente a esta solução.

Dúvidas Sobre o Projeto
================

Em caso de dúvidas você poderá enviar um e-mail para [cleitonferreiraa@hotmail.com](cleitonferreiraa@hotmail.com).