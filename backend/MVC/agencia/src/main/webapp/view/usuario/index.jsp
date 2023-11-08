<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Usuario" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Usuario> lista = (List<Usuario>) request.getAttribute("usuarios");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">
<title>BA Tour</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Usuarios</h1>
		</header>

		<ul class="nav justify-content-center">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="./index.html">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="./usuario">Usuario</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="../pacote/">Pacotes</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Reservas</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Pagamentos</a></li>
		</ul>

		<section class="container">

			<div class="p-4">
				<a href="./view/usuario/registroUsuario.html"
					class="btn btn-primary mb-2 botao1"> Novo Usuario </a>
				<table class="table table-responsive table-hover">
					<thead class="table-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome</th>
							<th scope="col">Email</th>
							<th scope="col">Telefone</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>

						<jstl:forEach items="${listaUsuario}" var="u">
							<tr>
								<td>${u.id}</td>
								<td>${u.nome}</td>
								<td>${u.email}</td>
								<td>${u.telefone}</td>

								<td>
									<div class="d-flex">
										<button data-bs-target="#usuario-edit${u.id}"
											data-bs-toggle="modal" class="mx-1" title="Editar">
											<i class="ri-file-edit-line"></i>
										</button>

										<a href="usuario-delete?id=${u.id}" class="mx-1"
											title="Cancelar"
											onclick="return confirm('Deseja excluir: ${u.nome}.')"> <i
											class="ri-delete-bin-2-line"></i>
										</a>
									</div>
								</td>
							</tr>

							<!-- modal editar -->
							<div class="modal fade" id="usuario-edit${u.id}"
								tabindex="-1" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header">
											<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
												Usuario</h1>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>

										<div class="modal-body">

											<form action="./usuario-update">
												<h2 class="text-center">Atualização</h2>
												<div class="form-group mb-3">
													<label for="nome" class="form-label"> Id </label> <input
														type="text" id="id" name="id" class="form-control"
														value="${u.id}" readonly />
												</div>

												<div class="form-group mb-3">
													<label for="nome" class="form-label"> Nome </label> <input
														type="text" id="nome" name="nome" class="form-control"
														value="${u.nome}" />
												</div>

												<div class="form-group mb-3">
													<label for="email" class="form-label"> Email </label> <input
														type="text" id="email" name="email" class="form-control"
														value="${u.email}" />
												</div>
												<div class="form-group mb-3">
													<label for="email" class="form-label"> Telefone </label> <input
														type="text" id="telefone" name="telefone"
														class="form-control" value="${u.telefone}" />
												</div>
												<div class="form-group mb-3">
													<label for="email" class="form-label"> Senha </label> <input
														type="password" id="senha" name="senha"
														class="form-control" value="${u.telefone }" />
												</div>

												<button type="submit" class="btn btn-primary">
													Enviar</button>
												<a href="./usuario" class="btn btn-danger"
													style="margin-left: 10px"> Cancelar </a>
											</form>

										</div>

									</div>
								</div>
							</div>
							<!-- fim do modal editar-->

						</jstl:forEach>
					</tbody>
				</table>
			</div>
		</section>

	</main>

	<footer class="text-center">
		<a class="up-arrow" href="#myPage" data-toggle="tooltip"
			title="TO TOP"> <span class="glyphicon glyphicon-chevron-up"></span>
		</a> <br /> <br />
		<p>
		<p class="mb-0 mt-3">
			<strong>Projeto Bahia Tour | Recode</strong>
		</p>
		<p class="mb-0 mt-3">
			Desenvolvido por <strong>Eduardo Reis</strong>
		</p>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>

</body>
</html>