package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dao.FuncionarioDao;
import model.Funcionario;
import utils.Funcoes;

public class FrameEditarFuncionario extends FrameCadastroFuncionario{
	
	public FrameEditarFuncionario(Funcionario f) {
		super();
		System.out.println(f.getNome());
		preencherCampos(f);
		
		//btnSalvar = new JButton("Atualizar");
		/*btnSalvar.remove
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ATT");
				String senha = new String(tfSenha.getPassword());
				FuncionarioDao funcDao = new FuncionarioDao();
				Funcionario func = new Funcionario(tfMatricula.getText(), tfNome.getText(), tfCpf.getText(),
								   (senha.isEmpty() ? f.getSenha() : senha), Funcoes.converterDataEUA(tfDataNasc.getText()),
						   tfFuncao.getText(), true, 1);
				if(funcDao.update(func))
					dispose();
				else
					Funcoes.mostrarMensagemErro("Erro ao salvar");
			}
		});*/
	}
	
	private void preencherCampos(Funcionario f) {
		/*tfMatricula.setText(f.getMatricula());
		tfNome.setText(f.getNome());
		tfCpf.setText(f.getCpf());
		tfDataNasc.setText(Funcoes.converterDataBR(f.getDt_nasc()));
		tfFuncao.setText(f.getFuncao());*/
	}
}
