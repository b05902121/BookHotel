package controller;

import javax.swing.JFrame;

import view.SearchResultView;

public class SearchResultController extends BaseController{
    private SearchResultView searchResultView = new SearchResultView();

    public SearchResultController() {}

    public void show(JFrame frame) {
        searchResultView.setProperty(this, frame);
        frame.setVisible(true);
    }
}
