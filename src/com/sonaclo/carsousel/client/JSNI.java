package com.sonaclo.carsousel.client;

public class JSNI {

	public static native void log(String msg) /*-{
		$wnd.console.log(msg);
	}-*/;

	public static native void play() /*-{
		//	 	 $wnd.$("#owl-example").owlCarousel();
		$wnd.$("#owl-example").owlCarousel({
			navigation : true, // Show next and prev buttons
			slideSpeed : 300,
			paginationSpeed : 400,
			itemsMobile : false,
			singleItem : true

		// "singleItem:true" is a shortcut for:
		// items : 1, 
		// itemsDesktop : false,
		// itemsDesktopSmall : false,
		// itemsTablet: false,
		// itemsMobile : false

		});
	}-*/;
}
