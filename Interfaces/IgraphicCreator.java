package Interfaces;
import java.util.Vector;

public interface IgraphicCreator extends ITableReceptacle{
	  public void update(String askedQuestion);
	  public void createGraphic();
	  public Vector<String> possibleDiseases();
}
