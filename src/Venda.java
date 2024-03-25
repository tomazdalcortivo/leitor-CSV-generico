public class Venda {
    private Plataforma plataforma;
    private String mes;
    private int ano;
    private int quantidade;
    private double valorTotal;
    private Loja loja;
    private Produto produto;

    public Venda() {
        plataforma = new Plataforma();
        mes = "";
        ano = 0;
        quantidade = 0;
        valorTotal = 0;
        loja = new Loja();
        produto = new Produto();
    }

    public Venda(Plataforma plataforma, String mes, int ano, int quantidade, double valorTotal, Loja loja, Produto produto) {
        this.plataforma = plataforma;
        this.mes = mes;
        this.ano = ano;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.loja = loja;
        this.produto = produto;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getMes());
        sb.append(" ");
        sb.append(this.getAno());
        sb.append(" ");
        sb.append(this.getPlataforma());
        sb.append(" ");
        sb.append(this.getLoja());
        sb.append(" ");
        sb.append(this.getProduto());
        sb.append(" ");
        sb.append(this.getQuantidade());
        sb.append(" ");
        sb.append(this.getValorTotal());
        return sb.toString();
    }
}
