package com.ezr.hoopfire.ui.home;

import com.ezr.hoopfire.ui.hoopfire.HoopFireViewImpl;
import com.ezr.hoopfire.ui.nba.NbaViewImpl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;

public class HomeViewImpl extends HomeScreenDesign implements HomeView {

	private static final long serialVersionUID = 1L;
	HomePresenter presenter;

	public HomeViewImpl() {
		super();
		initializeView();
	}

	private void initializeView() {
		this.presenter = new HomePresenterImpl(this);
		
		ThemeResource resource = new ThemeResource("img/hoopfire_logo_lg_wh.png");
		this.hoopFireLogo.setSource(resource);

		this.home.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				showHomeScreen();
			}

		});

		this.nba.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				showNBAScreen();
			}

		});

		this.ncaaBasketball.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				showNCAABasketballScreen();
			}

		});

		this.about.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				showAboutScreen();
			}

		});

		this.admin.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				showAdminScreen();
			}

		});

		this.home.click();

	}

	private void showHomeScreen() {
		this.contentLayout.removeAllComponents();
		HoopFireViewImpl hoopFireView = new HoopFireViewImpl();
		this.contentLayout.addComponent(hoopFireView);

	}

	private void showNBAScreen() {
		this.contentLayout.removeAllComponents();
		NbaViewImpl nbaView = new NbaViewImpl();
		this.contentLayout.addComponent(nbaView);

	}

	private void showNCAABasketballScreen() {
		this.contentLayout.removeAllComponents();
		// this.viewTitle.setValue("NCAA Basketball");

	}

	private void showAboutScreen() {
		this.contentLayout.removeAllComponents();
		// this.viewTitle.setValue("About");

	}

	private void showAdminScreen() {
		this.contentLayout.removeAllComponents();
		// this.viewTitle.setValue("Admin");

	}

	@Override
	public void enter(ViewChangeEvent event) {
		presenter.viewEntered(event.getParameters());

	}

	@Override
	public CssLayout getCssLayout() {
		return this.menu;
	}

	@Override
	public void showView(View view) {

	}

}
