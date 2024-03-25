import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private final ArrayList<String> dados;
    private final String separadorCSV;
    private final boolean primeiraLinha;
    private final String path;

    public Parser(String path, boolean primeiraLinha, String separadorCSV) {
       this.path = path;
       this.primeiraLinha = primeiraLinha;
       this.dados = lerArquivo();
       this.separadorCSV = separadorCSV;
    }

    private ArrayList<String> lerArquivo() {
        BufferedReader br = null;
        String linha = "";
        ArrayList<String> linhas = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));

            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
            if (!primeiraLinha) {
                linhas.remove(0);
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return linhas;
    }

    public ArrayList<Plataforma> obterPlataformas() {
        ArrayList<String> plataformaString = new ArrayList<>();
        for (String linha : dados) {
            String p = linha.split(separadorCSV)[3];
            if (!plataformaString.contains(p)) {
                plataformaString.add(p);
            }
        }
        ArrayList<Plataforma> plataforma = new ArrayList<>();
        for (String p : plataformaString) {
            plataforma.add(new Plataforma(p));
        }
        return plataforma;
    }

    public ArrayList<Loja> obterLojas() {
        ArrayList<String> lojaString = new ArrayList<>();
        for (String linha : dados) {
            String l = linha.split(separadorCSV)[2];
            if (!lojaString.contains(l)) {
                lojaString.add(l);
            }
        }
        ArrayList<Loja> lojas = new ArrayList<>();
        for (String l : lojaString) {
            lojas.add(new Loja(l));
        }
        return lojas;
    }

    public ArrayList<Produto> obterProdutos() {

        ArrayList<String> nomeProdutoString = new ArrayList<>();
        ArrayList<String> precoProdutoString = new ArrayList<>();

        for (String linha : dados) {
            String n = linha.split(separadorCSV)[4];
            String p = linha.split(separadorCSV)[6];

            if (!nomeProdutoString.contains(n)) {
                nomeProdutoString.add(n);
                precoProdutoString.add(p);
            }
        }
        ArrayList<Produto> produtos = new ArrayList<>();
        for (int i = 0; i < nomeProdutoString.size(); i++) {
            produtos.add(new Produto(nomeProdutoString.get(i), Double.parseDouble(precoProdutoString.get(i))));
        }
        return produtos;
    }

    public ArrayList<Venda> obterVendas() {

        ArrayList<Plataforma> plataformas = obterPlataformas();
        ArrayList<Loja> lojas = obterLojas();
        ArrayList<Produto> produtos = obterProdutos();
        ArrayList<Venda> vendas = new ArrayList<>();
        for (int i = 0; i < dados.size(); i++) {

            String dd[] = dados.get(i).split(separadorCSV);
            String plataforma = dd[3];
            String loja = dd[2];
            String produto = dd[4];
            Plataforma pl = new Plataforma();
            Loja lj = new Loja();
            Produto pd = new Produto();
            for (Plataforma plat : plataformas) {
                if (plat.getNome().equals(plataforma)) {
                    pl = plat;
                    break;
                }
            }
            for (Loja loj : lojas) {
                if (loj.getNome().equals(loja)) {
                    lj = loj;
                }
            }
            for (Produto prod : produtos) {
                if (prod.getNome().equals(produto)) {
                    pd = prod;
                }
            }

            Venda v = new Venda(pl, dd[0], Integer.parseInt(dd[1]), Integer.parseInt(dd[5]), pd.getPrecoUnitario() * Integer.parseInt(dd[5]), lj, pd);
            vendas.add(v);

        }
        return vendas;
    }
}

