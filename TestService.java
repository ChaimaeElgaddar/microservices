package org.mql.microservices.MiniSpotify.microServices;


import org.mql.microservices.MiniSpotify.models.Access;
import org.mql.microservices.MiniSpotify.serviceRegistry.ServiceRegistry;

import io.helidon.webserver.Routing.Rules;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class TestService implements Service{
	private int port;
	private String ipAdress;
	private ServiceRegistry serviceRegistry;

	public TestService() {
		serviceRegistry = new ServiceRegistry();
	}
	
	public TestService(int port, String ipAdress) {
		super();
		this.port = port;
		this.ipAdress = ipAdress;
		serviceRegistry = new ServiceRegistry();
	}

	public void update(Rules rules) {
		System.out.println("update method");
		rules.get("/", this::welcome);
	}
	
	public void welcome(ServerRequest serverRequest, ServerResponse serverResponse) {
    	serverResponse.send("hello this is our music library. ENJOY!");
    }
	
	public void sendAccessInformation() {
		//The service need to send regularly the access info
		serviceRegistry.updateRegister(new Access(this.getClass().getSimpleName(), port, ipAdress));
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
    
}
