package Ex2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        
        Queue<Participante> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int k;

        System.out.print("Insira o número de participantes do jogo: ");
        int n = scanner.nextInt();

        for (int p = 1; p <= n; p++) {
            fila.add(new Participante(p));
        }

        while (fila.size() > 1) {

            k = (int)(Math.random() * 10) + 1;
            for (int b = 0; b < k; b++) {
                fila.add(fila.remove());
            }
            fila.remove();

        }

        System.out.println("O participante vencedor é: " + fila.peek());

        scanner.close();

    }

}
