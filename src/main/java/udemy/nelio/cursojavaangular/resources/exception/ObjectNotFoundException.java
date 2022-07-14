package udemy.nelio.cursojavaangular.resources.exception;

public class ObjectNotFoundException extends RuntimeException{

    private final long serialVersionUID =1L;
    public ObjectNotFoundException(String msg){
        super(msg);
    }
    public ObjectNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
}
