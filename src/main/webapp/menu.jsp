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
		<a href="livros" type="button">
			<button class="btnHome btnLivros" type="button">
				Home
			</button>
		</a>
	</div>

	<div class="divBtn">
		<a href="usuarios?action=usuario">
			<button class="btnHome btnDadosPessoais" type="button">
				Dados pessoais
			</button>
		</a>
	</div>

	<% if (isAdminMenu != null && isAdminMenu) { %>

	<div class="divBtn">
		<a href="emprestimos?action=livrosEmprestados">
			<button class="btnHome btnPendentes" type="button">
				Emprestimos
			</button>
		</a>
	</div>

	<div class="divBtn">
		<a href="controller_all_users">
			<button class="btnHome btnEditarUsuario" type="button">
				Editar usuario
			</button>
		</a>
	</div>

	<% } %>

	<div class="divBtn">
		<a href="loginn" class="btnLogout" type="button">
			<button class="btnGreen">
				Sair
			</button>
		</a>
	</div>
</div>
