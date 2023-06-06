package interaction;

public class Interaction{
	private final String path;
	private final String file;
	
	private Save save;
	public Interaction() {
		path = "";
		file = "verwaltung.txt";
	}
	public Interaction(String path, String file) {
		this.path = path;
		this.file = file;
	}
	public Save save() {
		return save;
	}
	
}
