package filter;

import java.io.IOException;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionContext;

/**
 * @WebFilter("/filterAutenticacao") intercepta todas as requisições que vierem
 * do projeto ou mapeamento o ixdex não passa pelo mapeamento por causa da senha
 */
@WebFilter(urlPatterns = { "principal/*" }) // intercepta todas as requisições
public class FilterAutenticacao implements Filter {

	public FilterAutenticacao() {

	}

	/**
	 * Encerra o processo quando o servidor é parado Filter#destroy() Mataria os
	 * processo de conexao com o banco de dados
	 */
	public void destroy() {

	}

	/**
	 * Intercepta as requisições e as respostas do sistema tudo que for feito no
	 * sistema passa por ele Exemplo: ( validar autenticacao de login, dar comit e
	 * rolback de transações validar e fazer redirecionamento de paginas )
	 * Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// request do filter
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		// esta pegando o paramentro do request.getSession().setAttribute("usuario",
		// modelLogin.getLogin());
		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaautenticar = req.getServletPath();// pega a url que esta sendo acessada

		// agora vamos validar se esta logado se não rediciona para tela de login

		if (usuarioLogado == null
				|| (usuarioLogado != null && usuarioLogado.isEmpty()) && urlParaautenticar.contains("/principal/ServeletLogin")) {

			RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp?url=" + urlParaautenticar);
			request.setAttribute("msg", "Por favor reallize o login!");
			redirecionar.forward(request, response);
			return; // o return para a execução e retorna para o login.

			/****************************************************************
			 * se o usuario for igual igual a null ou usuario diferente de nulo e vazio o o
			 * sistema vai redirecionar para a pagina de login e senha apos logar ele vai
			 * ser redirecionado a atela que estava tentando acessar. na tela de login
			 * presimamos a url <input type="hidden" value="<%=request.getParameter("url")
			 * %>" name="url">
			 * no serveletslogin -> String url = request.getParameter("url");
			 ***************************************************************/

		} else {

			chain.doFilter(request, response);

		}

	}

	/**
	 * Inicia os processos ou recursos quando o servidor sobe os projetos ->
	 * Filter#init(FilterConfig) Inicia a comunicação com o banco de dados.
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
