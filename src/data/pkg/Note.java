package data.pkg;




public class Note {
	
	
	private int Id; 
	private int AddedBy;
	private String AddedByName;
	private String NoteDate;
	private String Description ;
	private String Temperature; 
	private String Humidity;
	private String WindSpeed; 
	private boolean IsPredefined ;
	private int ValueFrom; 
	private int ValueTo;
	
	
	public String getNoteDate() {
		return NoteDate;
	}
	public void setNoteDate(String noteDate) {
		NoteDate = noteDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean getIsPredefined() {
		return IsPredefined;
	}
	public void setIsPredefined(boolean isPredefined) {
		IsPredefined = isPredefined;
	}
	public int getValueFrom() {
		return ValueFrom;
	}
	public void setValueFrom(int valueFrom) {
		ValueFrom = valueFrom;
	}
	public int getValueTo() {
		return ValueTo;
	}
	public void setValueTo(int valueTo) {
		ValueTo = valueTo;
	}
	public int getAddedBy() {
		return AddedBy;
	}
	public void setAddedBy(int addedBy) {
		AddedBy = addedBy;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAddedByName() {
		return AddedByName;
	}
	public void setAddedByName(String addedByName) {
		AddedByName = addedByName;
	}
	public String getTemperature() {
		return Temperature;
	}
	public void setTemperature(String temperature) {
		Temperature = temperature;
	}
	public String getHumidity() {
		return Humidity;
	}
	public void setHumidity(String humidity) {
		Humidity = humidity;
	}
	public String getWindSpeed() {
		return WindSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		WindSpeed = windSpeed;
	} 
}
