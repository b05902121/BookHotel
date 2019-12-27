package model;

/**
 * @author gerber
 * This is an interface of the different services.
 * Every service must implement the method notifyView().
 * notifyView() should call the update() method of the corresponding view class.
 */

public interface ServiceModel {
	public void notifyView();
}
