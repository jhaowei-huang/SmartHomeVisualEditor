package c4lab.iot.smarthomevisualeditor;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import c4lab.iot.smarthomevisualeditor.page.MainPage;

@SuppressWarnings("serial")
@Theme("smarthomevisualeditor")
public class SmarthomevisualeditorUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SmarthomevisualeditorUI.class, widgetset = "c4lab.iot.smarthomevisualeditor.widgetset.SmarthomevisualeditorWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final MainPage page = new MainPage();
		setContent(page);
	}

}