import java.util.LinkedList;
import java.util.Queue;

public class Arvore {

    public int contarNos(No raiz) {
        if (raiz == null) return 0;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        int contador = 0;
        while (!fila.isEmpty()) {
            No atual = fila.poll();
            contador++;

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        No a = new No("A");
        No b = new No("B");
        No c = new No("C");
        No d = new No("D");
        No e = new No("E");
        No f = new No("F");

        a.esquerda = b;
        a.direita  = c;
        b.esquerda = d;
        b.direita  = e;
        c.direita  = f;

        Arvore arvore = new Arvore();
        int totalNos = arvore.contarNos(a);

        System.out.println("Total de nós na árvore: " + totalNos);
    }
}
