public class Arvore {
    private No raiz;

    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, String valor) {
        if (no == null) return new No(valor);

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balance = altura(no.esquerda) - altura(no.direita);

        if (balance > 1 && valor.compareTo(no.esquerda.valor) < 0)
            return rotacaoDireita(no);

        if (balance < -1 && valor.compareTo(no.direita.valor) > 0)
            return rotacaoEsquerda(no);

        if (balance > 1 && valor.compareTo(no.esquerda.valor) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && valor.compareTo(no.direita.valor) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
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

    private int altura(No no) {
        return no == null ? 0 : no.altura;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
    }

    private void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdem(no.direita);
        }
    }

    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserir("A");
        arvore.inserir("B");
        arvore.inserir("C");
        arvore.inserir("D");
        arvore.inserir("E");
        arvore.inserir("F");
        System.out.println("Total de nós: " + arvore.contarNos());
        System.out.print("Em ordem: ");
        arvore.imprimirEmOrdem();
    }
}