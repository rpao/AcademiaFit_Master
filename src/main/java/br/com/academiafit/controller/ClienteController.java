package br.com.academiafit.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.ClienteService;
import br.com.academiafit.vo.ClienteVO;


@ManagedBean (name = "clienteMbean") //managedBean significa que e a camada controller
@SessionScoped //nao apaga os dados quando clica em outro botao e sai da pagina
public class ClienteController extends AbstractController {
	
	public static String TELA_LISTAR_TODOS = "/cliente/listarTodos.xhtml"; // criando tela para listar todos os clientes incluidos
	public static String TELA_CADASTRAR = "/cliente/cadastrar_cliente.xhtml"; //criando tela para cadastrar cliente
	
	@Autowired //permissao de acesso a camada service
	private ClienteService clienteService; // acesso a service 
	
	private List<ClienteVO> listaClienteVO; //armazena os dados
	
	private ClienteVO cliente = new ClienteVO(); //variavel que pega os dados da view
	
	@PostConstruct
	private void init() {
		super.getConfigSpring();// super serve para consultar a classe pai
	}
	
	//get e set
	public ClienteVO getCliente() {//
		return cliente;
	}
	public void setCliente(ClienteVO employee) { //
		this.cliente = cliente;
	}
	
	public List<ClienteVO> getListaClienteVO() { //
		return listaClienteVO;
	}
	
	public String chamarTelaCadastro(){ // chama a tela de cadastro
		return TELA_CADASTRAR;
	}
	public String chamarTelaListarTodos(){
		listaClienteVO = clienteService.listarTodos(); //
		return TELA_LISTAR_TODOS;
	}
	
	public String incluir() throws BusinessException{
		clienteService.incluir(cliente); // a camada service que inclui
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null," Cliente incluido com sucesso!"));		
		return "";  	// getcurrentinstance serve para pega o que esta acontecendo agora  e depois imprime a mensagem
	}
											//throws serve para permiter que o sistema nao pare por causa de um erro. BusinessException define a execao.
	public String excluir(ClienteVO clienteVO){		
		try{                       
			clienteService.excluir(clienteVO);// a camada service que exclui
			this.listaClienteVO = clienteService.listarTodos();

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}		// getcurrentinstance serve para pega o que esta acontecendo agora  e depois imprime a mensagem
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Cliente excluido com sucesso!"));
		return "";		// getcurrentinstance serve para pega o que esta acontecendo agora  e depois imprime a mensagem
	}
	
}
