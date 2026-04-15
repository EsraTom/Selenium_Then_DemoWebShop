package Com.DemoWebShop_GenericUtility;

import java.time.LocalDateTime;

public class JavaUtility 
{
public String localDateAndTime()
{
	String date = LocalDateTime.now().toString().replace(":", "").replace("-","").replace(".","");
	return date;
}
}
