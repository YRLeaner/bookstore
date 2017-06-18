package action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tyr on 2017/5/27.
 */
public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {


    private static final long serialVersionUID = 1L;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected ServletContext application;


    @Override
    public void setServletContext(ServletContext servletContext) {
            this.application = servletContext;
    }

    @Override
    public void setServletResponse(javax.servlet.http.HttpServletResponse httpServletResponse) {
            this.response = httpServletResponse;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
            this.request = httpServletRequest;
            this.session = this.request.getSession();
    }
}
