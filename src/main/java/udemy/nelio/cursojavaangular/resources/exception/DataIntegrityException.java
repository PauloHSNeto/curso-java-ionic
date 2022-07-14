package udemy.nelio.cursojavaangular.resources.exception;

public class DataIntegrityException extends RuntimeException{

    private final long serialVersionUID =1L;
    public DataIntegrityException(String msg){
        super(msg);
    }
    public DataIntegrityException(String msg, Throwable cause){

        super(msg,cause);
    }
}
