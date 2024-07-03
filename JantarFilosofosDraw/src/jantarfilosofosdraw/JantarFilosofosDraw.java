/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantarfilosofosdraw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author bruno
 */
public class JantarFilosofosDraw extends JFrame {

    public static JantarFilosofosDraw jf = new JantarFilosofosDraw();
    public static int dorepaint = 0;

    int tam = 800;
    private static int[] state = {5, 5, 5, 5, 5};
    private static int filotoeat = 5;

    public class Desenho extends Canvas {

        public static Thread[] threads;

        @Override
        public void paint(Graphics g) {
            super.paint(g); //To change body of generated methods, choose Tools | Templates.

            Font font = new Font("Arial", Font.PLAIN, 30);
            g.setFont(font);

            int iniytext = 35;
            g.drawString("Problema do jantar dos filósofos utilizando semáforos", 25, iniytext);
            g.drawString("(Demonstração visual)", 25, iniytext + 40);

            font = new Font("Arial", Font.PLAIN, 20);
            g.setFont(font);

            int smallr = 30;
            int dist = 35;
            int inix = 20;
            for (int i = 0; i < 4; i++) {
                int initx = inix - 2 + 40;
                int inity = getWidth() - dist * (4 - i) - 2 - smallr / 4;

                g.setColor(Color.BLACK); //Cheio
                g.fillOval(inix - 2, getWidth() - smallr - dist * (4 - i) - 2, smallr + 4, smallr + 4);
                g.setColor(Color.BLACK); //Cheio
                // Desenha o círculo menor
                switch (i) {
                    case 0:
                        g.drawString("Pensando", initx, inity);
                        g.setColor(Color.GREEN); //pensando
                        break;
                    case 1:
                        g.drawString("Com fome", initx, inity);
                        g.setColor(Color.YELLOW); //Com fome
                        break;
                    case 2:
                        g.drawString("Comendo", initx, inity);
                        g.setColor(Color.RED);  //Comendo
                        break;
                    case 3:
                        g.drawString("Cheio (encerrou)", initx, inity);
                        g.setColor(Color.GRAY); //Cheio
                        break;
                }
                g.fillOval(inix, getWidth() - smallr - dist * (4 - i), smallr, smallr);
            }

            font = new Font("Arial", Font.PLAIN, 40);
            g.setFont(font);

            int centerX = getWidth() / 2; // Coordenada X do centro do círculo de referência
            int centerY = getHeight() / 2; // Coordenada Y do centro do círculo de referência

            int referenceRadius = 300; // Raio do círculo de referência
            g.fillOval(centerX - referenceRadius, centerY - referenceRadius, 2 * referenceRadius, 2 * referenceRadius);

            referenceRadius = 180; // Raio do círculo de referência
            int numCircles = 5; // Número de círculos menores
            int circleRadius = 100; // Raio dos círculos menores

            // Desenha o círculo de referência
            g.setColor(Color.WHITE);
            g.drawOval(centerX - referenceRadius, centerY - referenceRadius, 2 * referenceRadius, 2 * referenceRadius);

            // Calcula os ângulos para posicionar os círculos menores igualmente espaçados
            double angleIncrement = 2 * Math.PI / numCircles;
            do {
                for (int i = 0; i < numCircles; i++) {
                    referenceRadius = 330;
                    g.setColor(Color.BLUE);
                    // Escreve o texto na janela
                    //g.drawString(String.valueOf(i), 50, 50);

                    // Calcula as coordenadas do centro do círculo menor
                    int circleX = (int) (centerX + referenceRadius * Math.cos(i * angleIncrement));
                    int circleY = (int) (centerY + referenceRadius * Math.sin(i * angleIncrement));
                    int espaco = 20;
                    g.drawString(String.valueOf(i + 1), circleX - espaco, circleY + espaco);

                    referenceRadius = 180;
                    circleX = (int) (centerX + referenceRadius * Math.cos(i * angleIncrement));
                    circleY = (int) (centerY + referenceRadius * Math.sin(i * angleIncrement));

                    g.setColor(Color.BLACK); //pensando
                    g.fillOval(circleX - circleRadius - 2, circleY - circleRadius - 2,
                              2 * circleRadius + 4, 2 * circleRadius + 4);

                    // Desenha o círculo menor
                    switch (state[i]) {
                        case 0:
                        case 5:
                            g.setColor(Color.GREEN); //pensando
                            break;
                        case 1:
                            g.setColor(Color.YELLOW); //Com fome
                            break;
                        case 2:
                            g.setColor(Color.RED);  //Comendo
                            break;
                        case 3:
                            g.setColor(Color.GRAY); //Cheio
                            break;
                    }
                    g.fillOval(circleX - circleRadius, circleY - circleRadius, 2 * circleRadius, 2 * circleRadius);
                }
                dorepaint = 0;
                if (filotoeat == 0) {
                    dorepaint = -1;
                }
                while (dorepaint == 0) {
                    timewait(1000);
                };
            } while (dorepaint != -1);
        }
    }

