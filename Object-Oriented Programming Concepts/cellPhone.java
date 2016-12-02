interface cellPhone
{
	void makePhoneCall(int userId);
	void sendTextMsg(int userId, String msg);
}

class galaxyNexus implements cellPhone
{
	String name = "galaxyNexus";

	public void makePhoneCall(int userId)
	{
		System.out.println("Making phone call to user " + userId);
	}

	public void sendTextMsg(int userId, String msg)
	{
		System.out.println("Sending text messgage to  user " + userId);
		System.out.println("Text message is : " + msg);
	}

	public static void main(String[] args)
	{
		galaxyNexus phone = new galaxyNexus();
		phone.makePhoneCall(132);
		phone.sendTextMsg(132, "Hello, are you OK?");
	}
}
