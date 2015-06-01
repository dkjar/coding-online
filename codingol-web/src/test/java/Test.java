
public class Test {

	public static void changeStr(Entity en){
		 
        en.setName("welcome");
 
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Entity e  =new Entity();
		 e.setName("1234");
        changeStr(e); 
        System.out.println(e.getName());
	}

}
 
class Entity {
	
	protected int method(int a, int b){return 0;}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	class Child extends Entity{
		public int method(int a, int b){return 0;}
	}

}



