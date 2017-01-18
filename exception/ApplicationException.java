package exception;

public class ApplicationException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	Exception exception;
	
	public ApplicationException(Exception e) {
		this.exception = e;
	}

	@Override
	public String toString() {
		return "ApplicationException [e=" + exception.toString() + "]";
	}

	public Exception getE() {
		return exception;
	}

	public void setE(Exception e) {
		this.exception = e;
	}

}
