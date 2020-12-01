## docker compose
Só consegui fazer rodar o compose do mysql, 
não consegui identificar o que estava gerando o erro ao executar o docker-compose up completo

Através do comando docker-compose up mysql o banco fica disponivel para a aplicação ser executada.

## Aplicação

Variaveis de ambiente seriam utilizadas, mas devido ao problema com o docker
a abordagem teve de ser direta pelo properties do spring.

O usuario e senha devem ser passados pelo basic auth em todas as requisições.

user: root
pass: root

Ou pelo header Authorization.

Basic cm9vdDpyb290

## Requisições

GET /api/account/1/withdraw/?value=199
Onde o valor 1 representa o numero da conta, e o value representa o valor a ser subtraido.

GET /api/account/1/balance
Onde o valor 1 representa o numero da conta.

## Front
A aplicação pode ser startada pelo comando *ng serve* porém não foi implementado 
nenhum front devido a contratempos com configurações de ambiente.
