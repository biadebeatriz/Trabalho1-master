package graphicCreator;

import java.util.Arrays;
import java.util.Vector;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import Interfaces.*;


public class graphicCreator implements IgraphicCreator{
	private ITableProducer producer;
	private String[] attributes;
    private String[][] instances;
    private Vector<String> askedQuestionsList;
    private Vector<Vector<String>> possibleDiseasesGrid;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;
	
	
    public graphicCreator() {
    	possibleDiseasesGrid = new Vector<Vector<String>>();
    	askedQuestionsList = new Vector<String>();
    }
	
	public Vector<String> possibleDiseases() {
		Vector<String> result = new Vector<String>();
		
		for (int i = 0; i < instances.length; i++) {
			if (!result.contains(instances[i][attributes.length-1])) {
				result.add(instances[i][attributes.length-1]);
			}
		}
		
		
		return result;
		
	}
	
	
	public void connect(ITableProducer producer) {
		this.producer = producer;
    	this.instances = producer.requestInstances();
    	this.attributes = producer.requestAttributes();
    	// Primeira coluna da tabela deve ter as doenças iniciais
        askedQuestionsList.add("Before any question");
        possibleDiseasesGrid.add(possibleDiseases());
	}
	
	public void updateTable(String[][] instances) {
		this.instances = instances;
	}

	public void update(String askedQuestion) {
		// Tem que dar um jeito de atualizar a fonte de dados toda vez que for dar update, pra isso a componente que deleta linhas
		// vai ter que realmente deletar linhas do arquivo. Ideia: fazer o metodo requestAttributes e requestInstances chamar readDS
		        
        askedQuestionsList.add("After asking about "+askedQuestion);
        possibleDiseasesGrid.add(possibleDiseases());
    
    }
	
	// Transforma linhas em colunas para usar na tabela
	private Vector<Vector<String>> organizeData() {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		Vector<String> aux;
		//Object[] aux_obj;
		
		// erro no result.add
		for (int i = 0; i < possibleDiseasesGrid.get(0).size(); i++) {
			aux = new Vector<String>();
			for (int j = 0; j < askedQuestionsList.size();j++) {
				if (possibleDiseasesGrid.get(j).size() > i) {
					aux.add(possibleDiseasesGrid.get(j).get(i));
				}
				else
					aux.add("");
			}

			//System.out.println("-------------------");
			//for (String doenca : aux)
			//	System.out.println(doenca);
			//System.out.println("-------------------");
			result.add(aux);
			//aux_obj = aux.toArray();
			//result.add(Arrays.copyOf(aux_obj, aux_obj.length,String[].class));
		}
		
		
		return result;
	}
	
    public void createGraphic() {
    	JFrame frame = new JFrame("Possibles diseases according to the asked questions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JTable table = new JTable(organizeData(), askedQuestionsList);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	
    	System.out.println("oie");
    }
}
