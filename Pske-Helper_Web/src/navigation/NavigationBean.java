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
	
	public String getPageURL(String menuId) {
		
		switch (menuId) {
		case "CallPhases":
			return "CallPhases.xhtml";
		case "Users":
			return "Users.xhtml";
		case "CheckPoints":
			return "CheckPoints.xhtml";

		default:
			return "MainPage.xhtml";
		}

	}
	

}
