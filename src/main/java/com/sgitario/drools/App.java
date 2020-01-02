package com.sgitario.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sgitario.drools.model.Person;

public class App {
	public static void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			// go !
			kSession.insert(new Person("Jose", 20));
			kSession.insert(new Person("Irene", 19));
			kSession.insert(new Person("Victor", 21));
			kSession.fireAllRules();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
