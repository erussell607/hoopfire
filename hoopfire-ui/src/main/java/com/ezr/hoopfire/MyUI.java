package com.ezr.hoopfire;

import javax.servlet.annotation.WebServlet;

import com.ezr.hoopfire.backend.CrudService;
import com.ezr.hoopfire.ui.home.HomeViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("hoopFiretheme")
public class MyUI extends UI {

//	private CrudService<Person> service = new CrudService<>();
//	private DataProvider<Person, String> dataProvider = new CallbackDataProvider<>(query -> service.findAll().stream(),
//			query -> service.findAll().size());
	private HomeViewImpl home = new HomeViewImpl();

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		setContent(home);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
