public class Arvore {

    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }

    public void posOrdem(No node) {
        if (node != null) {
            posOrdem(node.esquerda);
            posOrdem(node.direita);
            System.out.print(node.valor + " ");
        }
    }

    public static void main(String[] args) {

        No a = new No("A");
        No b = new No("B");
        No c = new No("C");
        No d = new No("D");
        No e = new No("E");
        No f = new No("F");

        a.esquerda = b;
        a.direita = c;
        b.esquerda = d;
        b.direita = e;
        c.direita = f;

        Arvore arvore = new Arvore();
        int totalNos = arvore.contarNos(a);

        System.out.println("Total de nos na arvore: " + totalNos);

        System.out.print("Pós-ordem: ");
        arvore.posOrdem(a);
    }
}