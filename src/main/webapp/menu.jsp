<%
	Boolean isAdminMenu = (Boolean) request.getSession().getAttribute("admin");
%>

<div class="left">
	<div class="divImagem">
		<div class="imgLogo">
			<img src="assets/librakey.svg" alt="libra key">
		</div>
		<div>
			<span> HOME </span>
		</div>
	</div>

	<div class="divBtn">
		<form action="livros?action=buscar" method="post">
			<input name="buscar" class="btnHome" type="search" placeholder="Pesquisar" aria-label="Search" onclick="">
		</form>
	</div>

	<div class="divBtn">
		<button class="btnHome btnLivros" type="button">
			<a href="livros">Home</a>
		</button>
	</div>

	<div class="divBtn">
		<button class="btnHome btnDadosPessoais" type="button">
			<a href="usuarios?action=usuario">
				Dados pessoais
			</a>
		</button>
	</div>

	<% if (isAdminMenu != null && isAdminMenu) { %>

	<div class="divBtn">
		<button class="btnHome btnPendentes" type="button">
			<a href="emprestimo.jsp">
				Emprestimos
			</a>
		</button>
	</div>

	<div class="divBtn">
		<button class="btnHome btnEditarUsuario" type="button">

			<a href="controller_all_users">
<%--				esse cambiar depois também--%>
				Editar usuario
			</a>
		</button>

	</div>

	<% } %>

	<div class="divBtn">
		<button class="btnGreen">
			<a href="loginn" class="btnLogout" type="button">Sair</a>
		</button>
	</div>
</div>
