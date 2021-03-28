# Controle-de-Bovinos
Atividade proposta na oportunidade de estágio da empresa RERUN.

# Para usar o programa siga os seguintes passos:


- Faça o download do programa.
- Baixe o banco de dados PostgreSQL.
  - Acesse a página de downloads do PostgreSQL (https://www.enterprisedb.com/downloads/postgresql) e
  selecione a opção referente ao seu sistema operacional.
  - Depois disso abra o pgAdmin (https://www.pgadmin.org/docs/pgadmin4/4.29/index.html). (ele é uma plataforma open
  Source para administração do SGBD PostgreSQL disponível para Linux, Unix, macOS and Windows e que é instalado automaticamente quando instalamos o PostgreSQL)
- É necessário criar um banco de dados. O banco usado nesse projeto tem os valores do nome, usuario e senha com valores já definidos. Antes de realmente cria o banco
va até o arquivo persistence.xml que está na pasta Controle-de-Bovinos\ControleDeBovinos\src\META-INF nas linhas 8 e 23 (nome banco), 19 (usuário) 
e 21 (senha) para consultar esses valores, ou caso desejar trocá-los.

OBS: Como foi utilizado o Hibernate no projeto a tabela é criada automaticamente ao iniciar a aplicação, sendo assim não é necessário criá-la.
