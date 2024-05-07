
public enum commandenum {
	HELP("help"),
	QUIT("quit"),
	STATUS("status"),
	BACK("back"),
	GO("go"),
	LOOK("look"),
	LOCK("lock"),
	EXAMINE("examine"),
	TAKE("take"),
	DROP("drop"),
	INVENTORY("inventory"),
	UNPACK ("unpack"),
	PACK ("pack"),
	UNLOCK("unlock");
	

private final String text;

private commandenum(String text) {
this.text = text;
}

public String getText() {
	return text;
}
}