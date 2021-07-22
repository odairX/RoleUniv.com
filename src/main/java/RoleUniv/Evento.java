package RoleUniv;

public class Evento {
  private String codigo;
  private String nome;
  private String cidade;

  public String getCodigo() {
    return this.codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public boolean hasCodigo() {
    return codigo != null && !codigo.trim().equals("");
  }
}
