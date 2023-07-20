package s;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkverification {
	ChromeDriver dr;

@Before
public void a() {
	dr=new ChromeDriver();
dr.get("https://m.facebook.com/login/?locale=en_GB");
}
@Test
public void t()throws Exception {
	List<WebElement> linklist=dr.findElements(By.tagName("a"));
	System.out.println("no. of links"+linklist.size());
	for(WebElement li:linklist) {
		String url=li.getAttribute("href");
		verify(url);	
	}
}
private void verify(String url) throws Exception{
	URL u =new URL("https://m.facebook.com/login/?locale=en_GB");
	HttpURLConnection con=(HttpURLConnection)u.openConnection();
	if(con.getResponseCode()==200) 
	{
		System.out.println("success");
		
	
}
else if (con.getResponseCode()==404) {
	System.out.println("brokenlink");`
	
}
}
}

