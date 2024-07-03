# Problema do Jantar dos Filósofos em Java
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

<div align="center">
  <img width="50%" src="https://github.com/brunocmnz/java-semaphore-jantar-filosofos/assets/117315412/704b1d47-dff0-4ff9-8756-3f3257b6196f">
</div>

# # java-semaphore-dining-philosophers-problem:
During the Operating Systems course, semaphores were discussed, a technique used to manage competing resources between Threads.
A very famous problem that deals with this is the philosophers' dinner problem, a circular table with some philosophers around it.
But the real problem is because there is not enough cutlery for everyone, the competing resource is the cutlery, which is used by the two philosophers surrounding him.

It is a very strange story, isn't it? But that story can explain the dilemma of the multithreaded programming.
The philophers represent the Threads and the cutlery are like the resources that they are sharing, like the permission to update a variable, for example.

This project was developed in Java, using the semaphores technique, which manage wether the Theads can act on a resource or not.

To uderstand it visually, click on the Gif below, to see the animation. In this example, there are four situations to the philosopher:
- Thinking (Pensando): The Thread is doing a work that does not involve competing resources, or a Thread that is not workin.
- Wainting (Esperando): The Thread that wants to use the resource when it is alredy in use, that is, it has to wait.
- Eating (Comendo): The Tread that is using the competing resource.
- Full (Cheio): The Thread has already completed its work and closed.

<div align="center">
  <br>
  <img width="50%" src="https://github.com/brunocmnz/java-semaphore-jantar-filosofos/assets/117315412/704b1d47-dff0-4ff9-8756-3f3257b6196f">
</div>

Therefore, as the cutlery represents the shared resource, there cannot be two adjacent philosophers eating simultaneously, which does not happen, as you can see in the GIF.

⚠️ Attention: In order for you to be able to run the .jar file, Java must be installed on your machine.
