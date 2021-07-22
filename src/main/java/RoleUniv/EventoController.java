package RoleUniv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/evento")
public class EventoController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String op = request.getParameter("op");
    op = (op == null ? "" : op);

    Evento evento = new Evento();
    evento.setCodigo(request.getParameter("codigo"));
    evento.setNome(request.getParameter("nome"));
    evento.setCidade(request.getParameter("cidade"));

    List<Evento> eventos = null;
    try {
      if (op.equals("incluir")) {
        EventoModel.incluir(evento);
      } else if (op.equals("alterar")) {
        EventoModel.alterar(evento);
      } else if (op.equals("excluir")) {
        EventoModel.excluir(evento);
      } else if (op.equals("consultar")) {
        EventoModel.consultar(evento);
      } else if (op.equals("listar")) {
        EventoModel.listar();
      } else if (op.equals("salvar")) {
        EventoModel.salvar(evento);
      }

      if (op.equals("consultar")) {
        eventos = EventoModel.consultar(evento);
      } else {
        eventos = EventoModel.listar();
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    // Adiciona a variável na requisição para o JSP trabalhar.
    request.setAttribute("eventos", eventos);

    // Redireciona requisição para o JSP.
    request.getRequestDispatcher("/home.jsp").forward(request, response);
  }
}
