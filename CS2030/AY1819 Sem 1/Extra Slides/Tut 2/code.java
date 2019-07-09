class Asdf {
	public static void main(String[] args) {

		Message m = new Message();
		m.setChat(chatId);
		m.setMessage("This is my message");
		m.send();

		HttpRequest r = new HttpRequest();
		r.setUrl("https://api.telegram.org/bot23413:2efawfefw/sendMessage");
		r.setArguments("chatId=12345&message=This is a message.");
		r.send();

		Chatbot bot = new Chatbot("23413:2efawfefw");
		int chatId = 23413;
		bot.sendMessage("This is a message");


		if (command.equals("help")) {
			sendMessage(23413, "This is some help text");
		} else if (command.equals("hello")) {
			sendMessage(23413, "Hello!");
		} else if (command.equals("weather")) {
			sendMessage(23413, "The weather is "+getWeather());
		}

		if (command.equals("help")) {
			processHelpCommand();
		} else if (command.equals("hello")) {
			processHelloCommand();
		} else if (command.equals("weather")) {
			processWeatherCommand();
		}

		server.serve(customer.getId());

		server.serve(customer);

	}

	public void sendRequest(String url, int chatId, String arguments) {
		HttpRequest r = new HttpRequest();
		r.setUrl(url);
		r.setArguments("chatId="+chatId+"&"+arguments);
		r.send();
	}

	public void sendMessage(int chatId, String message) {
		sendRequest("https://api.telegram.org/bot23413:2efawfefw/sendMessage",
			chatId, "message="+message);
	}

	public void sendLocation(int chatId, double lat, double lon) {
		sendRequest("https://api.telegram.org/bot23413:2efawfefw/sendLocation",
			chatId, "location="+location);
	}
}

class Chatbot {
	private String baseUrl = "https://api.telegram.org/bot";
	private String apiKey;

	public Chatbot(String apiKey) {
		this.apiKey = apiKey;
	}

	public void sendRequest(String url, int chatId, String arguments) {
		HttpRequest r = new HttpRequest();
		r.setUrl(url);
		r.setArguments("chatId="+chatId+"&"+arguments);
		r.send();
	}

	public void sendMessage(int chatId, String message) {
		sendRequest(this.baseUrl+this.apiKey+"/sendMessage",
			chatId, "message="+message);
	}

	public void sendLocation(int chatId, double lat, double lon) {
		sendRequest(this.baseUrl+this.apiKey+"/sendLocation",
			chatId, "location="+location);
	}
}

class Customer {
	private int id;
}









