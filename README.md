# java-semaphore-jantar-filosofos
Durante a disciplina de Sistemas Operacionais, foi abordado sobre semáforos, técnica utilizada para administrar recursos concorrentes entre Threads.
Um problema muito famoso que envolve esse assunto, é o problema do jantar dos filósofos, que consiste em uma mesa redonda com os pratos dispostos lado a lado. 
Mas o problema se faz porque não há talheres para todos, ou seja, ao lado de cada prato, há um talher, seja um garfo ou uma faca, sendo que para comer, o filósofo necessita dos dois. Nesse sentido, o recurso concorrente é cada talher, sendo que os filósofos (Threads) adjacentes à ele competem por seu uso.

Dessa forma, surge aqui um problema de concorrência entre os filósofos para a utilização dos talheres. 
Digamos que é uma narrativa bem estranha, mas que elucida bem o dilema da programação multithreads. 
Os filósofos aqui representam as Threads e os talheres são os recursos que elas compartilham, como por exemplo, a permissão de atualização do valor de uma variável.

Este projeto foi desenvolvido em Java, utilizando a técnica dos semáforos, que controlam se a Thread pode ou não atuar sobre um recurso.

Abaixo está um Gif que mostra visualmente a simulação do jantar dos filósofos. Neste exemplo, há quatro situações para o filósofo:
- Pensando: A Thread que está fazendo um trabalho que não envolva recursos concorrentes, ou uma Thread que não está trabalhando.
- Esperando: A Thread que quer utilizar o recurso quando o mesmo já está em uso, ou seja, ela tem que ficar aguardando.
- Comendo: A Thread que está fazendo uso do recurso concorrente.
- Cheio: A Thread já realizou todo seu trabalho e encerrou. 

Sendo assim, como os talheres representam o recurso compartilhado, não pode haver dois filósofos adjacentes comendo simultâneamente, o que não acontece, conforme é possível ver no GIF.
⚠️ Atenção: Para que você consiga executar o arquivo .jar, o Java deve estar instalado em sua máquina.

![jantar-dos-filosofos-gif](https://github.com/brunocmnz/java-semaphore-jantar-filosofos/assets/117315412/704b1d47-dff0-4ff9-8756-3f3257b6196f)


