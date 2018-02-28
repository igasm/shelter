package com.igasm.shelter;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebstoreAppInitializer implements WebApplicationInitializer {

  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(MvcConfiguration.class);

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",
        new DispatcherServlet(context));
    dispatcher.addMapping("/");
  }

}
