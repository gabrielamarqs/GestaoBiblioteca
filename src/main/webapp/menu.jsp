<%
	Boolean isAdmin = (Boolean) request.getSession().getAttribute("admin");
%>

<div class="imgLogo">
	<img src="assets/librakey.svg" alt="libra key">
	<span>Logue na sua conta</span>
</div>
<div class="left">
	<input class="btnHome" type="search" placeholder="Pesquisar" aria-label="Search" onclick="">
	<!-- pesquisar depois como faz quando der enter pra pesquisar -->
	<div class="divBtn">
		<button class="btnHome btnDadosPessoais" type="button">
			<a href="controller_usuario?action=usuario">
				Dados pessoais
			</a>
		</button>
	</div>
	<div class="divBtn">
		<button class="btnHome btnLivros" type="button">
			<a href="controller_livro">Livros</a>
		</button>
	</div>

	<% if (isAdmin != null && isAdmin) { %>
	<div class="divBtn">
		<button class="btnHome btnPendentes" type="button">
			<a>
				Emprestimos
			</a>
		</button>
	</div>

	<div class="divBtn">
		<button class="btnHome btnEditarUsuario" type="button">

			<a href="controller_all_users">
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
