package com.ezr.hoopfire;

import javax.servlet.annotation.WebServlet;

import com.ezr.hoopfire.ui.home.HomeViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("hoopFiretheme")
public class MyUI extends UI {

	private static final long serialVersionUID = 1L;
	// private CrudService<Person> service = new CrudService<>();
	// private DataProvider<Person, String> dataProvider = new
	// CallbackDataProvider<>(query -> service.findAll().stream(),
	// query -> service.findAll().size());

	protected static final String MAINVIEW = "main";

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		getPage().setTitle("HoopFire");
		// Navigator navigator = new Navigator(UI.getCurrent(),
		// homeView.getScrollPanel());
		// homeView = new HomeViewImpl(navigator);
		setContent(new HomeViewImpl());

	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}
}
