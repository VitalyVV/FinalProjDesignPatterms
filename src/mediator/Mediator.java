package mediator;

import exceptions.NoTaskProjectException;
import exceptions.ParametersException;

public interface Mediator {
    void notify(Object object, String data) throws ParametersException, NoTaskProjectException;
}
