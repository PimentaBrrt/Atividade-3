package Ex3;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        
        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira os elementos da primeira lista separados por vírgula (1,2,3) em ordem crescente: ");
        String[] elementos1 = scanner.nextLine().split(",");
        
        for (String e : elementos1) {
            lista1.add(Integer.parseInt(e.trim()));
        }

        if (!checarCrescente(lista1)) {
            System.out.println("A primeira lista não está em ordem crescente. Encerrando programa.");
            scanner.close();
            return;
        }

        System.out.print("Insira os elementos da segunda lista separados por vírgula (4,5,6) em ordem crescente: ");
        String[] elementos2 = scanner.nextLine().split(",");
        
        for (String e : elementos2) {
            lista2.add(Integer.parseInt(e.trim()));
        }

        if (!checarCrescente(lista2)) {
            System.out.println("A segunda lista não está em ordem crescente. Encerrando programa.");
            scanner.close();
            return;
        }

        LinkedList<Integer> juncao = juncaoListas(lista1, lista2);

        System.out.println("Lista final após junção:");
        System.out.println(juncao);

        scanner.close();

    }

    public static boolean checarCrescente(LinkedList<Integer> lista) {

        for (int n = 0; n < lista.size() - 1; n++) {
            if (lista.get(n) > lista.get(n + 1)) {
                return false;
            }
        }

        return true;

    }

    public static LinkedList<Integer> juncaoListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {

        LinkedList<Integer> listaFinal = new LinkedList<>();

        int i = 0;
        int j = 0;
        
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                listaFinal.add(lista1.get(i));
                i++;
            } else {
                listaFinal.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            listaFinal.add(lista1.get(i));
            i++;
        }
        
        while (j < lista2.size()) {
            listaFinal.add(lista2.get(j));
            j++;
        }

        return listaFinal;

    }

}