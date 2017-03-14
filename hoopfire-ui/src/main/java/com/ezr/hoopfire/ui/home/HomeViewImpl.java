package com.ezr.hoopfire.ui.home;

import com.ezr.hoopfire.ui.hoopfire.HoopFireViewImpl;
import com.ezr.hoopfire.ui.nba.NbaViewImpl;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class HomeViewImpl extends HomeScreenDesign implements HomeView {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "home";
	HomePresenter presenter;
	Navigator navigator;

	public HomeViewImpl() {
		super();
		initializeView();

	}

	public HomeViewImpl(Navigator navigator) {
		this.navigator = navigator;
		initializeView();

		navigator.addView(HomeViewImpl.VIEW_NAME, new HomeViewImpl());
		navigator.addView(NbaViewImpl.VIEW_NAME, new NbaViewImpl());

		if (navigator.getState().isEmpty()) {
			navigator.navigateTo(HomeViewImpl.VIEW_NAME);
		}

	}

	private void initializeView() {
		this.presenter = new HomePresenterImpl(this);

		ThemeResource resource = new ThemeResource("img/hoopfire_logo_lg_wh.png");
		this.hoopFireLogo.setSource(resource);

		home.addClickListener(event -> doNavigate(HomeViewImpl.VIEW_NAME));
		nba.addClickListener(event -> doNavigate(NbaViewImpl.VIEW_NAME));
		// ncaaBasketball.addClickListener(event -> doNavigate(ncaa.VIEW_NAME));
		// about.addClickListener(event -> doNavigate(AboutView.VIEW_NAME));
		// admin.addClickListener(event -> doNavigate(AboutView.VIEW_NAME));
	}

	private void doNavigate(String viewName) {
		if (viewName.equalsIgnoreCase(HomeViewImpl.VIEW_NAME)) {
			UI.getCurrent().getNavigator().navigateTo(viewName);
			showHoopFireScreen();
		} else if (viewName.equalsIgnoreCase(NbaViewImpl.VIEW_NAME)) {
			UI.getCurrent().getNavigator().navigateTo(viewName);
			showNBAScreen();
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

	@Override
	public void enter(ViewChangeEvent event) {
		presenter.viewEntered(event.getParameters());

	}

	@Override
	public VerticalLayout getContentLayout() {
		return this.contentLayout;
	}

	@Override
	public void showView(View view) {

	}

}
