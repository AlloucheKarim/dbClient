package dbGestion;

public class Client {
	private int id;
	private String nom;
	private int age;
	private String adresse;
	public Client(int id, String nom, int age, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
		this.adresse = adresse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", age=" + age + ", adresse=" + adresse + "]";
	}
	
	
	
}
