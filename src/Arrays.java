import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

/**
 * There are a ton of list utilities but nothing for arrays.
 * Let's change that.
 * 
 * Note: All of these utilities are non-destructive.
 * 
 * Utility Methods:
 * E[] extend(E[] a, E[] b)
 * E[] extend(E[] a, E[] b, int padding);
 * E[] resize(E[] a, int scale);
 * E[] map(E[] a, Function func);
 * 
 * @author Andrew Lee
 */

@SuppressWarnings("unchecked")
public final class Arrays {
	private Arrays(){}
	
	public static <E> E[] extend(E[] a, E[] b, int padding){		
		assert a != null & b != null;
		assert a.length > 0;
		assert padding >= 0;
		
		E[] c = (E[]) Array.newInstance(a[0].getClass(), a.length + b.length + padding);
		
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		
		assert c != null;
		assert c.length > 0;
		assert c.length == a.length + b.length + padding;
		
		return c;
	}
	
	public static <E> E[] extend(E[] a, E[] b){
		return extend(a, b, 0);
	}
	
	public static <E> E[] resize(E[] a, double scale){
		assert a != null;
		assert a.length > 0;
		assert scale >= 1;
		
		E[] b = (E[]) Array.newInstance(a[0].getClass(), (int) (a.length * scale));
		
		assert b != null;
		assert b.length != 0;
		assert b.length == (int) (a.length * scale);
		
		System.arraycopy(a, 0, b, 0, a.length);
		
		return b;
	}
	
	public static <E> E[] map(E[] a, Function<E> func){
		assert a != null;
		assert func != null;
		assert a.length > 0;
		
		E[] b = (E[]) Array.newInstance(a[0].getClass(), a.length);
		
		assert b != null;
		assert b.length != 0;
		assert b.length == a.length;
		
		for(int n = 0; n < b.length; n++){
			assert 0 <= n && n <= b.length;
			
			try{
				Class<? extends Function<E>> f = (Class<? extends Function<E>>) func.getClass();
				Constructor<?> con = f.getDeclaredConstructor(new Class[0]);
				
				Function<E> exec = (Function<E>) con.newInstance();
				
				b[n] = (E) exec.exec(a[n]);
			}
			catch(Exception e){
				//Should never need to go here unless a malformed Map was passed.
				e.printStackTrace();
			}
		}
		
		return b;
	}
	
	public static <E> E[] reduce(E[] a, Function<E> func){
		return null;
	}
}