package com.pruebas.service;
import com.force.api.ApiSession;
import com.force.api.ForceApi;
import com.force.api.QueryResult;
import com.force.sdk.oauth.context.ForceSecurityContextHolder;
import com.force.sdk.oauth.context.SecurityContext;
import org.springframework.stereotype.Service;

@Service
public class pruebaAPI {

	    private ForceApi getForceApi() {
	        SecurityContext sc = ForceSecurityContextHolder.get();
	        ApiSession s = new ApiSession();
	        s.setAccessToken(sc.getSessionId());
	        s.setApiEndpoint(sc.getEndPointHost());
	        return new ForceApi(s);
	    }
	    public void addPerson() {
	        getForceApi().describeSObject("Case");
	    }
}
