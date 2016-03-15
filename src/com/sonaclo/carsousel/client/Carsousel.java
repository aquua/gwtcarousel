package com.sonaclo.carsousel.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Carsousel extends HTMLPanel {

	private static final String TAG = "<div id=\"owl-example\" class=\"owl-carousel\"> #imgDiv# </div> ";
	private static final String IMG_DIV = "<div #class#><img #width# #height# src=\"#imgUrl#\"></div>";

	private Carsousel(String carsouselTag) {
		super(carsouselTag);
		this.setWidth(Window.getClientWidth() + "px");
		
	}


	
	public static Carsousel createCarsousel(String...imgUrls ){
		return createCarsousel("", 0,0,imgUrls);
	}
	
	
	public static Carsousel createCarsousel(String cssClassName, String...imgUrls ){
		return createCarsousel(cssClassName, 0,0,imgUrls);
	}
	
	
	public static Carsousel createCarsousel(String cssClassName, int width, int height,String...imgUrls ){
		String divTag = makeCarsouselTag(cssClassName,width+"", height+"",imgUrls);
		JSNI.log(divTag);
		return new Carsousel(divTag);
	}
	
	
	private static String makeCarsouselTag(String cssClassName, String width, String height, String[] imgUrls) {
		StringBuilder sb = new StringBuilder();
		for ( String url : imgUrls){
			String imgDiv = IMG_DIV.replace("#imgUrl#", url);
			
			imgDiv = setCssClass(cssClassName, imgDiv);
			imgDiv = setWidth(width, imgDiv);
			imgDiv = setHeight(height, imgDiv);
			sb.append(imgDiv);
		}
		return TAG.replace("#imgDiv#", sb.toString());
	}



	private static String setHeight(String height, String imgDiv) {
		if ( height.equals("0")){
			imgDiv = imgDiv.replace("#height#","");
		}else if ( height.contains("=")){
			imgDiv = imgDiv.replace("#height#",height);
		}else{
			imgDiv = imgDiv.replace("#height#","height="+"\""+height+"px\"");
		}
		return imgDiv;
	}



	private static String setWidth(String width, String imgDiv) {
		if ( width.equals("0")){
			imgDiv = imgDiv.replace("#width#","");
		}else if ( width.contains("=")){
			imgDiv = imgDiv.replace("#width#",width);
		}else{
			imgDiv = imgDiv.replace("#width#","width="+"\""+width+"px\"");
		}
		return imgDiv;
	}



	private static String setCssClass(String cssClassName, String imgDiv) {
		if ( cssClassName.contains("=")){
			imgDiv = imgDiv.replace("#class#",cssClassName);
		}else{
			imgDiv = imgDiv.replace("#class#","class=\""+cssClassName+"\"");
		}
		return imgDiv;
	}

	public void play() {
		Carsousel.playCarsousel();
	}

	private static native void playCarsousel() /*-{
		$wnd.$("#owl-example").owlCarousel(
		{
//			navigation : true, // Show next and prev buttons
			slideSpeed : 300,
			paginationSpeed : 400,
			itemsMobile : true,
			singleItem : true
		}
		);
	}-*/;
}