    public JantarFilosofosDraw() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                encerrarThreads();
                dispose();
                System.exit(0);
            }
        });

        this.setFocusable(true);
        this.requestFocusInWindow();

        initGui();
    }

    public void encerrarThreads() {
        // Sinalize todas as threads para encerrar
        for (Thread thread : Desenho.threads) {
            // Certifique-se de que sua classe de thread tenha um mecanismo para encerrar a thread
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    // inicializar os componente graficos
    private void initGui() {
        // titulo
        this.setTitle("Jantar dos Filósofos");
        // tamanho em pixels altura e largura
        setSize(tam, tam);

        // janela aparecer no meio
        setLocationRelativeTo(null);

        // terminar a aplicacao ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Desenho desenho = new Desenho();

        this.add(desenho);
        // tornar a janela visivel
        setVisible(true);
    }

    public static boolean enumvalido(int num) {
        if (num > -1 && num < 4) {
            return true;
        } else {
            return false;
        }
    }

    public static void timewait() {
        timewait(1000);
    }

    public static void timewait(long delayTime) {
        long startTime = System.currentTimeMillis(); // Obtém o tempo inicial
        delayTime = 500;
        while (System.currentTimeMillis() - startTime < delayTime) {
            // Aguarda até que o tempo especificado tenha passado
        }
    }

    private static Random rdm = new Random();

    private static final int N = 5; // número de filósofos
    private static final int THINKING = 0; // o filósofo está pensando
    private static final int HUNGRY = 1; // o filósofo está tentando pegar garfos
    private static final int EATING = 2; // o filósofo está comendo
    private static final int FINISHED = 3; // o filósofo está comendo

    private static final Semaphore mutex = new Semaphore(1);
    private static final Semaphore[] s = new Semaphore[N];

    static class Philosopher implements Runnable {

        public static void setHungry(int i) {
            dorepaint = 1;
            state[i] = HUNGRY;
        }

        public static void setThink(int i) {
            if (colheradas[i] > 1) {
                dorepaint = 1;
                state[i] = THINKING;
            }
        }

        public static void setEating(int i) {
            dorepaint = 1;
            state[i] = EATING;
        }

        public static void setFinished(int i) {
            filotoeat--;
            dorepaint = 1;
            state[i] = FINISHED;
        }

        private static int colmax = 3;
        private static int colheradas[] = {colmax, colmax, colmax, colmax, colmax};
        private int index;

        public Philosopher(int index) {
            this.index = index;
        }

        public void imprime() {
            int larguraTotal = 10;
            //timewait(2000);
            System.out.println("================================================");
            for (int i = 0; i < N; i++) {
                String texto = "";
                texto += '(';
                texto += String.valueOf(this.colheradas[i]);
                texto += ')';
                texto += i + 1;
                switch (state[i]) {
                    case HUNGRY:
                        texto += " // COM FOME //";
                        break;
                    case EATING:
                        texto += " %% COMENDO %%";
                        break;
                    case FINISHED:
                        texto += " XX Cheio XX (encerrou)";
                        break;
                    default:
                        texto += " -- Pensando -- ";
                }
                String textoCentralizado = String.format("%" + larguraTotal + "s", texto);
                System.out.println(textoCentralizado);
            }
            System.out.println("================================================");
        }

        public void saidas(int num) {
            saidas(num, 0);
        }

        public void saidas(int num, int i) {
            i++;
            timewait();
            switch (num) {
                case 0:
                    imprime();
                    break;
                case 1:
                    System.out.println("Filosofo PENSANDO: " + i);
                    break;
                case 2:
                    System.out.println("Filosofo COM FOME: " + i);
                    break;
                case 3:
                    System.out.println("Filosofo DEVOLVEU os garfos: " + i);
                    break;
                case 4:
                    System.out.println("------------------------------------------------");
                    System.out.println("Filosofo COMENDO: " + i + " (pegou os garfos)");
                    System.out.println("------------------------------------------------");
                    break;
            }
        }

        @Override
        public void run() {
            do {
                think();
                takeForks(index);
                eat(this.index);
                putForks(index);
                //timewait(2000);
            } while (state[this.index] != FINISHED);
        }

        private void think() {
            // Implementação da ação de pensar 
            timewait();
        }

        private void takeForks(int i) {
            try {
                mutex.acquire();
                setHungry(i);
                saidas(2, i);   //Com fome
                imprime();
                boolean imprime = false;
                test(i, imprime);
                if (imprime) {
                    imprime();
                }
                mutex.release();
                s[i].acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void putForks(int i) {
            try {
                mutex.acquire();
                setThink(i);
                this.colheradas[this.index]--;
                saidas(3, i);   //Devolveu os garfos
                if (this.colheradas[this.index] == 0) {
                    setFinished(i);
                }
                saidas(0, i);   //imprime
                boolean imprime = false;
                test((i + N - 1) % N, imprime);
                System.out.println("TESTE 1");
                test((i + 1) % N, imprime);
                if (imprime) {
                    //imprime();
                }
                System.out.println("TESTE 2");
                mutex.release();
                System.out.println("RELEASE");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void test(int i, boolean imprime) {
            int left = (i + N - 1) % N;
            int right = (i + 1) % N;
            if (state[i] == HUNGRY && state[left] != EATING && state[right] != EATING) {
                setEating(i);
                saidas(4, i);   //Comendo
                imprime = true;
                s[i].release();
            }
        }
    }

    private static void eat(int index) {
        // Implementação da ação de comer
        long time = rdm.nextInt(2) + 3;
        //System.out.println(index + " COMENDO: Filosofo " + index + " (por " + time + " segundos)");
        timewait(time * 1000);
        //System.out.println(index + " ACABOU: Filosofo " + index + " acabou de comer.");
        //timewait(1000);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread[] filos = new Thread[N];
        for (int i = 0; i < N; i++) {
            s[i] = new Semaphore(0);
            filos[i] = new Thread(new Philosopher(i));
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException ex) {
            Logger.getLogger(JantarFilosofosDraw.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < N; i++) {
            filos[i].start();
        }
        Desenho.threads = filos;
    }

}
