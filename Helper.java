import java.lang.reflect.Field;

public final class Helper {
	
	@SuppressWarnings("unchecked")
	public static <V> V get(Object object, String fieldName) {
	    Class<?> clazz = object.getClass();
	    while (clazz != null) {
	        try {
	            Field field = clazz.getDeclaredField(fieldName);
	            field.setAccessible(true);
	            return (V) field.get(object);
	        } catch (NoSuchFieldException e) {
	            clazz = clazz.getSuperclass();
	        } catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	    }
	    return null;
	}
	
//	public static Action<Void, Void> action(Runnable runnable) {
//	    return (v) -> {
//	        runnable.run();
//	        return null;
//	    };
//	}
}
