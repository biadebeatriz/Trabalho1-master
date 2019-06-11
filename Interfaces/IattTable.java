package Interfaces;

import Zumbi.*;
import zumbi.Interfaces.IRedutorPossibilidades.*;
import Interfaces.*;

public interface IattTable extends ITableProducerReceptacle{
	public void attach(ITableReceptacle tableReceptacle);
	public void notifyReceptacle();
	public void update(int pergunta, String resposta);
	public void connect(IRedutorPossibilidades redutor);
	public void connect(IView view);
	public void giveDiagnostic(String doenca);
}
