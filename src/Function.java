public abstract class Function<E> {
	private final String NOT_IMPLEMENTED = "Method not defined in client implementation.";
	
	public E exec(){
		throw new UnsupportedOperationException(NOT_IMPLEMENTED);
	}
	
	public E exec(E ele){
		throw new UnsupportedOperationException(NOT_IMPLEMENTED);
	}
	
	public E exec(E... ele){
		throw new UnsupportedOperationException(NOT_IMPLEMENTED);
	}
}