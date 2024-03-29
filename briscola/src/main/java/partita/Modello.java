package partita;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntimeFactory;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;

import classiDMN.Carta;
import classiDMN.Giocatore;
import classiDMN.Turno;

public class Modello {
	private DMNRuntime dmnRuntime;
	private DMNModel dmnModel;
	private DMNResult dmnResult;
	private DMNContext dmnContext;

	public Modello() {
		this.dmnRuntime = dmnRuntime();
		this.dmnModel = dmnModel();
		this.dmnContext = dmnRuntime.newContext();
	}

	@SuppressWarnings("unchecked")
	public Giocatore vincitoreTurno() {
		Map<String, ?> vincitore = (Map<String, ?>) dmnResult.getDecisionResultByName("Vincitore turno").getResult();
		return new Giocatore((String) vincitore.get("nome"), ((BigDecimal) vincitore.get("punti")).intValue(),
				(ArrayList<Carta>) vincitore.get("mano"));
	}

	public String esitoPartita() {
		return (String) dmnResult.getDecisionResultByName("Esito partita").getResult();
	}

	public void esecuzioneModello(Turno turno, Giocatore giocatore1, Giocatore giocatore2) {
		dmnContext.set("Turno", turno);
		dmnContext.set("Giocatore1", giocatore1);
		dmnContext.set("Giocatore2", giocatore2);
		this.dmnResult = dmnRuntime.evaluateAll(dmnModel, dmnContext);
	}

	private DMNRuntime dmnRuntime() {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		return KieRuntimeFactory.of(kieContainer.getKieBase()).get(DMNRuntime.class);
	}

	private DMNModel dmnModel() {
		String namespace = "https://kiegroup.org/dmn/_07F45EE0-E44C-4AA1-9F31-21AD46146042";
		String modelName = "Briscola";
		return dmnRuntime.getModel(namespace, modelName);
	}
}
