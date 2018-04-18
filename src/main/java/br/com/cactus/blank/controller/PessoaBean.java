package br.com.cactus.blank.controller;



import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.cactus.blank.model.Pessoa;
import br.com.cactus.common.dao.PessoaDAO;

@Model
public class PessoaBean {
	
	@Inject
	private PessoaDAO pessoaDAO;	
	private Pessoa pessoa;

	public PessoaBean(){
		pessoa = new Pessoa();
	}
		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String salvar(){
		if(getPessoa().getId() == null || getPessoa().getId() == 0){
			pessoaDAO.salvar(getPessoa());
		}else{
			pessoaDAO.atualizar(getPessoa());
		}
		
		return "lista-pessoas.xhtml";
			
	}
	
	public List<Pessoa> getLista() {
		return pessoaDAO.listar();
	}

	
	public String editar(){
		return "cadastro.xhtml";
	}
	
		
	public void remover(){
		pessoaDAO.remover(getPessoa().getId());
	}
	
		
	public String test(){
		return "/index.xhtml";
	}
	
	
/*	public void geraRelatorio() throws JRException{
		JasperReport pathjrxml = JasperCompileManager.compileReport("relatorios/pessoas.jrxml");
		JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(getLista()));
		JasperExportManager.exportReportToPdfFile(printReport, "relatorios/pessoas.pdf");
		
	}
*/
}
