package Interfaces;

import graphicCreator.*;

public interface IEnquirer {
    public void startInterview();
    public void connect(IgraphicCreator graphicCreator);
    public void connect(IattTable attTable);
    public void connect(INextQuestion nextQuestion);
}
