package br.com.tcc.academia.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PesquisaPage {
    final AppiumDriver mobile;

    public PesquisaPage(AppiumDriver mobile) {
        this.mobile = mobile;
        PageFactory.initElements(new AppiumFieldDecorator(this.mobile), this);
    }

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id = 'br.com.petz:id/rl_do_anonymous_login']")
    private MobileElement btnComecarSemLogin;

    @AndroidFindBy(id = "br.com.petz:id/toolbar_search")
    private MobileElement btnBarraPesquisa;

    @AndroidFindBy(id = "br.com.petz:id/searchBox")
    private MobileElement edtPequisar;

    @AndroidFindBy(id = "br.com.petz:id/tv_prod_name")
    private MobileElement lblNomeProduto;

    @AndroidFindBy(id = "br.com.petz:id/cl_prices_module")
    private MobileElement lblPrecoProduto;


    public boolean clicarComecarSemLogin(){
        mobile.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if(btnComecarSemLogin.isDisplayed()){
            btnComecarSemLogin.click();
            return true;
        }
        return false;
    }

    public boolean clicarPesquisaProduto(){
        mobile.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (btnBarraPesquisa.isDisplayed()){
            btnBarraPesquisa.click();
            return true;
        }
        return false;
    }

    public boolean preencherPesquisaProduto(String produto){
        mobile.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (edtPequisar.isDisplayed()){
            edtPequisar.sendKeys(produto);
            mobile.getKeyboard().pressKey(Keys.ENTER);
            return true;
        }
        return false;
    }

    public boolean clicarResultadoPesquisa(){
        mobile.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<MobileElement> resultados = mobile.findElements(By.id("br.com.petz:id/wrapper"));
        if (!resultados.isEmpty()){
            resultados.get(0).click();
            return true;
        }
        return false;
    }

    public boolean validarNomeProduto(){
        mobile.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return lblNomeProduto.isDisplayed();
    }

    public boolean validarPrecoProduto(){
        mobile.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return lblPrecoProduto.isDisplayed();
    }
}
