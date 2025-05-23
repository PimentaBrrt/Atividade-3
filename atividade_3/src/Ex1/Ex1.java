package Ex1;

import java.util.Scanner;
import java.util.Stack;

public class Ex1 {
    public static void main(String[] args) {

        Stack<Servidor> servers = new Stack<>();
        Stack<Servidor> aux = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira os valores das cargas de trabalho de cada servidor separados por vírgula (x,y,z): ");
        String[] cargas = scanner.nextLine().split(",");

        for (int i = 0; i < cargas.length; i++) {
            servers.push(new Servidor(Integer.parseInt(cargas[i].trim())));
        }

        int dias = 0;
        boolean mudou = true;

        while (mudou) {

            mudou = false;
            Servidor atual = servers.pop();
            Servidor proximo = servers.pop();

            while (true) {

                if (servers.isEmpty()) {

                    if (atual.getCarga() > proximo.getCarga()) {
                        aux.push(proximo);
                        mudou = true;
                    } 
                    else {
                        aux.push(atual);
                        aux.push(proximo);
                    }

                    break;

                }

                if (atual.getCarga() > proximo.getCarga()) {

                    if (servers.size() > 1) {
                        atual = proximo;
                        proximo = servers.pop();
                    } 
                    else {
                        aux.push(servers.pop());
                    }
                    
                    mudou = true;
                } else {
                    aux.push(atual);
                    atual = proximo;
                    proximo = servers.pop();
                }

            }

            while(!aux.isEmpty()) {
                servers.push(aux.pop());
            }

            if (mudou) {
                dias++;
            }

        }

        System.out.println(dias + " dias até que nenhum servidor seja mais desligado.");
        scanner.close();
    }
}