package NextQuestion;
import java.util.ArrayList;
import Interfaces.*;

public class NextQuestion implements INextQuestion{
      private String[][] tabela;
      private ITableProducer producer;
      private String[] attributes;
      private ArrayList<Integer> askdQ= new ArrayList<Integer>();
      
      
      public void updateTable(String[][] instances) {
  		tabela = instances;
      }
      
      public void connect(ITableProducer producer) {
  		this.producer = producer;
      	tabela = producer.requestInstances();
      	this.attributes = producer.requestAttributes();
  	  }
      
      public int nextQ(){
        int nlinha = tabela.length;
        int ncoluna = tabela[0].length - 1;
        int cont=0,ideal=(nlinha)/2,maxf=0,colmax=0;
        
        
        
        for(int i=0; i<ncoluna;i++){
        	cont = 0;
            for(int j=0;j<nlinha;j++){
                if(tabela[j][i].equalsIgnoreCase("f") ){
                    cont++;
                }
            }
            if(Math.abs(cont-ideal)<Math.abs(maxf-ideal) && !askdQ.contains(i)){
                maxf=cont;
                colmax=i;
            }

        }
        askdQ.add(colmax);
        return colmax;
      }
      
  }