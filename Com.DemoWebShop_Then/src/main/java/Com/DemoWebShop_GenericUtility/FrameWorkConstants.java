package Com.DemoWebShop_GenericUtility;

public interface FrameWorkConstants {
	JavaUtility jUtil = new JavaUtility(); // to access java utility class properties creating object here
	String excelFilePath = "./src/test/resources/testData/addressDataN2.xlsx";

	String propertyFilePath = "./src/test/resources/testData/commonDataN2.properties";

	String screenshotPath = "./Screenshots/" + jUtil.localDateAndTime() + ".png";

	String reporsPath = "./Reports/" + jUtil.localDateAndTime() + ".html";

	String listenersScreenshotPath = "./ListenersScreenshot" + jUtil.localDateAndTime() + ".png";
}
