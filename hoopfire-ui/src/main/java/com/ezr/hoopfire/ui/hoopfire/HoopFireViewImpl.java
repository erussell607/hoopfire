package com.ezr.hoopfire.ui.hoopfire;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;

public class HoopFireViewImpl extends HoopFireDesign implements HoopFireView {

	private static final long serialVersionUID = 1L;
	HoopFirePresenter presenter;

	public HoopFireViewImpl() {
		super();
		initializeView();
	}
	
	private void initPageSize() {
		ThemeResource resource = new ThemeResource("img/hoopfire_logo_lg_wh.png");
		this.hoopFireLogo.setSource(resource);
		 
	}

	private void initializeView() {
		initPageSize();
		
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		presenter.viewEntered(event.getParameters());

	}

}
