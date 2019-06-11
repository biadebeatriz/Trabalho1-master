
package Zumbi;
import Interfaces.*;
import graphicCreator.*;
import attTable.*;
import NextQuestion.*;
import View.*;
import zumbi.Interfaces.IRedutorPossibilidades.*;
//import zumbi.Componentes.*;
import zumbi.Componentes.RedutorPossibilidades.FabricaRedutor;

public class ConsultarG {
    public static void main(){

        // instanciando o componente DataSet
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("/home/DAITAN/bsiqueira/IdeaProjects/Trabalho1-master/zombie-health-spreadsheet-ml-training.csv");

// instanciando o componente paciente
        IPatient aPatient = new Patient();

// conectando-o no componente DataSet
        aPatient.connect(dataset);

// Instanciando o componente RedutorPossibilidades
        IRedutorPossibilidades redutor = FabricaRedutor.criaRedutor();

// instanciando o componente graphicCreator
        IgraphicCreator cgraphic = graphicCreatorFactory.create();
// Conectando-o ao componente dataset
        cgraphic.connect(dataset);

// instanciando o componente nextQuestion
        INextQuestion nextQuestion = NQFactory.create();
// conectando-a a componente dataset
        nextQuestion.connect(dataset);

         IView view = new View();


// Instanciando o componente attTable
        IattTable attTable = attTableFactory.create();
// Conectando-o ao componente dataset e redutor
        attTable.connect(dataset);
        attTable.connect(redutor);
        attTable.connect(view);

// Conectando-o ao componente graphiccreator e nextQuestion, segundo o pattern Observer
        attTable.attach(cgraphic);
        attTable.attach(nextQuestion);


// instanciando o componente doutor louco
        IDoctor cDoctor = new Doctor();
// conectando-o ao componente DataSet
        cDoctor.connect(dataset);
// conectando-o ao componente attTable
        cDoctor.connect(attTable);
// conectando-o ao componente nextQuestion
        cDoctor.connect(nextQuestion);
// conectando-o ao componente graphicCreator
        cDoctor.connect(cgraphic);
// conectando-o ao componente paciente
        cDoctor.connect(aPatient);
// executando a entrevista
        cDoctor.startInterview();


    }
}