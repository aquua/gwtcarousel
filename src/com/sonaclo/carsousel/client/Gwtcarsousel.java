package com.sonaclo.carsousel.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwtcarsousel implements EntryPoint {

	public void onModuleLoad() {


		String[] url = {
				"http://i0.wp.com/lh3.googleusercontent.com/-2uFeTrGieRA/Vtwv9kb0yiI/AAAAAAAABMw/DmO4ZqmbtSg/s0/KakaoTalk_20160306_220000093.jpg?ssl=1",
		"http://i0.wp.com/lh3.googleusercontent.com/-2uFeTrGieRA/Vtwv9kb0yiI/AAAAAAAABMw/DmO4ZqmbtSg/s0/KakaoTalk_20160306_220000093.jpg?ssl=1"};

		final Carsousel carsousel = Carsousel.createCarsousel("carousel-padding",300,100,url);
		RootPanel.get().add(carsousel);

		Scheduler.get().scheduleDeferred(new Command() {
			public void execute () {
				carsousel.play();
			}
		});
	}
}
