package com.ezr.hoopfire.ui.home;

import java.util.Iterator;

import com.ezr.hoopfire.ui.hoopfire.HoopFireViewImpl;
import com.ezr.hoopfire.ui.nba.NbaViewImpl;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class HomeViewImpl extends HomeScreenDesign implements ViewDisplay {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "home";
	private static final String STYLE_SELECTED = "selected";
	HomePresenter presenter;
	Navigator navigator;

	public HomeViewImpl() {
		super();
		initializeView();
		navigator = new Navigator(UI.getCurrent(), (ViewDisplay) this);
		addNavigatorView(HoopFireViewImpl.VIEW_NAME, HoopFireViewImpl.class, home);
		addNavigatorView(NbaViewImpl.VIEW_NAME, NbaViewImpl.class, nba);

		if (navigator.getState().isEmpty()) {
			navigator.navigateTo(HoopFireViewImpl.VIEW_NAME);
		}

		// navigator = new Navigator(UI.getCurrent(), this);

		// addNavigatorView(NcaaBasketballViewImple.VIEW_NAME, OrderView.class,
		// menuButton2);
		// addNavigatorView(AboutView.VIEW_NAME, AboutView.class, menuButton3);
		// if (navigator.getState().isEmpty()) {
		// navigator.navigateTo(DashboardView.VIEW_NAME);
		// }

	}

	private void initializeView() {
		this.presenter = new HomePresenterImpl(this);

		ThemeResource resource = new ThemeResource("img/hoopfire_logo_lg_wh.png");
		this.hoopFireLogo.setSource(resource);

		// home.addClickListener(event -> doNavigate(HomeViewImpl.VIEW_NAME));
		// nba.addClickListener(event -> doNavigate(NbaViewImpl.VIEW_NAME));
		// ncaaBasketball.addClickListener(event -> doNavigate(ncaa.VIEW_NAME));
		// about.addClickListener(event -> doNavigate(AboutView.VIEW_NAME));
		// admin.addClickListener(event -> doNavigate(AboutView.VIEW_NAME));

	}

	private void doNavigate(String viewName) {

		// if (viewName.equalsIgnoreCase(HomeViewImpl.VIEW_NAME)) {
		UI.getCurrent().getNavigator().navigateTo(viewName);
		// showHoopFireScreen() ;
		// } else if (viewName.equalsIgnoreCase(NbaViewImpl.VIEW_NAME)) {
		// UI.getCurrent().getNavigator().navigateTo(viewName);
		// showNBAScreen();
		// }
	}

	private void addNavigatorView(String viewName, Class<? extends View> viewClass, Button menuButton) {
		navigator.addView(viewName, viewClass);
		menuButton.addClickListener(event -> doNavigate(viewName));
		menuButton.setData(viewClass.getName());
	}

	@Override
	public void showView(View view) {
		if (view instanceof Component) {
			scroll_panel.setContent((Component) view);
			Iterator it = menu.iterator();
			while (it.hasNext()) {
				adjustStyleByData((Component) it.next(), view.getClass().getName());
			}
		} else {
			throw new IllegalArgumentException("View is not a Component");
		}
	}

	private void adjustStyleByData(Component component, Object data) {
		if (component instanceof Button) {
			if (data != null && data.equals(((Button) component).getData())) {
				component.addStyleName(STYLE_SELECTED);
			} else {
				component.removeStyleName(STYLE_SELECTED);
			}
		}
	}

	private void showHoopFireScreen() {
		this.contentLayout.removeAllComponents();
		HoopFireViewImpl view = new HoopFireViewImpl();
		this.contentLayout.addComponent(view);
	}

	private void showNBAScreen() {
		this.contentLayout.removeAllComponents();
		NbaViewImpl nbaView = new NbaViewImpl();
		this.contentLayout.addComponent(nbaView);
	}

	// @Override
	// public void enter(ViewChangeEvent event) {
	// presenter.viewEntered(event.getParameters());
	//
	// }
	//
	// @Override
	// public Panel getScrollPanel() {
	// return this.scroll_panel;
	// }

}
