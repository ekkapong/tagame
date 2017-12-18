package com.ts.game.ui.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;
import com.ts.game.ui.model.IPConfig;
import com.ts.game.ui.model.Merchant;
import com.ts.game.ui.model.NodeImageModel;
import com.ts.game.ui.model.NodeModel;
import com.ts.game.ui.service.CentralService;
import com.ts.game.ui.service.RestfulService;

@ManagedBean
@SessionScoped
public class MainView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{settingView}")
    private SettingView settingView;

    private String selectServer;
    private String activeStatus;

    private NodeModel nodeResult = new NodeModel();

    private RestfulService restfulService = new RestfulService();
    private CentralService centralService = new CentralService();

    @PostConstruct
    public void init() {
	selectServer = "";
    }

    public void execute() {

	Gson gson = new Gson();
	Merchant merchant = new Merchant();
	merchant.setDevice_unique_id("");
	merchant.setMerchant_id("100000000000012");
	merchant.setTerminal_id("");
	String json = gson.toJson(merchant);
	ClientResponse response = restfulService.post("https://virtserver.swaggerhub.com/ts-dev/ts-game-01/1.0.0/inventory", json);

	if (response != null) {
	    String output = response.getEntity(String.class);

	    nodeResult = new NodeModel();
	    nodeResult.setTitle("title : " + response.getStatus());
	    nodeResult.setDesciption("desciption : " + output);
	    nodeResult.setImages(new NodeImageModel());
	    nodeResult.getImages().setImage1(
		    "iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAeFBMVEU7WZj///8sT5O3v9RAXJokSpE3VpdacKQzU5Xj5u6Ek7iWosI1VZbq7fRDYJza3+r5+vyrttDQ1+WGmL7L0eH09vpfd6pLZqBrgrFQaaC/xthacaTm6/PDzN9heat5jbemscwMP4yNncAiSJCaqch1h7OAkruxvNRQ5noeAAAEJUlEQVR4nO3dyXLiMBSFYVmAJBLLMwZCBppOwvu/YTNkWDQNit3SvVKdf5ENlZS/soiMLRuRnbNd2xcilYq+7eyHTJx+VrWWRlFv139MGanr6ltY6qR455TR5aewKXLqzfFSXjRnYVmktwPPqaI8Ciud5h48luvqIKwN9XZ4zNSZsDrVMXpMaSs6Sb0VXpOdaFMepIdh2oo+5UF6GKa9SOdQ7XKp+xBCCCGEEEIIIYQQupXKjcmVENPvxPT0glJ5fnjRnF+PtFya9dtuO+lKW2VfVQv7WJZN9/Swr7evu7u3lZ5Sb+mQlJGzflvOF9mtFtbexXfGXsnl3aS6ifvsPjahksW+dObFJ1Sqf3DffREK5XJ/+70XsTAXO3tbFLHQrLuf+2ISypf5EGBEwt0gXzxCuR0IjESoxH4oMBKhGbwHIxHK1+HAKITm5YeHMbEJ882AeT4qoWzGACMQmqETYSxC1Y8aoxEIZ5NxQPZCtR4JZC+UD4kL89WPP/HGJhx+PBqHUE1H70LmQtOOBjIXjjyc4S9U/fhByls49oCNv1CMngyZC0/3JKUt3PxEsrB2fiHW157MuzNvPrl/04WRs79jDBSydvSVq6UyRsV3uXfmNhvaVsZ6LVs6ffZ9XEV745lausz3i57zG+166tnlJOJ9tHvw8MnJ5TRpQ72VY3I6ZnuNd4wehA7n8u060v+ip1wuqJURvwvdJvx93EKHczRx36IsHc4Fr6J+FIKLMO4nBbgIlxCyzkU4TV9IvZGjghBC/kEIIf8ghJB/EELIPwgh5B+EEPJIXcll7azIr/2FY8TAYqP/3dphNc213z+2IT6hau5uG0b2OEtd+ER76SaAsE5eSLzmK4DwnfbilH/hgvjym3/h4yb12aIkvjjlX0i93Ma/kHg6DCAkng4DCHfEazX8C9+SF1IvCvMvpF5Q5F1of6cubKiXvXkXki/s8y4kX1/rXUh+v4x3IfnSRd/CxTP1yUTfwjn1hO9d2JB/g4xv4RM10LtwQj0dehduUxdW9Cv5fQvJp0PfwgX9KnDfQvJd6Fs4p72yFkDI4Hsb85eLt9B/5nCT7LVft+SfnY7EC/fPf/XL4c6uSzfgR3En/qk01mJcC0II+QchhPyDEEL+QQgh/yCEkH8QQsg/CCHkH4QQ8g9CCPkHIYT8gxBC/kEIIf8ghJB/EELIPwgh5B+EEPIPQgj5ByGE/IMQQv5BCCH/IISQfxBCyD8IIeQfhBDyL6CQ6IlZwYSF6GkeZBNKqHpB9LilUELTCqLnvIQSyk5Ymi/6CCRU2oqsJhmmgYSmzkRWaYpnSoUR5ro6CLOyIBinQYSqKLOjMGuK8HsxhDAvmuwszEptQu9G/0JldJl9CrOq1jIs0rNQGanrKvsWZpnt2j7kAZxfYdG3nf34K38ArA5OdTHdpNAAAAAASUVORK5CYII=");
	    
	}
	System.out.println("execute");
    }

    public void decryptNode() {

    }

    public void selectServerChange(final AjaxBehaviorEvent event) {
	centralService.setBaseUrl(selectServer);
    }

    public void activateCentral() {

	IPConfig ipConfig = settingView.getIpConfig();

	if (StringUtils.isNotEmpty(ipConfig.getCentralIp()) && StringUtils.isNotEmpty(ipConfig.getTeamServerIp())) {
	    String[] arr = ipConfig.getTeamServerIp().split(":");
	    centralService.setBaseUrl(ipConfig.getCentralIp());
	    centralService.activate(arr[0], arr[1]);
	}
    }

    public void checkAcitveCentral() {
	IPConfig ipConfig = settingView.getIpConfig();

	if (StringUtils.isNotEmpty(ipConfig.getCentralIp()) && StringUtils.isNotEmpty(ipConfig.getTeamServerIp())) {
	    String[] arr = ipConfig.getTeamServerIp().split(":");
	    centralService.setBaseUrl(ipConfig.getCentralIp());
	    centralService.active(arr[0]);
	}
    }

    public String getSelectServer() {
	return selectServer;
    }

    public void setSelectServer(String selectServer) {
	this.selectServer = selectServer;
    }

    public NodeModel getNodeResult() {
	return nodeResult;
    }

    public void setNodeResult(NodeModel nodeResult) {
	this.nodeResult = nodeResult;
    }

    public String getActiveStatus() {
	return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
	this.activeStatus = activeStatus;
    }

    public SettingView getSettingView() {
	return settingView;
    }

    public void setSettingView(SettingView settingView) {
	this.settingView = settingView;
    }

}
