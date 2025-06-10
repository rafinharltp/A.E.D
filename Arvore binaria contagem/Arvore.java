public class Arvore {
    No raiz;

    public No inserir(No no, int valor) {
        if (no == null) return new No(valor);

        if (valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balance = altura(no.esquerda) - altura(no.direita);

        if (balance > 1 && valor < no.esquerda.valor)
            return rotacaoDireita(no);

        if (balance < -1 && valor > no.direita.valor)
            return rotacaoEsquerda(no);

        if (balance > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No t2 = x.direita;

        x.direita = y;
        y.esquerda = t2;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No t2 = y.esquerda;

        y.esquerda = x;
        x.direita = t2;

        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    public void percursoEmOrdem(No no) {
        if (no != null) {
            percursoEmOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            percursoEmOrdem(no.direita);
        }
    }

    public void percursoPreOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            percursoPreOrdem(no.esquerda);
            percursoPreOrdem(no.direita);
        }
    }

    public void percursoPosOrdem(No no) {
        if (no != null) {
            percursoPosOrdem(no.esquerda);
            percursoPosOrdem(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        int[] chaves = {10, 20, 30, 40, 50, 25};

        for (int chave : chaves) {
            arvore.raiz = arvore.inserir(arvore.raiz, chave);
        }

        System.out.println("Percurso em ordem da árvore AVL:");
        arvore.percursoEmOrdem(arvore.raiz);
        System.out.println();

        System.out.println("Percurso pré-ordem da árvore AVL:");
        arvore.percursoPreOrdem(arvore.raiz);
        System.out.println();

        System.out.println("Percurso pós-ordem da árvore AVL:");
        arvore.percursoPosOrdem(arvore.raiz);
        System.out.println();
    }
}
