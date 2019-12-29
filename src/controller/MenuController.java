package controller;

import javax.swing.JFrame;

import view.MenuView;

public class MenuController extends BaseController {
	private MainController mainController;
	private MenuView menuView = new MenuView();
	// MenuModel menuModel = new MenuModel(this);

	public MenuController(MainController mainController) {
		this.mainController = mainController;
	}

	public void show(JFrame frame) {
		menuView.setProperty(this, frame);
		frame.setVisible(true);
	}
}
