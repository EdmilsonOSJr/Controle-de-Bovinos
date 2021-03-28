# Controle-de-Bovinos
Atividade proposta na oportunidade de estágio da empresa RERUN.

# Para Usar o programa siga os seguintes passos:


- Faça o download do programa.
- Baixe o banco de dados PostgreSQL.
  - Acesse a página de downloads do PostgreSQL (https://www.enterprisedb.com/downloads/postgresql) e
  selecione a opção referente ao seu sistema operacional.
  - Depois disso abra o pgAdmin (https://www.pgadmin.org/docs/pgadmin4/4.29/index.html). (ele é uma plataforma open
  Source para administração do SGBD PostgreSQL disponível para Linux, Unix, macOS and Windows e que é instalado automaticamente quando instalamos o PostgreSQL)
- É necessário criar um banco de dados. O banco usado nesse projeto tem o nome de controlebovinos, o usuario é postgres e a senha 1234567. Caso queira que qualquer
um desses elementos tenha um valor diferente altere o arquivo persistence.xml que está na pasta Controle-de-Bovinos\ControleDeBovinos\src\META-INF nas linhas
8 e 23 (com o nome do seu banco), 19 (com o seu usuário) e 21 (com sua senha).

OBS: Como foi utilizado o Hibernate no projeto a tabela é criada automaticamente ao iniciar a aplicação, sendo assim não é necessário criá-la.
