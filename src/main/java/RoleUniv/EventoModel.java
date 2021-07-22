package RoleUniv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoModel {

  private static Connection obterConexao() throws SQLException {
    // Estabelecer uma conexão com o banco de dados.
    String url = "jdbc:derby://localhost:1527/eventodb;create=true";
    String user = "app";
    String password = "app";
    return DriverManager.getConnection(url, user, password);
  }

  public static void incluir(Evento evento) throws SQLException {
    Connection conn = obterConexao();

    // Obter sentença SQL.
    String sql = "insert into evento (codigo, nome, cidade) values (?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, evento.getCodigo());
    pstmt.setString(2, evento.getNome());
    pstmt.setString(3, evento.getCidade());
    pstmt.execute();
  }

  public static void alterar(Evento evento) throws SQLException {
    Connection conn = obterConexao();

    // Obter sentença SQL.
    String sql = "update evento set nome = ?, cidade = ? where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, evento.getNome());
    pstmt.setString(2, evento.getCidade());
    pstmt.setString(3, evento.getCodigo());
    pstmt.execute();
  }

  public static void salvar(Evento evento) throws SQLException {
    Connection conn = obterConexao();

    // Obter sentença SQL.
    String sql = "update evento set nome = ?, codigo = ? where cidade = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, evento.getNome());
    pstmt.setString(2, evento.getCidade());
    pstmt.setString(3, evento.getCodigo());
    pstmt.execute();
  }

  public static void excluir(Evento evento) throws SQLException {
    Connection conn = obterConexao();

    // Obter sentença SQL.
    String sql = "delete from evento where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, evento.getCodigo());
    pstmt.execute();
  }

  public static List<Evento> consultar(Evento evento) throws SQLException {
    List<Evento> listaDeEventos = new ArrayList<Evento>();
    try {
      Connection conexao = obterConexao();
      PreparedStatement pstmt = conexao.prepareStatement("Select * from evento where codigo =	?");
      pstmt.setString(1, evento.getCodigo());
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        Evento eventos = new Evento();
        eventos.setCodigo(rs.getString("codigo"));
        eventos.setNome(rs.getString("nome"));
        eventos.setCidade(rs.getString("cidade"));
        listaDeEventos.add(eventos);
      }
      pstmt.close();
      conexao.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return listaDeEventos;
  }

  public static List<Evento> listar() throws SQLException {
    Connection conn = obterConexao();

    Statement stmt = conn.createStatement();
    String sql = "select codigo, nome, cidade from evento order by codigo";
    ResultSet rs = stmt.executeQuery(sql);

    List<Evento> listaDeEventos = new ArrayList<Evento>();
    while (rs.next()) {
      // Cria um evento para o registro.
      Evento eventos = new Evento();
      eventos.setCodigo(rs.getString("codigo"));
      eventos.setNome(rs.getString("nome"));
      eventos.setCidade(rs.getString("cidade"));
      // Adiciona o evento na lista de eventos.
      listaDeEventos.add(eventos);
    }
    return listaDeEventos;
  }

}
