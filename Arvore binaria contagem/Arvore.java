public class Arvore {
    private static final boolean VERMELHO = true;
    private static final boolean PRETO = false;

    class No {
        int valor;
        No esquerda, direita;
        boolean cor;

        No(int valor) {
            this.valor = valor;
            this.cor = VERMELHO;
        }
    }

    No raiz;

    private boolean ehVermelho(No no) {
        if (no == null) return false;
        return no.cor == VERMELHO;
    }

    private No rotacaoEsquerda(No h) {
        No x = h.direita;
        h.direita = x.esquerda;
        x.esquerda = h;
        x.cor = h.cor;
        h.cor = VERMELHO;
        return x;
    }

    private No rotacaoDireita(No h) {
        No x = h.esquerda;
        h.esquerda = x.direita;
        x.direita = h;
        x.cor = h.cor;
        h.cor = VERMELHO;
        return x;
    }

    private void trocaCor(No h) {
        h.cor = VERMELHO;
        if (h.esquerda != null) h.esquerda.cor = PRETO;
        if (h.direita != null) h.direita.cor = PRETO;
    }

    public No inserir(No h, int valor) {
        if (h == null) return new No(valor);

        if (valor < h.valor) {
            h.esquerda = inserir(h.esquerda, valor);
        } else if (valor > h.valor) {
            h.direita = inserir(h.direita, valor);
        }

        if (ehVermelho(h.direita) && !ehVermelho(h.esquerda)) {
            h = rotacaoEsquerda(h);
        }
        if (ehVermelho(h.esquerda) && ehVermelho(h.esquerda.esquerda)) {
            h = rotacaoDireita(h);
        }
        if (ehVermelho(h.esquerda) && ehVermelho(h.direita)) {
            trocaCor(h);
        }

        return h;
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
        raiz.cor = PRETO;
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
            arvore.inserir(chave);
        }

        System.out.println("Percurso em ordem da árvore Rubro-Negra:");
        arvore.percursoEmOrdem(arvore.raiz);
        System.out.println();

        System.out.println("Percurso pré-ordem da árvore Rubro-Negra:");
        arvore.percursoPreOrdem(arvore.raiz);
        System.out.println();

        System.out.println("Percurso pós-ordem da árvore Rubro-Negra:");
        arvore.percursoPosOrdem(arvore.raiz);
        System.out.println();
    }
}
