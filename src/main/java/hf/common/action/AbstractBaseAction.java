package hf.common.action;


import hf.common.context.IWebPageContext;
import hf.common.context.WebPageContext;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by AnkitNigam on 7/27/2018.
 */


public class AbstractBaseAction {

    protected IWebPageContext context;
    protected WebDriverWait wait;

    public AbstractBaseAction() {
        this.context = WebPageContext.getInstance();
        this.wait = this.context.getWait();
    }
}
