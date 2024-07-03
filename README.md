# java-semaphore-jantar-filosofos
Durante a disciplina de Sistemas Operacionais, foi abordado sobre semáforos, técnica utilizada para administrar recursos concorrentes entre Threads.
Um problema muito famoso que envolve esse assunto é o problema do jantar dos filósofos, que consiste em uma mesa redonda com os pratos dispostos lado a lado. 
Mas o problema consiste em não haver talheres para todos, ou seja, ao lado de cada prato, há um talher, seja o garfo ou a faca, sendo que para comer, o filósofo necessita dos dois. 

Dessa forma, surge aqui um problema de concorrência entre os filósofos para a utilização dos talheres. 
Digamos que é uma narrativa bem estranha, mas que elucida bem o dilema da programação multithreads. 
Os filósofos aqui representam as Threads e os talheres são os recursos que as Threads compartilham, como por exemplo, a necessidade da atualização do valor de uma variável.

Este projeto foi desenvolvido em Java, utilizando a técnica dos semáforos, que controlam se a Thread pode ou não atuar sobre um recurso.

Abaixo está um Gif que mostra visualmente a simulação do jantar dos filósofos. Neste exemplo, há quatro situações para o filósofo:
- Pensando: A Thread que está fazendo um trabalho que não envolva recursos concorrentes, ou uma Thread que não está trabalhando.
- Esperando: A Thread que quer utilizar o recurso quando o mesmo já está em uso, ou seja, ela tem que ficar aguardando.
- Comendo: A Thread que está fazendo uso do recurso concorrente.
- Cheio: A Thread já realizou todo seu trabalho e encerrou. 

<p>
  <img width="500" autoplay src = "/midia/jantar-dos-filosofos-gif.gif">
</p>

