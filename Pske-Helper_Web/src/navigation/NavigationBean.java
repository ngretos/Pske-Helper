/**
 * 
 */
package navigation;

import javax.faces.bean.ManagedBean;

/**
 * @author ngretos
 *
 */
@ManagedBean
public class NavigationBean {
	
	public static final String MAIN_PAGE = "MainLayout.xhtml";
	
	public static final String HOME_PAGE = "Home.xhtml";

	private String page = MAIN_PAGE;

	public String getMainPage()
	{
		return MAIN_PAGE;
	}

	public String doNav(String menuId) {
		
		switch (menuId) {
		case "CallPhases":
			return "CallPhases.xhtml";
		case "Users":
			return "Users.xhtml";
		case "CheckPoints":
			return "Check Points/CheckPoints.xhtml";

		default:
			return "Check Points/CheckPoints.xhtml";//HOME_PAGE;
		}

	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	

}
