package br.com.cactus.blank.relatorios;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cactus.common.dao.PessoaDAO;


@WebServlet("/relatorios/pessoas")
public class RelatorioDePessoas extends HttpServlet{
	
	@Inject
	private PessoaDAO pessoaDAO;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ServletContext contexto = request.getServletContext();
		String jrxml = contexto.getRealPath("relatorios/pessoas.jrxml");
		
		Map<String, Object> parametros = new HashMap<>();
		
		GeradorDeRelatorios gerador = new GeradorDeRelatorios(pessoaDAO.listar());
		gerador.geraPdf(jrxml, null, response.getOutputStream());
		
	
		
	}
}