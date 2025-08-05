package jobs;

import models.TipoImovel;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Iniciar extends Job {
	
	@Override
	public void doJob() throws Exception {
		if(TipoImovel.count() == 0) {
			TipoImovel t1 = new TipoImovel("CASA"); 
			TipoImovel t2 = new TipoImovel("CHALÉ"); 
			TipoImovel t3 = new TipoImovel("APARTAMENTO");
			t1.save();
			t2.save();
			t3.save();
		}
	}
	
}
