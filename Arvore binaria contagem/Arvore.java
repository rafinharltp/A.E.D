import java.util.Stack;

public class Arvore {

    public int contarNos(No raiz) {
        if (raiz == null) return 0;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        int contador = 0;
        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
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
