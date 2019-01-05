package org.mql.microservices.MiniSpotify.serviceRegistry;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.mql.microservices.MiniSpotify.models.Access;


public class ServiceRegistry {
	//serviceName + port + ipAdresse
	private List<Access> microServiceAccess;

	public ServiceRegistry() {
		microServiceAccess = new Vector<Access>();
	}
	
	public String findServiceByName(String serviceName) {
		for (Access access : microServiceAccess) {
			if(access.getServiceName().equals(serviceName)) return access.toString();
		}
		
		return "Service not found";
	}
	
	public String findServiceByPort(int port) {
		for (Access access : microServiceAccess) {
			if(access.getPort() == port) return access.toString();
		}
		
		return "Service not found";
	}

	public List<Access> findAllAvailableServices() {
		return microServiceAccess;
	}
	
	public void updateRegister(Access newAccess) {
		int iterator = 0;
		boolean found = false;
		for (Access access : microServiceAccess) {
			if(access.getServiceName().equals(newAccess.getServiceName())) {
				microServiceAccess.set(iterator, newAccess);
				found = true;
			}
			iterator++;
		}
		
		if(!found) microServiceAccess.add(newAccess);
	}
	

}
