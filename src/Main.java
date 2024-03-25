import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String separdorCSV = ";";
        String path = "C:\\\\Users\\\\Usuario\\\\Documents";

        Parser parser = new Parser(path, false, separdorCSV);
        ArrayList<Plataforma> plataformas = parser.obterPlataformas();
        ArrayList<Loja> lojas = parser.obterLojas();
        ArrayList<Produto> produtos = parser.obterProdutos();
        ArrayList<Venda> vendas = parser.obterVendas();
        System.out.println(plataformas);
        System.out.println(lojas);
        System.out.println(produtos);
        System.out.println(vendas);
    }
}