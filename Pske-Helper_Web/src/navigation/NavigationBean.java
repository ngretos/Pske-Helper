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
	
	public static final String HOME_PAGE = "Home.xhtml";

	public static final String MAIN_PAGE = "MainLayout.xhtml";
	
	private String page = HOME_PAGE;

	public void doNav(String menuId) {
		
		switch (menuId) {
		case "CallPhases":
			this.page = "CallPhases.xhtml";
			break;
		case "Users":
			this.page = "Users.xhtml";
			break;
		case "CheckPoints":
			this.page = "Check Points/CheckPoints.xhtml";
			break;
		}
		
		this.page = HOME_PAGE;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	

}
