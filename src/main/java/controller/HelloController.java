package controller;


import com.example.Main;
import com.example.dao.HelloDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.HelloService;

/**
 *
 * @author Programmer
 */
public class HelloController extends SimpleFormController {
    private HelloService helloService;
        
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
    DefaultSqlSessionFactory sessionFactory  = (DefaultSqlSessionFactory) ctx.getBean("sqlSessionFactory");
    //SqlSessionFactory sessionFactory = null;
   
    HelloDAO helloDAO = new HelloDAO(sessionFactory);
    
    
    
    
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
        
    }
    
    public HelloController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Name.class);
        setCommandName("name");
        setSuccessView("helloView");
        setFormView("nameView");
    }
    
    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        
        
        Name name = (Name) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        //mv.addObject("helloMessage", helloService.sayHello(name.getValue()));
        mv.addObject("helloMessage", helloService.sayHello(helloDAO.selectByIdString(1)));
        
        return mv;
    }
     
}
