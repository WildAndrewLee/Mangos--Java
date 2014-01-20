public class Unit {
	public static void main(String[] args){
		String[] derp = {
				"this",
				"would",
				"be",
				"a",
				"test!"
		};
		
		String[] herp = {"world", "testing", "ExTenSIONs"};
		
		String[] test = Arrays.extend(derp, herp);
		
		test = Arrays.map(test, new Function<String>(){
			public String exec(String ele) {
				return ele.toUpperCase();
			}
		});
		
		for(String meh : test){
			System.out.println(meh);
		}
	}
}