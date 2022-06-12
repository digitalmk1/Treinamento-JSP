package servelets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

		System.out.println(request.getParameter("Login"));
		System.out.println(request.getParameter("Senha"));
	

	}

}
