package attTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import View.*;
import Zumbi.*;
import zumbi.Interfaces.IRedutorPossibilidades.*;
import Interfaces.*;

public class attTable implements IattTable{
	private ArrayList<ITableReceptacle> receptacles;
	private ITableProducer producer;
	private String[] attributes;
    private String[][] instances;
    private IRedutorPossibilidades redutor;
    private IView View;
    
	public attTable() {
		receptacles = new ArrayList<ITableReceptacle>();
	}
	
	// Conecta com o DScomponent e pega a primeira tabela
	public void connect(ITableProducer producer) {
		this.producer = producer;
		this.attributes= producer.requestAttributes();
        this.instances = producer.requestInstances();
	}
	

	public void connect(IRedutorPossibilidades redutor) {
		this.redutor = redutor;
	}
	
	public void connect(IView view){
	    this.View = view;
    }
	
	public void attach(ITableReceptacle tableReceptacle) {
		receptacles.add(tableReceptacle);
	}
	
	public void notifyReceptacle() {
		for (ITableReceptacle receptacle: receptacles)
			receptacle.updateTable(instances);
	}

	public void giveDiagnostic(String doenca) {
		if (this.View != null) {
			this.View.diagnostico(doenca);
		}
	}

	public void update(int pergunta, String resposta) {
		System.out.println("Atribuots" + attributes[pergunta]);
		if(this.View!=null) {
			this.View.updateV(this.attributes, pergunta, resposta);
		}
		System.out.println("instancias antes");
    	for (int i = 0; i < instances.length ; i++) {
    		for (int j =0 ; j < instances[0].length ; j++) {
    	    	System.out.print(instances[i][j]);

    		}
        	System.out.println();
    	}
		instances = redutor.novaTabela(instances, pergunta, resposta);
		notifyReceptacle();
	}
}
