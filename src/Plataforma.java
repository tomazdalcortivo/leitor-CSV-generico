public class Plataforma {

    private String nome;

    public Plataforma() {
        nome = "";
    }

    public Plataforma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
