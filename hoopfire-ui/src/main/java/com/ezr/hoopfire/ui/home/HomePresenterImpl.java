package com.ezr.hoopfire.ui.home;

public class HomePresenterImpl implements HomePresenter {
	private HomeView view;

	public HomePresenterImpl(HomeViewImpl homeView) {
		this.view = homeView;
	}

	@Override
	public void viewEntered(String parameters) {
		
		this.view.showView(view);
	}

}
