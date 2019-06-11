package Zumbi;
import java.io.BufferedReader;
import Interfaces.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import graphicCreator.graphicCreator;

public class Doctor  implements IDoctor{

    private int patientN = 0;
    private ITableProducer producer;
    private IResponder responder;
    private IgraphicCreator graphicCreator;
    private IattTable attTable;
    private INextQuestion nextQuestion;
    private Map<String,Integer> diseaseCases;
    private int next_q;
    private String[] attributes;
    private String[][] instances;
    

    public void connect(ITableProducer producer) {
        this.producer = producer;
        this.attributes = producer.requestAttributes();
        this.instances = producer.requestInstances();
    }

    public void connect(IResponder responder) {
        this.responder = responder;
    }
    
    public void connect(IgraphicCreator graphicCreator) {
    	this.graphicCreator = graphicCreator;
    }
    
    public void connect(INextQuestion nextQuestion) {
    	this.nextQuestion = nextQuestion;
    }
    
    public void connect(IattTable attTable) {
    	this.attTable = attTable;
    }

	private void countDiseases() {
		diseaseCases = new HashMap<String,Integer>();
		int k;
		for (String doenca : graphicCreator.possibleDiseases()) {
			k = 0;
			for (int i = 0; i<instances.length;i++) {
				if (instances[i][attributes.length - 1].equalsIgnoreCase(doenca)) {
					k++;
				}
			}
			diseaseCases.put(doenca,k);
		}
	}
	
	private int cases(String doenca) {
		return diseaseCases.get(doenca);
	}
	
	private void Diagnostic(String diagnostic) {
		attTable.giveDiagnostic(diagnostic);
	}

    public void startInterview() {
        int n_questions = 0;
        String diagnostic = "I don't know";
        
        
        while ((graphicCreator.possibleDiseases()).size() > 1 && n_questions < attributes.length - 1) {
        	next_q = nextQuestion.nextQ();
        	System.out.println("foi perguntada a doença " + next_q);
        	attTable.update(next_q, responder.ask(attributes[next_q]));
        	graphicCreator.update(attributes[next_q]);
        	System.out.println("Agora há " +(graphicCreator.possibleDiseases()).size()+ "doenças possíveis");
            n_questions++;
        }
        if ((graphicCreator.possibleDiseases()).size() <= 1) { // Só sobrou uma doença possível
        	diagnostic = graphicCreator.possibleDiseases().get(0);
        } else {
        	System.out.println("Duas ou mais possibilidades");
        	// O diagnóstico será a doença que aparece mais vezes
        	countDiseases();
    		String m_freq = "";
    		int maior = 0;
        	for (String doenca : graphicCreator.possibleDiseases()) {
        		if (cases(doenca) > maior) {
        			maior = cases(doenca);
        			m_freq = doenca;
        		}		
        	}
        	diagnostic = m_freq;
        }

        
        for (int a = 0; a < attributes.length - 1; a++)
            System.out.println("Question: " + responder.ask(attributes[a]));

        System.out.println("Disease guess: " + diagnostic);
        boolean result = responder.finalAnswer(diagnostic);
        System.out.println("Result: " + ((result) ? "I am right =)" : "I am wrong =("));
        graphicCreator.createGraphic();
        Diagnostic(diagnostic);
    }
}
