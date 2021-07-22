<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="RoleUniv.Evento"%>
<%@page import="java.util.List"%>

<html>

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Pagina do Administrador</title>

  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Bootstrap core CSS-->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.html">RoleUniv.com</a>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
      <div class="input-group">
      </div>
    </form>
    <!-- Navbar -->
    <a class="navbar-brand mr-1" href="index.html">Sair</a>
  </nav>

  <div style="margin-top: 15px">
    <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8">
          <ol class="breadcrumb">
            <li><a href="evento">Menu</a></li>
            <li><a href="evento">Editar</a></li>
          </ol>
          <div class="panel panel-default">
            <div class="panel-body">
              <form>
                <div class="form-group">
                  <input name="codigo" value="${param.codigo}" type="text" placeholder="Código do evento" class="form-control">
                </div>
                <div class="form-group">
                  <input name="nome" value="${param.nome}" type="text" placeholder="Nome do evento" class="form-control">
                </div>
                <div class="form-group">
                  <input name="cidade" value="${param.cidade}" type="text" placeholder="Cidade do evento" class="form-control">
                </div>
                <button name="op" value="incluir" class="btn btn-primary">Incluir</button>
                <button name="op" value="alterar" class="btn btn-primary">Alterar</button>
                <button name="op" value="excluir" class="btn btn-primary">Excluir</button>
                <button name="op" value="consultar" class="btn btn-primary">Consultar</button>
                <button name="op" value="listar" class="btn btn-primary">Listar</button>
                <button name="op" value="salvar" class="btn btn-primary">Salvar</button>
              </form>
            </div>
          </div>
           <table class="table table-bordered table-striped">
          <tr>
            <td>Código</td>
            <td>Nome</td>
            <td>Cidade</td>
            <td>Ações</td>
          </tr>
          <%
          //Obtendo a lista de evento definida no controller.
          List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
          for (Evento v:eventos) {
          %>
            <tr>
              <td><a href="evento?codigo=<%=v.getCodigo()%>&nome=<%=v.getNome()%>&cidade=<%=v.getCidade()%>"><%=v.getCodigo()%></a></td>
              <td><%=v.getNome()%></td>
              <td><%=v.getCidade()%></td>
              <td><a href="evento?op=excluir&codigo=<%=v.getCodigo()%>">Excluir</a></td>
            </tr>
          <%
          }
          %>
        </table>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>

</body>

</html>