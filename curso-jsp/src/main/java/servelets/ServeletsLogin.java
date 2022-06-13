package servelets;

import java.io.IOException;

import javax.print.attribute.PrintRequestAttribute;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

@WebServlet("/serveletLogin") /* MAPEAMENTO DA URL QUE VEM DA TELA */
public class ServeletsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServeletsLogin() {

	}

	/* Recebe os dados enviados por um formulario */
	/*
	 * HttpServletRequest = tudo que vem da tela* HttpServletRequest = entrega a
	 * resposta para o navegador do usuario
	 */

	/* Recebe os dados da URL em parametros */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* HttpServletRequest = entrega a resposta para o navegador do usuario */
		/* Paramentros para passar para o objeto abaixo */

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		// System.out.println(login);
		// isEmpty diferente de vazio.

		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {

			ModelLogin modelLogin = new ModelLogin();

			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			/* Simulação de login */

			if (modelLogin.getLogin().equalsIgnoreCase("admin")
					&& modelLogin.getSenha().equalsIgnoreCase("admin")) {  /*simulação*/ 
				/* Colocando ana seção e redirecionando para a pagina principal */
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("Principal/principal.jsp");
				redirecionar.forward(request, response);

			} else {

				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", " Informe o login e senha corretamente!! ");
				redirecionar.forward(request, response);
			}

		} else {

			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", " Informe o login e senha corretamente!! ");
			redirecionar.forward(request, response);
		}

		/*
		 * Agora vamos para o metodo de autenticação 2 passo um filtro de login para
		 * exigir que o usuarios esteja logado no login 3 passo ter a conexao com o
		 * banco de dados criar o metodo para acessar o banco de dados
		 */

	}

}
