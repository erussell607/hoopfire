package com.ezr.hoopfire.ui.nba;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

public class NbaViewImpl extends NbaDesign implements NbaView {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "nba";
	NbaPresenter presenter;

	public NbaViewImpl() {
		super();
		initializeView();
	}
	
	private void initPageSize() {
//		ThemeResource resource = new ThemeResource("img/nba_logo_lg_wh.png");
//		this.nbaLogo.setSource(resource);
		 
	}

	private void initializeView() {
		initPageSize();
		
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
//		presenter.viewEntered(event.getParameters());

	}

}
