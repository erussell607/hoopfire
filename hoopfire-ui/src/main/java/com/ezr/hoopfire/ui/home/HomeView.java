package com.ezr.hoopfire.ui.home;

import com.vaadin.navigator.View;
import com.vaadin.ui.Panel;
 
public interface HomeView extends View {

	void showView(View view);

	Panel getScrollPanel();
}
