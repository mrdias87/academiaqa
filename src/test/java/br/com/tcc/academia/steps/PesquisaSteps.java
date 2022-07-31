package br.com.tcc.academia.steps;

import br.com.tcc.academia.pages.PesquisaPage;
import br.com.tcc.academia.utils.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.testng.Assert;

public class PesquisaSteps {

    private final AndroidDriver<MobileElement> mobile;
    private final PesquisaPage pesquisaPage;

    public PesquisaSteps() {
        mobile = Driver.getDriverAndroid();
        pesquisaPage = new PesquisaPage(this.mobile);
    }

    @Dado("que não quero realizar o login")
    public void nao_realizar_o_login_com_a_opcao_comecar_sem_login(){
        try {
            Assert.assertTrue(pesquisaPage.clicarComecarSemLogin(),"validar a opção de começar sem login");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Quando("clico na barra de pesquisa")
    public void clicar_na_barra_de_pesquisa(){
        try {
            Assert.assertTrue(pesquisaPage.clicarPesquisaProduto(),"validar a opcao de clicar na barra de pesquisa");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @E("^digito o (.*) a ser pesquisado$")
    public void digitar_o_produto_a_ser_pesquisado(String produto){
        try {
            Assert.assertTrue(pesquisaPage.preencherPesquisaProduto(produto),"validar a opção de preencher o produto para pesquisa");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @E("clico no produto para seleciona-lo")
    public void clicar_no_produto_para_selecionar(){
        try {
            Assert.assertTrue(pesquisaPage.clicarResultadoPesquisa(),"validar a opção de clicar no resultado da pesquisa");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Então("verifico se os dados dele estão corretos")
    public void verificar_se_os_dados_estao_corretos(){
        try {
            Assert.assertTrue(pesquisaPage.validarNomeProduto(),"validar o nome do produto pesquisado");
            Assert.assertTrue(pesquisaPage.validarPrecoProduto(), "validar o preço do produto pesquisado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
